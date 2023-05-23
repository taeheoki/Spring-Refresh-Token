package shop.taeheoki.refreshtoken.core.exception;

public class NoSuchMemberException extends RuntimeException {
    public NoSuchMemberException() {
        super();
    }

    public NoSuchMemberException(String message) {
        super(message);
    }

    public NoSuchMemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchMemberException(Throwable cause) {
        super(cause);
    }

    protected NoSuchMemberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
