package cl.sebastian.proyecto.rest.exception;

public class FailException extends RuntimeException {

    private final Integer code;

    public FailException() {
        this.code = 412;
    }

    public FailException(String message) {
        super(message);
        this.code = 412;
    }

    public FailException(String message, Throwable cause) {
        super(message, cause);
        this.code = 412;
    }

    public FailException(Throwable cause) {
        super(cause);
        this.code = 412;
    }

    public FailException(Integer code) {
        this.code = code;
    }

    public FailException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public FailException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FailException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
