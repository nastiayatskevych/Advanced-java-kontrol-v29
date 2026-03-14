package ua.university.exception;

public class PaymentException extends AppException {
    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }
}