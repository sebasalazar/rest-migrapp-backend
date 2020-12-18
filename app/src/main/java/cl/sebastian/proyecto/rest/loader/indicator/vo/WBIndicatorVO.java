package cl.sebastian.proyecto.rest.loader.indicator.vo;

import cl.sebastian.proyecto.rest.persistence.model.BaseBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WBIndicatorVO extends BaseBean {

    @JsonProperty("indicator")
    private Indicator indicator = null;

    @JsonProperty("country")
    private Country country = null;

    @JsonProperty("countryiso3code")
    private String countryiso3code = null;

    @JsonProperty("date")
    private String date = null;

    @JsonProperty("value")
    private String value = null;

    @JsonProperty("unit")
    private String unit = null;

    @JsonProperty("obs_status")
    private String obsStatus = null;

    @JsonProperty("decimal")
    private String decimal = null;

    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCountryiso3code() {
        return countryiso3code;
    }

    public void setCountryiso3code(String countryiso3code) {
        this.countryiso3code = countryiso3code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getObsStatus() {
        return obsStatus;
    }

    public void setObsStatus(String obsStatus) {
        this.obsStatus = obsStatus;
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }
}
