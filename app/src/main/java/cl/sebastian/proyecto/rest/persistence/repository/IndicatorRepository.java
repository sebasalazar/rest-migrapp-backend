package cl.sebastian.proyecto.rest.persistence.repository;

import cl.sebastian.proyecto.rest.persistence.model.Code;
import cl.sebastian.proyecto.rest.persistence.model.Country;
import cl.sebastian.proyecto.rest.persistence.model.Indicator;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorRepository extends JpaRepository<Indicator, Long> {

    /**
     *
     * @param country País del indicador
     * @param code Código del indicador
     * @param year Año del indicador
     * @return El indicador asociado
     */
    public Indicator findByCountryAndCodeAndYear(Country country, Code code, Integer year);

    /**
     *
     * @param country País
     * @param code Código del indicador
     * @param startYear Año de inicio
     * @param endYear Año de termino
     * @return Indicadores
     */
    public List<Indicator> findByCountryAndCodeAndYearBetween(Country country, Code code, Integer startYear, Integer endYear);
}
