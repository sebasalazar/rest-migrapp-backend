package cl.sebastian.proyecto.rest.loader.indicator;

import cl.sebastian.proyecto.rest.loader.country.vo.RestCountry;
import cl.sebastian.proyecto.rest.persistence.manager.CountryManager;
import cl.sebastian.proyecto.rest.persistence.manager.IndicatorManager;
import cl.sebastian.proyecto.rest.persistence.model.Code;
import cl.sebastian.proyecto.rest.persistence.model.Country;
import cl.sebastian.proyecto.rest.persistence.model.Indicator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URI;
import java.time.Year;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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

    public void saveIndicator(final Code code, final Country country, final Integer year, final BigDecimal value, final Date created) {
        try {
            Indicator indicator = indicatorManager.getIndicator(country, code, year);
            if (indicator == null) {
                indicator = new Indicator();
                indicator.setCode(code);
                indicator.setCountry(country);
                indicator.setCreated(created);
                indicator.setYear(year);
                indicator.setValue(value);
                indicator.setUpdated(new Date());
                indicatorManager.save(indicator);
            }
        } catch (Exception e) {
            LOGGER.error("Error al guardar indicador: {}", e.getMessage());
            LOGGER.debug("Error al guardar indicador: {}", e.getMessage(), e);
        }
    }

    @Async
    public void processDBI(final Country country, final Date created) {
        try {
            // Ejempo http://api.worldbank.org/v2/country/CHL/indicator/NY.GDP.MKTP.CD?format=json
            final String url = String.format("%s/%s/indicator/%s?format=json", WB_API_URL, country.getAbbr(), Code.DBI.worldBank());
            if (UrlValidator.getInstance().isValid(url)) {

                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.getForEntity(new URI(url), String.class);
                if (response.getStatusCode().isError()) {
                    LOGGER.error("El servicio responde con error {}", response.getStatusCode());
                } else {
                    String body = StringUtils.trimToEmpty(response.getBody());

                    ObjectMapper mapper = new ObjectMapper();
                    List<RestCountry> countries = mapper.readValue(body,
                            new TypeReference<List<RestCountry>>() {
                    });

                    if (CollectionUtils.isNotEmpty(countries)) {
                        for (RestCountry rest : countries) {

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
    }

    @Async
    public void processIFL(final Country country, final Date created) {
        try {

        } catch (Exception e) {
            LOGGER.error("Error al procesar indicador: {}", e.getMessage());
            LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
        }
    }

    @Async
    public void processIVA(final Country country, final Date created) {
        try {

        } catch (Exception e) {
            LOGGER.error("Error al procesar indicador: {}", e.getMessage());
            LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
        }
    }

    @Async
    public void processPIB(final Country country, final Date created) {
        try {

        } catch (Exception e) {
            LOGGER.error("Error al procesar indicador: {}", e.getMessage());
            LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
        }
    }

    @Async
    public void processPRF(final Country country, final Date created) {
        try {

        } catch (Exception e) {
            LOGGER.error("Error al procesar indicador: {}", e.getMessage());
            LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
        }
    }

    @Async
    public void processSMI(final Country country, final Date created) {
        try {

        } catch (Exception e) {
            LOGGER.error("Error al procesar indicador: {}", e.getMessage());
            LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
        }
    }

    @Async
    public void processTDA(final Country country, final Date created) {
        try {

        } catch (Exception e) {
            LOGGER.error("Error al procesar indicador: {}", e.getMessage());
            LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
        }
    }

    @Async
    public void processTSC(final Country country, final Date created) {
        try {

        } catch (Exception e) {
            LOGGER.error("Error al procesar indicador: {}", e.getMessage());
            LOGGER.debug("Error al procesar indicador: {}", e.getMessage(), e);
        }
    }

    public void load() {
        try {
            List<Country> countries = countryManager.getCountries();
            if (CollectionUtils.isNotEmpty(countries)) {
                for (Country country : countries) {
                    Date created = new Date();
                    int currentYear = Year.now().getValue();
                    LOGGER.info("Año más reciente: {}", currentYear);

                    processDBI(country, created);
                    processIFL(country, created);
                    processIVA(country, created);
                    processPIB(country, created);
                    processPRF(country, created);
                    processSMI(country, created);
                    processTDA(country, created);
                    processTSC(country, created);

                }
            }
        } catch (Exception e) {
            LOGGER.error("Error al cargar datos: {}", e.getMessage());
            LOGGER.debug("Error al cargar datos: {}", e.getMessage(), e);
        }
    }
}
