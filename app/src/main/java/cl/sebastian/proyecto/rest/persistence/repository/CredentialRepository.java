package cl.sebastian.proyecto.rest.persistence.repository;

import cl.sebastian.proyecto.rest.persistence.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {

    /**
     *
     * @param app Nombre de la credencial a buscar
     * @return La credencial usada
     */
    public Credential findByApp(String app);
}
