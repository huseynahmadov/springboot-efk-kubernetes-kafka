package microserviceapplication.error;

public enum ErrorCodes {

    STUDENT_NOT_FOUND("STUDENT_NOT_FOUND");

    private final String code;

    ErrorCodes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
