package cl.sebastian.proyecto.rest.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IndicatorRequest")
@JsonRootName("IndicatorRequest")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IndicatorRequestVO extends BaseJson {

    @ApiModelProperty(value = "Código Alpha 2 del país según el código ISO 3166-1", required = true, example = "CL")
    private String countryCode = null;

    @ApiModelProperty(value = "Código del indicador descrito en el proyecto", required = true, example = "PIB")
    private String indicatorCode = null;

    @ApiModelProperty(value = "Año de inicio de la consulta", required = true, example = "2017")
    private Integer startYear = null;

    @ApiModelProperty(value = "Año de termino de la consulta", required = true, example = "2019")
    private Integer endYear = null;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIndicatorCode() {
        return indicatorCode;
    }

    public void setIndicatorCode(String indicatorCode) {
        this.indicatorCode = indicatorCode;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
}
