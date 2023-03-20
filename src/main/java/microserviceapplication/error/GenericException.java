package microserviceapplication.error;

import lombok.Getter;

@Getter
public class GenericException extends RuntimeException {

    private final String code;
    private final String message;
    private final int status;

    public GenericException(String code, String message, int status) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s{status=%d, code='%s', message='%s'}",
                this.getClass().getSimpleName(), status, code, message);
    }

}
