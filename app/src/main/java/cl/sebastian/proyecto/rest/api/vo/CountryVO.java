package cl.sebastian.proyecto.rest.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "country")
@JsonRootName("country")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CountryVO extends BaseJson {

    @ApiModelProperty(value = "Código ISO 639-1 que representa el idoma", required = true, example = "es")
    private String lang = null;

    @ApiModelProperty(value = "Nombre del país según el código ISO 3166-1", required = true, example = "Chile")
    private String name = null;

    @ApiModelProperty(value = "Código Alpha 2 del país según el código ISO 3166-1", required = true, example = "CL")
    private String code = null;

    @ApiModelProperty(value = "Código Alpha 3 del país según el código ISO 3166-1", required = true, example = "CHL")
    private String abbr = null;

    @ApiModelProperty(value = "Nombre de la moneda nacional según el código ISO 4217", required = true, example = "Peso chileno")
    private String currencyName = null;

    @ApiModelProperty(value = "Código de la moneda nacional según el código ISO 4217", required = true, example = "CLP")
    private String currencyCode = null;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
