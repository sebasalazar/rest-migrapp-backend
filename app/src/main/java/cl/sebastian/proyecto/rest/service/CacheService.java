package cl.sebastian.proyecto.rest.service;

import cl.sebastian.proyecto.rest.persistence.manager.CountryManager;
import cl.sebastian.proyecto.rest.persistence.manager.CredentialManager;
import cl.sebastian.proyecto.rest.persistence.manager.IndicatorManager;
import cl.sebastian.proyecto.rest.persistence.model.Code;
import cl.sebastian.proyecto.rest.persistence.model.Country;
import cl.sebastian.proyecto.rest.persistence.model.Credential;
import cl.sebastian.proyecto.rest.persistence.model.Indicator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("cacheService")
public class CacheService implements Serializable {

    private static final long serialVersionUID = 5958805771039571968L;

    @Autowired
    private transient CredentialManager credentialManager;
    @Autowired
    private transient CountryManager countryManager;
    @Autowired
    private transient IndicatorManager indicatorManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    @PostConstruct
    public void initService() {
        try {
            LOGGER.info("Iniciando Servicio Caché");
            clearChache();
        } catch (Exception e) {
            LOGGER.error("Error iniciando Servicio Caché: {}", e.getMessage());
            LOGGER.debug("Error iniciando Servicio Caché: {}", e.getMessage(), e);
        }
    }

    @CacheEvict(cacheNames = "INFB8090", allEntries = true)
    public void clearChache() {
        LOGGER.info("Limpiando Caché");
    }

    @Cacheable("INFB8090")
    public boolean authenticate(final String apiApp, final String apiKey) {
        boolean ok = false;
        try {
            final String app = StringUtils.trimToEmpty(apiApp);
            final String key = StringUtils.trimToEmpty(apiKey);

            if (!StringUtils.isAnyBlank(app, key)) {
                Credential credential = credentialManager.getCredential(app);
                if (credential != null) {
                    ok = StringUtils.equals(key, credential.getKey());
                }
            }
        } catch (Exception e) {
            ok = false;
            LOGGER.error("Error al autenticar: {}", e.getMessage());
            LOGGER.debug("Error al autenticar: {}", e.getMessage(), e);
        }
        return ok;
    }

    @Cacheable("INFB8090")
    public Country getCountry(final String code) {
        Country country = null;
        try {
            if (StringUtils.isNotBlank(code)) {
                final String alpha2 = StringUtils.trimToEmpty(code);
                if (StringUtils.isNotBlank(alpha2)) {
                    country = countryManager.getCountry(alpha2);
                }
            }
        } catch (Exception e) {
            country = null;
            LOGGER.error("Error al consultar País: {}", e.getMessage());
            LOGGER.debug("Error al consultar País: {}", e.getMessage(), e);
        }
        return country;
    }

    @Cacheable("INFB8090")
    public List<Country> getCountries() {
        List<Country> countries;
        try {
            countries = countryManager.getCountries();
        } catch (Exception e) {
            countries = new ArrayList<>();
            LOGGER.error("Error al consultar País: {}", e.getMessage());
            LOGGER.debug("Error al consultar País: {}", e.getMessage(), e);
        }
        return countries;
    }

    @Cacheable("INFB8090")
    public Code getCode(final String indicatorCode) {
        Code code = null;
        try {
            if (StringUtils.isNotBlank(indicatorCode)) {
                final String indicator = StringUtils.upperCase(StringUtils.trimToEmpty(indicatorCode));
                code = Code.valueOf(indicator);
            }
        } catch (Exception e) {
            code = null;
            LOGGER.error("Error al obtener código del indicador: {}", e.getMessage());
            LOGGER.debug("Error al obtener código del indicador: {}", e.getMessage(), e);
        }
        return code;
    }

    @Cacheable("INFB8090")
    public Indicator getIndicator(final Country country, final Code code, final Integer year) {
        Indicator indicator = null;
        try {
            if (country != null && code != null && year != null) {
                indicator = indicatorManager.getIndicator(country, code, year);
            }
        } catch (Exception e) {
            indicator = null;
            LOGGER.error("Error al obtener indicador: {}", e.getMessage());
            LOGGER.debug("Error al obtener indicador: {}", e.getMessage(), e);
        }
        return indicator;
    }

    @Cacheable("INFB8090")
    public List<Indicator> getIndicators(final Country country, final Code code, final Integer startYear, final Integer endYear) {
        List<Indicator> indicators = new ArrayList<>();
        try {
            if (country != null && code != null) {
                indicators = indicatorManager.getIndicators(country, code, startYear, endYear);
            }
        } catch (Exception e) {
            indicators = new ArrayList<>();
            LOGGER.error("Error al obtener indicador: {}", e.getMessage());
            LOGGER.debug("Error al obtener indicador: {}", e.getMessage(), e);
        }
        return indicators;
    }
}
