package cl.sebastian.proyecto.rest.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

@ApiModel(value = "error")
@JsonRootName("error")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorVO extends BaseJson {

    private static final long serialVersionUID = 6314335557508817920L;

    @ApiModelProperty(value = "Estado del objeto", required = true, allowableValues = "true, false", example = "false")
    private boolean ok = false;

    @ApiModelProperty(value = "Mensaje de la respuesta", required = true, example = "Error desconocido")
    private String message = null;

    @ApiModelProperty(value = "Fecha del message", required = true, example = "2018-11-21 13:21:52")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date = null;

    public ErrorVO() {
        this.ok = false;
        this.message = "Error desconocido";
        this.date = new Date();
    }

    public ErrorVO(String message) {
        this.ok = false;
        this.message = StringUtils.trimToEmpty(message);
        this.date = new Date();
    }

    public ErrorVO(Integer code, String message) {
        this.ok = false;
        this.message = StringUtils.trimToEmpty(message);
        this.date = new Date();
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
