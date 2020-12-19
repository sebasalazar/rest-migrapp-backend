package cl.sebastian.proyecto.rest.api.v1;

import cl.sebastian.proyecto.rest.api.vo.ErrorVO;
import cl.sebastian.proyecto.rest.api.vo.IndicatorRequestVO;
import cl.sebastian.proyecto.rest.api.vo.IndicatorVO;
import cl.sebastian.proyecto.rest.exception.FailException;
import cl.sebastian.proyecto.rest.loader.indicator.IndicatorLoader;
import cl.sebastian.proyecto.rest.persistence.model.Code;
import cl.sebastian.proyecto.rest.persistence.model.Country;
import cl.sebastian.proyecto.rest.persistence.model.Indicator;
import cl.sebastian.proyecto.rest.service.CacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/v1/indicators"}, consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
@Api(value = "Información relativa a los indicadores económicos")
public class IndicatorRest implements Serializable {

    private static final long serialVersionUID = 5743847088743006208L;

    @Autowired
    private transient IndicatorLoader indicatorLoader;
    @Autowired
    private transient CacheService cacheService;
    private static final Logger LOGGER = LoggerFactory.getLogger(IndicatorRest.class);

    @PostConstruct
    public void initRest() {
        LOGGER.info("=== Preparando Servicio API de Indicadores ===");
        indicatorLoader.load();
        LOGGER.info("=== Servicio API de Indicadores listo para usarse ===");
    }

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
        /**
         * Verificación de credenciales.
         */
        boolean authenticate = cacheService.authenticate(app, key);
        if (authenticate) {
            LOGGER.info("La credencial '{}' ha accedido al servicio", app);
        } else {
            throw new FailException(401);
        }

        /**
         * Verificamos el código de país
         */
        if (StringUtils.length(countryCode) != 2) {
            throw new FailException(400, "El código de país es incorrecto");
        }

        /**
         * Buscamos el país en la base de datos.
         */
        Country country = cacheService.getCountry(countryCode);
        if (country == null) {
            throw new FailException(404, String.format("El código de país '%s' NO fue encontrado", countryCode));
        }

        /**
         * Buscamos el código asociado al indicador
         */
        Code code = cacheService.getCode(indicatorCode);
        if (code == null) {
            throw new FailException(404, String.format("El código del indicador '%s' NO fue encontrado", indicatorCode));
        }

        /**
         * Validación de año No hay datos anteriores a 1950 ni posteriores al
         * año en curso.
         */
        int minYear = 1950;
        int maxYear = Year.now().getValue();
        if (year == null || year < minYear || year > maxYear) {
            throw new FailException("No hay datos para el año requerido");
        }

        /**
         * Buscamos el indicador en el sistema
         */
        Indicator indicator = cacheService.getIndicator(country, code, year);
        if (indicator == null) {
            throw new FailException(404, String.format("El indicador '%s' NO fue encontrado para el país '%s' para el año '%d'",
                    code.getName(), country.getName(), year));
        }

        return ResponseEntity.ok(new IndicatorVO(indicator));
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
        /**
         * Verificación de credenciales.
         */
        boolean authenticate = cacheService.authenticate(app, key);
        if (authenticate) {
            LOGGER.info("La credencial '{}' ha accedido al servicio", app);
        } else {
            throw new FailException(401);
        }

        /**
         * Si no hay una petición válida se retornar con error.
         */
        if (request == null) {
            throw new FailException(400);
        }

        /**
         * Verificamos el código de país
         */
        String countryCode = StringUtils.trimToEmpty(request.getCountryCode());
        if (StringUtils.length(countryCode) != 2) {
            throw new FailException(400, "El código de país es incorrecto");
        }

        /**
         * Buscamos el país en la base de datos.
         */
        Country country = cacheService.getCountry(countryCode);
        if (country == null) {
            throw new FailException(404, String.format("El código de país '%s' NO fue encontrado", countryCode));
        }

        /**
         * Buscamos el código asociado al indicador
         */
        String indicatorCode = request.getIndicatorCode();
        Code code = cacheService.getCode(indicatorCode);
        if (code == null) {
            throw new FailException(404, String.format("El código del indicador '%s' NO fue encontrado", indicatorCode));
        }

        /**
         * Validación de año No hay datos anteriores a 1950 ni posteriores al
         * año en curso.
         */
        // Verificamos año de inicio
        Integer startYear = request.getStartYear();
        int minYear = 1950;
        int maxYear = Year.now().getValue();
        if (startYear == null || startYear < minYear || startYear > maxYear) {
            throw new FailException("Año de inicio inválido");
        }

        // Verificamos año de termino
        Integer endYear = request.getEndYear();
        if (endYear == null || endYear < minYear || endYear > maxYear) {
            throw new FailException("Año de término inválido");
        }

        // Verficamos que el inicio no esté después del término
        if (startYear > endYear) {
            throw new FailException(String.format("El año de inicio '%d' no puede ser posterior al año de termino '%d'", startYear, endYear));
        }

        List<Indicator> indicators = cacheService.getIndicators(country, code, startYear, endYear);
        if (CollectionUtils.isEmpty(indicators)) {
            throw new FailException(404, "NO se han encontrado indicadores en el sistema");
        }

        List<IndicatorVO> vos = new ArrayList<>();
        indicators.forEach(indicator -> {
            vos.add(new IndicatorVO(indicator));
        });

        return ResponseEntity.ok(vos);
    }
}
