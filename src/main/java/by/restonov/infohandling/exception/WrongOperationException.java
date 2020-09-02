package by.restonov.infohandling.exception;

public class WrongOperationException extends Exception{

    public WrongOperationException() {
    }

    public WrongOperationException(String message) {
        super(message);
    }

    public WrongOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongOperationException(Throwable cause) {
        super(cause);
    }
}
