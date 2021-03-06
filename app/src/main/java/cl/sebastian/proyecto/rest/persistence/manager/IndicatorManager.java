package cl.sebastian.proyecto.rest.persistence.manager;

import cl.sebastian.proyecto.rest.persistence.model.Code;
import cl.sebastian.proyecto.rest.persistence.model.Country;
import cl.sebastian.proyecto.rest.persistence.model.Indicator;
import cl.sebastian.proyecto.rest.persistence.repository.IndicatorRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("indicatorManager")
public class IndicatorManager implements Serializable {

    private static final long serialVersionUID = 1900708775780618240L;

    @Autowired
    private transient IndicatorRepository indicatorRepository;

    /**
     *
     * @param country País
     * @param code Código del indicador
     * @param year Año de búsqueda
     * @return El indicador asociados a los parámetros de búsqueda.
     */
    public Indicator getIndicator(final Country country, final Code code, final Integer year) {
        Indicator indicator = null;
        if (country != null && code != null && year > 1900) {
            indicator = indicatorRepository.findByCountryAndCodeAndYear(country, code, year);
        }
        return indicator;
    }

    /**
     *
     * @param country País
     * @param code Código del indicador
     * @param startYear Año de inicio
     * @param endYear Año de termino
     * @return Indicadores
     */
    public List<Indicator> getIndicators(final Country country, final Code code, final Integer startYear, final Integer endYear) {
        List<Indicator> indicators = new ArrayList<>();
        if (country != null && code != null) {
            indicators = indicatorRepository.findByCountryAndCodeAndYearBetween(country, code, startYear, endYear);
        }
        return indicators;
    }

    /**
     *
     * @param indicator Indicador a persistir
     * @return El indicador persistido
     */
    @Transactional
    public Indicator save(final Indicator indicator) {
        Indicator saved = null;
        if (indicator != null) {
            saved = indicatorRepository.save(indicator);
        }
        return saved;
    }
}
