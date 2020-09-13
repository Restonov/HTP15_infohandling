package by.restonov.infohandling.exception;

public class CustomProjectException extends Exception{
    public CustomProjectException() {
    }

    public CustomProjectException(String message) {
        super(message);
    }

    public CustomProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomProjectException(Throwable cause) {
        super(cause);
    }
}
