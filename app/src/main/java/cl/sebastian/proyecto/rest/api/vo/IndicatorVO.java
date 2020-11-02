package cl.sebastian.proyecto.rest.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "indicator")
@JsonRootName("indicator")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IndicatorVO extends BaseJson {

    @ApiModelProperty(value = "País asociado al indicador", required = true)
    private CountryVO country = null;

    @ApiModelProperty(value = "Año del indicador", required = true, example = "2019")
    private Integer year = null;

    @ApiModelProperty(value = "Código del indicador descrito en el proyecto", required = true, example = "PIB")
    private String code = null;

    @ApiModelProperty(value = "Nombre del indicador descrito en el proyecto", required = true, example = "Producto Interno Bruto")
    private String name = null;

    @ApiModelProperty(value = "Descripción del indicador descrito en el proyecto", required = true, 
            example = "En macroeconomía, el producto interno bruto (PIB), conocido también como producto interior o producto bruto interno (PBI), "
                    + "es una magnitud macroeconómica que expresa el valor monetario de la producción de bienes y servicios de demanda final de un país "
                    + "o región durante un período determinado, normalmente de un año o trimestrales.")
    private String description = null;
    
    @ApiModelProperty(value = "Valor del indicador descrito en el proyecto", required = true, example = "282318159740")
    private BigDecimal value = null;
    
    @ApiModelProperty(value = "Unidad del indicador descrito en el proyecto", required = true, example = "US$")
    private String unit = null;

    public CountryVO getCountry() {
        return country;
    }

    public void setCountry(CountryVO country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
