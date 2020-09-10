package by.restonov.infohandling.exception;

public class InterpreterException extends Exception {
    public InterpreterException() {
    }

    public InterpreterException(String message) {
        super(message);
    }

    public InterpreterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InterpreterException(Throwable cause) {
        super(cause);
    }
}