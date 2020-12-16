package cl.sebastian.proyecto.rest.loader.country;

import cl.sebastian.proyecto.rest.loader.country.vo.RestCountry;
import cl.sebastian.proyecto.rest.persistence.manager.CountryManager;
import cl.sebastian.proyecto.rest.persistence.model.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
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

@Service("countryLoader")
public class CountryLoader implements Serializable {

    private static final long serialVersionUID = 1561555751212025344L;

    @Autowired
    private transient CountryManager countryManager;

    private static final String COUNTRY_API_URL = "https://restcountries.eu/rest/v2/all";
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryLoader.class);

    @Async
    public void saveCountry(Date created, RestCountry data) {
        try {
            String code = StringUtils.upperCase(StringUtils.trimToEmpty(data.getAlpha2Code()));
            Country country = countryManager.getCountry(code);
            if (country == null) {
                country = new Country();
                country.setAbbr(StringUtils.upperCase(StringUtils.trimToEmpty(data.getAlpha3Code())));
                country.setActive(true);
                country.setCode(code);
                country.setCreated(created);
                country.setCurrencyCode(0);
                country.setCurrencyIso(StringUtils.upperCase(StringUtils.trimToEmpty(data.getCurrencies().get(0).getCode())));
                country.setCurrencyName(StringUtils.trimToEmpty(data.getCurrencies().get(0).getName()));
                country.setDecimalPrecision(0);
                country.setLang(StringUtils.trimToEmpty(data.getLanguages().get(0).getIso6391()));
                country.setName(StringUtils.trimToEmpty(data.getName()));
                country.setUpdated(new Date());
                countryManager.save(country);
            }
        } catch (Exception e) {
            LOGGER.error("Error al guardar país: {}", e.getMessage(), e);
            LOGGER.debug("Error al guardar país: {}", e.getMessage(), e);
        }
    }

    public void load() {
        try {
            if (UrlValidator.getInstance().isValid(COUNTRY_API_URL)) {
                Date created = new Date();
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.getForEntity(new URI(COUNTRY_API_URL), String.class);
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
                            saveCountry(created, rest);
                        }
                    }
                }
            } else {
                LOGGER.error("Url '{}' incorrecta", COUNTRY_API_URL);
            }
        } catch (Exception e) {
            LOGGER.error("Error al cargar datos: {}", e.getMessage());
            LOGGER.debug("Error al cargar datos: {}", e.getMessage(), e);
        }
    }
}
