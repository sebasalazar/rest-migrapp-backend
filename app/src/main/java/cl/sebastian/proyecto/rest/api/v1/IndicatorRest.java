package cl.sebastian.proyecto.rest.api.v1;

import cl.sebastian.proyecto.rest.api.vo.ErrorVO;
import cl.sebastian.proyecto.rest.api.vo.IndicatorRequestVO;
import cl.sebastian.proyecto.rest.api.vo.IndicatorVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.Serializable;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/indicators"}, consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
@Api(value = "Información relativa a los indicadores económicos")
public class IndicatorRest implements Serializable {

    private static final long serialVersionUID = 5743847088743006208L;
    private static final Logger LOGGER = LoggerFactory.getLogger(IndicatorRest.class);

    @ApiOperation(value = "Obtiene la información de un indicador.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Objeto con la información del indicador", response = IndicatorVO.class),
        @ApiResponse(code = 400, message = "La petición es inválida.", response = ErrorVO.class),
        @ApiResponse(code = 401, message = "No está autorizado a consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 401, message = "Dato no encontrado.", response = ErrorVO.class),
        @ApiResponse(code = 403, message = "Las credenciales proporcionadas no permiten consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 412, message = "Ocurrió un error de validación", response = ErrorVO.class),
        @ApiResponse(code = 500, message = "Error interno del servidor.", response = ErrorVO.class)
    })
    @GetMapping(value = "/{countryCode}/{indicatorCode}/{year}/info", consumes = {"*/*"}, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity init(HttpServletRequest httpRequest,
            @ApiParam(name = "X-API-APP", value = "Identificador de Credencial de Autenticación", required = true) @RequestHeader("X-API-APP") String app,
            @ApiParam(name = "X-API-KEY", value = "Llave de Credencial de Autenticación", required = true) @RequestHeader("X-API-KEY") String key,
            @ApiParam(name = "code", value = "Código ISO 3166-1 alpha-2 del país", required = true) @PathVariable("countryCode") String countryCode,
            @ApiParam(name = "indicatorCode", value = "Código del indicador descrito en el proyecto", required = true) @PathVariable("indicatorCode") String indicatorCode,
            @ApiParam(name = "year", value = "Año de consulta", required = true) @PathVariable("year") Integer year) {
        return ResponseEntity.ok(new IndicatorVO());
    }

    @ApiOperation(value = "Obtiene la información de un(os) indicador(es).")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Objeto con la información del indicador", response = IndicatorVO.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "La petición es inválida.", response = ErrorVO.class),
        @ApiResponse(code = 401, message = "No está autorizado a consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 401, message = "Dato no encontrado.", response = ErrorVO.class),
        @ApiResponse(code = 403, message = "Las credenciales proporcionadas no permiten consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 412, message = "Ocurrió un error de validación", response = ErrorVO.class),
        @ApiResponse(code = 500, message = "Error interno del servidor.", response = ErrorVO.class)
    })
    @PostMapping(value = "/info", consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity init(HttpServletRequest httpRequest,
            @ApiParam(name = "X-API-APP", value = "Identificador de Credencial de Autenticación", required = true) @RequestHeader("X-API-APP") String app,
            @ApiParam(name = "X-API-KEY", value = "Llave de Credencial de Autenticación", required = true) @RequestHeader("X-API-KEY") String key,
            @ApiParam(name = "request", value = "Petición de consulta", required = true) @RequestBody IndicatorRequestVO request) {
        return ResponseEntity.ok(new ArrayList<IndicatorVO>());
    }
}
