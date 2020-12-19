package cl.sebastian.proyecto.rest.persistence.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase base de entidades con ID autoincrementable.
 */
@MappedSuperclass
public class PkEntityBase extends BaseBean {

    private static final long serialVersionUID = 1234212656347053056L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Long id = null;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    protected Date created = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    protected Date updated = new Date();

    /**
     *
     * @return Identificador único autoincremental
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id Identificador único autoincremental
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return Fecha de creación
     */
    public Date getCreated() {
        return created;
    }

    /**
     *
     * @param created Fecha de creación
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     *
     * @return Fecha de última actualización
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     *
     * @param updated Fecha de última actualización
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PkEntityBase other = (PkEntityBase) obj;
        return Objects.equals(this.id, other.id);
    }
}
