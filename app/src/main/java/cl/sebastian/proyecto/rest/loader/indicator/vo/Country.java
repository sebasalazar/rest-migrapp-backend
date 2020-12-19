package cl.sebastian.proyecto.rest.loader.indicator.vo;

import cl.sebastian.proyecto.rest.persistence.model.BaseBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Country extends BaseBean {

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("value")
    private String value = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
