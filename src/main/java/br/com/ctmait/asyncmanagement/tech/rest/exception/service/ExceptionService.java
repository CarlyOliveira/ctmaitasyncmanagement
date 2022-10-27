package br.com.ctmait.asyncmanagement.tech.rest.exception.service;

import br.com.ctmait.asyncmanagement.domain.exception.RabbitValidationException;
import br.com.ctmait.asyncmanagement.tech.rest.exception.payload.ExceptionPayload;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

public interface ExceptionService {

    ExceptionPayload generatePayload(Exception ex);
}
