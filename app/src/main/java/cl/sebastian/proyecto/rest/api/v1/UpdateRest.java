package cl.sebastian.proyecto.rest.api.v1;

import cl.sebastian.proyecto.rest.api.vo.ErrorVO;
import cl.sebastian.proyecto.rest.api.vo.IndicatorVO;
import cl.sebastian.proyecto.rest.exception.FailException;
import cl.sebastian.proyecto.rest.loader.country.CountryLoader;
import cl.sebastian.proyecto.rest.loader.indicator.IndicatorLoader;
import cl.sebastian.proyecto.rest.service.CacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/v1/update"}, consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
@Api(value = "Información relativa a los indicadores económicos")
public class UpdateRest implements Serializable {

    private static final long serialVersionUID = 4398033065945222144L;

    @Autowired
    private transient CacheService cacheService;
    @Autowired
    private transient CountryLoader countryLoader;
    @Autowired
    private transient IndicatorLoader indicatorLoader;

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateRest.class);

    @ApiOperation(value = "Actualiza los países.")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Indicadores actualizados", response = Void.class),
        @ApiResponse(code = 401, message = "No está autorizado a consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 500, message = "Error interno del servidor.", response = ErrorVO.class)
    })
    @PostMapping(value = "/countries", consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity countries(HttpServletRequest httpRequest,
            @ApiParam(name = "X-API-APP", value = "Identificador de Credencial de Autenticación", required = true) @RequestHeader("X-API-APP") String app,
            @ApiParam(name = "X-API-KEY", value = "Llave de Credencial de Autenticación", required = true) @RequestHeader("X-API-KEY") String key) {

        /**
         * Verificación de credenciales.
         */
        boolean authenticate = cacheService.authenticate(app, key);
        if (authenticate) {
            LOGGER.info("La credencial '{}' ha accedido al servicio", app);
        } else {
            throw new FailException(401);
        }

        LOGGER.info("=== Preparando Servicio API de Países ===");
        countryLoader.load();
        LOGGER.info("=== Servicio API de Países listo para usarse ===");

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Actualiza los indicadores.")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Indicadores actualizados", response = Void.class),
        @ApiResponse(code = 401, message = "No está autorizado a consumir este servicio.", response = ErrorVO.class),
        @ApiResponse(code = 500, message = "Error interno del servidor.", response = ErrorVO.class)
    })
    @PostMapping(value = "/indicators", consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity indicators(HttpServletRequest httpRequest,
            @ApiParam(name = "X-API-APP", value = "Identificador de Credencial de Autenticación", required = true) @RequestHeader("X-API-APP") String app,
            @ApiParam(name = "X-API-KEY", value = "Llave de Credencial de Autenticación", required = true) @RequestHeader("X-API-KEY") String key) {

        /**
         * Verificación de credenciales.
         */
        boolean authenticate = cacheService.authenticate(app, key);
        if (authenticate) {
            LOGGER.info("La credencial '{}' ha accedido al servicio", app);
        } else {
            throw new FailException(401);
        }

        LOGGER.info("=== Preparando Servicio API de Indicadores ===");
        indicatorLoader.load();
        LOGGER.info("=== Servicio API de Indicadores listo para usarse ===");

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
