package br.com.ctmait.asyncmanagement.tech.rest.exception.handler;

import br.com.ctmait.asyncmanagement.domain.exception.RabbitValidationException;
import br.com.ctmait.asyncmanagement.tech.rest.exception.payload.ExceptionPayload;
import br.com.ctmait.asyncmanagement.tech.rest.exception.service.ExceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
@RequiredArgsConstructor
public class RabbitResourcesHandler{

    private final ExceptionService exceptionService;

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public ResponseEntity<ExceptionPayload> handleException(HttpClientErrorException ex) {
        return new ResponseEntity<ExceptionPayload>(
                exceptionService.generatePayload(ex),
                ex.getStatusCode());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseBody
    public ResponseEntity<ExceptionPayload> handleException(HttpServerErrorException ex) {
        return new ResponseEntity<ExceptionPayload>(
                exceptionService.generatePayload(ex),
                ex.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionPayload> handleException(Exception ex) {
        return new ResponseEntity<ExceptionPayload>(
                exceptionService.generatePayload(ex),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionPayload> handleException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<ExceptionPayload>(
                exceptionService.generatePayload(ex),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RabbitValidationException.class)
    public ResponseEntity<ExceptionPayload> handleException(RabbitValidationException ex) {
        return new ResponseEntity<ExceptionPayload>(
                exceptionService.generatePayload(ex),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionPayload> handleException(IllegalArgumentException ex) {
        return new ResponseEntity<ExceptionPayload>(
                exceptionService.generatePayload(ex),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ExceptionPayload> handleException(MissingRequestHeaderException ex) {
        return new ResponseEntity<ExceptionPayload>(
                exceptionService.generatePayload(ex),
                HttpStatus.BAD_REQUEST);
    }

}
