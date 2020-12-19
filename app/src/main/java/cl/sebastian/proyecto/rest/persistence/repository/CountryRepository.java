package cl.sebastian.proyecto.rest.persistence.repository;

import cl.sebastian.proyecto.rest.persistence.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    /**
     *
     * @param code Código ISO alpha 2
     * @return El país asociado al código
     */
    public Country findByCodeIgnoreCase(String code);
}
