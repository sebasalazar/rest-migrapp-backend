package cl.sebastian.proyecto.rest.api.v1;

import cl.sebastian.proyecto.rest.api.vo.CountryVO;
import cl.sebastian.proyecto.rest.api.vo.ErrorVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/countries"}, consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
@Api(value = "Información relativa a los países")
public class CountryRest implements Serializable {

    private static final long serialVersionUID = 5743847088743006208L;
    private static final Logger LOGGER = LoggerFactory.getLogger(IndicatorRest.class);

    @ApiOperation(value = "Obtiene la información del país.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Objeto con la información del país", response = CountryVO.class),
        @ApiResponse(code = 400, message = "La petición es inválida.", response = ErrorVO.class),
        @ApiResponse(code = 401, message = "No está autorizado a consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 403, message = "Las credenciales proporcionadas no permiten consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 412, message = "Ocurrió un error de validación", response = ErrorVO.class),
        @ApiResponse(code = 500, message = "Error interno del servidor.", response = ErrorVO.class)
    })
    @GetMapping(value = "/{code}/info", consumes = {"*/*"}, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity byCode(HttpServletRequest httpRequest,
            @ApiParam(name = "X-API-APP", value = "Identificador de Credencial de Autenticación", required = true) @RequestHeader("X-API-APP") String app,
            @ApiParam(name = "X-API-KEY", value = "Llave de Credencial de Autenticación", required = true) @RequestHeader("X-API-KEY") String key,
            @ApiParam(name = "code", value = "Código ISO 3166-1 alpha-2 del país", required = true) @PathVariable("code") String code) {
        LOGGER.debug("Petición de país");
        return ResponseEntity.ok(new CountryVO());
    }

    @ApiOperation(value = "Obtiene la información de todos los paises del sistema.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Objeto con la información del país", response = CountryVO.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "La petición es inválida.", response = ErrorVO.class),
        @ApiResponse(code = 401, message = "No está autorizado a consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 403, message = "Las credenciales proporcionadas no permiten consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 412, message = "Ocurrió un error de validación", response = ErrorVO.class),
        @ApiResponse(code = 500, message = "Error interno del servidor.", response = ErrorVO.class)
    })
    @GetMapping(value = "/all", consumes = {"*/*"}, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity all(HttpServletRequest httpRequest,
            @ApiParam(name = "X-API-APP", value = "Identificador de Credencial de Autenticación", required = true) @RequestHeader("X-API-APP") String app,
            @ApiParam(name = "X-API-KEY", value = "Llave de Credencial de Autenticación", required = true) @RequestHeader("X-API-KEY") String key) {
        LOGGER.debug("Petición de paises");

        List<CountryVO> countries = new ArrayList<>();
        return ResponseEntity.ok(countries);
    }
}
