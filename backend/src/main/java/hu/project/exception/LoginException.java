package hu.project.exception;

public class LoginException extends RuntimeException{
    private String errorMessage;

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
        errorMessage = message;
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
        errorMessage = message;
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}
