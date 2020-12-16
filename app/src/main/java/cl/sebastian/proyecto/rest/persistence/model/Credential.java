package cl.sebastian.proyecto.rest.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credentials")
public class Credential extends PkEntityBase {

    @Column(name = "app", nullable = false, unique = true)
    private String app = null;
    @Column(name = "key", nullable = false)
    private String key = null;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
