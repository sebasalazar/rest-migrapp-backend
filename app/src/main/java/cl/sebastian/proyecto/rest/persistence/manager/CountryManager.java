package cl.sebastian.proyecto.rest.persistence.manager;

import cl.sebastian.proyecto.rest.persistence.model.Country;
import cl.sebastian.proyecto.rest.persistence.repository.CountryRepository;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("countryManager")
public class CountryManager implements Serializable {

    private static final long serialVersionUID = 9022347187079529472L;

    @Autowired
    private transient CountryRepository countryRepository;

    /**
     *
     * @param code ISO Alpha 2
     * @return El país
     */
    public Country getCountry(final String code) {
        Country country = null;
        if (StringUtils.isNotBlank(code)) {
            country = countryRepository.findByCode(code);
        }
        return country;
    }

    @Transactional
    public Country save(final Country country) {
        Country saved = null;
        if (country != null) {
            saved = countryRepository.save(country);
        }
        return saved;
    }
}
