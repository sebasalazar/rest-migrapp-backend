package cl.sebastian.proyecto.rest.loader.indicator;

import cl.sebastian.proyecto.rest.loader.indicator.vo.WBIndicatorVO;
import cl.sebastian.proyecto.rest.persistence.manager.CountryManager;
import cl.sebastian.proyecto.rest.persistence.manager.IndicatorManager;
import cl.sebastian.proyecto.rest.persistence.model.Code;
import cl.sebastian.proyecto.rest.persistence.model.Country;
import cl.sebastian.proyecto.rest.persistence.model.Indicator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.time.Year;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("indicatorLoader")
public class IndicatorLoader implements Serializable {

    private static final long serialVersionUID = 3648572432315969024L;

    @Autowired
    private transient CountryManager countryManager;
    @Autowired
    private transient IndicatorManager indicatorManager;

    private static final String WB_API_URL = "http://api.worldbank.org/v2/country";
    private static final Logger LOGGER = LoggerFactory.getLogger(IndicatorLoader.class);

    @Async
    public void saveIndicator(final Code code, final Country country, final Integer year, final String value, final Date created) {
        try {
            Indicator indicator = indicatorManager.getIndicator(country, code, year);
            if (indicator == null) {
                if (StringUtils.isNotBlank(value) && year > 1900) {
                    BigDecimal indicatorValue = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);

                    indicator = new Indicator();
                    indicator.setCode(code);
                    indicator.setCountry(country);
                    indicator.setCreated(created);
                    indicator.setYear(year);
                    indicator.setValue(indicatorValue);
                    indicator.setUpdated(new Date());
                    indicatorManager.save(indicator);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error al guardar indicador: {}", e.getMessage());
            LOGGER.debug("Error al guardar indicador: {}", e.getMessage(), e);
        }
    }

    public void process(final Code code, final Country country, final Date created) {
        try {
            try {
                // Ejempo http://api.worldbank.org/v2/country/CHL/indicator/NY.GDP.MKTP.CD?format=json
                final String url = String.format("%s/%s/indicator/%s?format=json&per_page=125", WB_API_URL, country.getAbbr(), code.worldBank());
                if (UrlValidator.getInstance().isValid(url)) {
                    LOGGER.info("Accediendo a la URL '{}'", url);

                    /**
                     * Llamada servicos REST
                     */
                    RestTemplate restTemplate = new RestTemplate();
                    ResponseEntity<String> response = restTemplate.getForEntity(new URI(url), String.class);
                    if (response.getStatusCode().isError()) {
                        LOGGER.error("El servicio responde con error '{}' en código '{}'", response.getStatusCode(), code);
                    } else {
                        String body = StringUtils.trimToEmpty(response.getBody());
                        LOGGER.debug(body);

                        ObjectMapper mapper = new ObjectMapper();
                        List<Object> list = mapper.readValue(body, new TypeReference<List<Object>>() {
                        });

                        if (CollectionUtils.isNotEmpty(list)) {
                            if (list.size() >= 2) {
                                Object data = list.get(1);
                                String json = mapper.writeValueAsString(data);
                                List<WBIndicatorVO> vos = mapper.readValue(json, new TypeReference<List<WBIndicatorVO>>() {
                                });

                                if (CollectionUtils.isNotEmpty(vos)) {
                                    for (WBIndicatorVO vo : vos) {
                                        Integer year = NumberUtils.toInt(vo.getDate());
                                        String value = StringUtils.trimToEmpty(vo.getValue());

                                        /**
                                         * Tratamos de persistir en DB
                                         */
                                        saveIndicator(code, country, year, value, created);
                                    }
                                }
                            }
                        }
                    }

                } else {
                    LOGGER.error("Url '{}' inválida", url);
                }
            } catch (Exception e) {
                LOGGER.error("Error al procesar indicador: {}", e.getMessage());
                LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
            }
        } catch (Exception e) {
            LOGGER.error("Error al procesar indicador: {}", e.getMessage());
            LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
        }
    }

    public void load() {
        try {
            List<Country> countries = countryManager.getCountries();
            if (CollectionUtils.isNotEmpty(countries)) {
                Date created = new Date();
                countries.forEach(country -> {
                    int currentYear = Year.now().getValue();

                    Code[] values = Code.values();
                    for (Code code : values) {
                        LOGGER.info("=== País '{}' # Indicador '{}' # Año más reciente: '{}' ===",
                                country.getName(), code.name(), currentYear);

                        if (Code.SMI.equals(code)) {
                            /**
                             * Salario Mínimo.
                             *
                             * Este dato se tiene que buscar en otra fuente.
                             */
                        } else {
                            /**
                             * Estos datos se obtienen desde el Banco mundial
                             */
                            process(code, country, created);
                        }
                    }
                });
            }
        } catch (Exception e) {
            LOGGER.error("Error al cargar datos: {}", e.getMessage());
            LOGGER.debug("Error al cargar datos: {}", e.getMessage(), e);
        }
    }
}
