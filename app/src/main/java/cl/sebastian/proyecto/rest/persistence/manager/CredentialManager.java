package cl.sebastian.proyecto.rest.persistence.manager;

import cl.sebastian.proyecto.rest.persistence.model.Credential;
import cl.sebastian.proyecto.rest.persistence.repository.CredentialRepository;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("credentialManager")
public class CredentialManager implements Serializable {

    private static final long serialVersionUID = 2239241043926152192L;

    @Autowired
    private transient CredentialRepository credentialRepository;

    /**
     *
     * @param app Nombre de la aplicación
     * @return La credencial asociada
     */
    public Credential getCredential(final String app) {
        Credential credential = null;
        if (StringUtils.isNotBlank(app)) {
            credential = credentialRepository.findByApp(app);
        }
        return credential;
    }
}
