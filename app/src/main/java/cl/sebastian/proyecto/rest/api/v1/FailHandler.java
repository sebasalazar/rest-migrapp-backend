package cl.sebastian.proyecto.rest.api.v1;

import cl.sebastian.proyecto.rest.api.vo.ErrorVO;
import cl.sebastian.proyecto.rest.exception.FailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"cl.sebastian.proyecto.rest.api"})
public class FailHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FailHandler.class);

    /**
     *
     * @param ex WebpayException
     * @return Una entidad procesable por http con la descripción de un error
     * manejado
     */
    @ExceptionHandler({FailException.class})
    public ResponseEntity handleException(FailException ex) {
        LOGGER.error("Error manejado {}", ex.getMessage());
        LOGGER.debug("Error manejado {}", ex.getMessage(), ex);

        final HttpStatus httpStatus = HttpStatus.valueOf(ex.getCode());
        final ErrorVO error = new ErrorVO(ex.getMessage());

        return new ResponseEntity<>(error, httpStatus);
    }

    /**
     *
     * @param ex Excepción inesperada
     * @return Un error 500 con la excepción generada
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception ex) {
        LOGGER.error("Error NO manejado en Gateway: {}", ex.getMessage());
        LOGGER.debug("Error NO manejado en Gateway: {}", ex.getMessage(), ex);

        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        final ErrorVO error = new ErrorVO(ex.getMessage());

        return new ResponseEntity<>(error, httpStatus);
    }
}
