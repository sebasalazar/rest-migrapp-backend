package cl.sebastian.proyecto.rest.persistence.model;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * Objeto BaseBean para las entidades del sistema
 */
public class BaseBean implements Serializable {

    private static final long serialVersionUID = 8851212656347053056L;

    /**
     *
     * @return Una versión que genera una string en formato humano.
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
