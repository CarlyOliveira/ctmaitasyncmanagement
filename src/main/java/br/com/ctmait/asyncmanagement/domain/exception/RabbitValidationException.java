package br.com.ctmait.asyncmanagement.domain.exception;

public class RabbitValidationException extends RuntimeException{

    public RabbitValidationException(){
        super();
    };

    public RabbitValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public RabbitValidationException(String message) {
        super(message);
    }
}
