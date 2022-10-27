package br.com.ctmait.asyncmanagement.tech.rabbit.validation;

import br.com.ctmait.asyncmanagement.abstraction.validation.CreateElementsRabbitValidation;
import br.com.ctmait.asyncmanagement.domain.exception.RabbitValidationException;
import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;
import br.com.ctmait.asyncmanagement.tech.infrastructure.annotation.Processor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;

@Processor
@RequiredArgsConstructor
public class CreateElementsRabbitValidationImpl implements CreateElementsRabbitValidation {

    private static final Logger logger = LoggerFactory.getLogger(CreateElementsRabbitValidationImpl.class);


    @Override
    public void execute(Rabbit rabbit) {

        logger.info("CERVI-E-00 validation Rabbit {}", rabbit);

        HashMap<String, String> errors = new HashMap<>();

        try{
            validRabbit(rabbit, errors);
            validId(rabbit, errors);
            validExchange(rabbit, errors);
            validExchangeName(rabbit, errors);
            validExchangeType(rabbit, errors);
            validQueue(rabbit, errors);
            validQueueName(rabbit, errors);
            validRoutingKey(rabbit, errors);
            validExchangeDlq(rabbit, errors);
            validExchangeNameDlq(rabbit, errors);
            validExchangeTypeDlq(rabbit, errors);
            validQueueDlq(rabbit, errors);
            validQueueNameDlq(rabbit, errors);
            validRoutingKeyDlq(rabbit, errors);
            hasErrorsThrowRabbitValidationException(errors);
        }catch (Exception e){
            throw new RabbitValidationException(errors.toString());
        }

        logger.info("CERVI-E-01 Validated Rabbit {}", rabbit);
    }

    private void validRabbit(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit, "rabbit cannot null");
        }catch (Exception e){
            errors.put("Rabbit", e.getMessage());
        }
    }

    private void validId(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getId(), "id cannot null");
        }catch (Exception e){
            errors.put("id", e.getMessage());
        }
    }

    private void validExchange(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getExchange(), "exchange cannot null");
        }catch (Exception e){
            errors.put("Exchange", e.getMessage());
        }
    }

    private void validExchangeName(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getExchange().getName(), "exchange name cannot null");
        }catch (Exception e){
            errors.put("ExchangeName", e.getMessage());
        }
    }

    private void validExchangeType(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getExchange().getExchangeType(), "exchangeType cannot null");
        }catch (Exception e){
            errors.put("ExchangeType", e.getMessage());
        }
    }

    private void validQueue(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getQueue(), "queue cannot null");
        }catch (Exception e){
            errors.put("Queue", e.getMessage());
        }
    }

    private void validQueueName(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getQueue().getName(), "queue name cannot null");
        }catch (Exception e){
            errors.put("QueueName", e.getMessage());
        }
    }

    private void validRoutingKey(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getQueue().getRoutingKey(), "routingKey cannot null");
        }catch (Exception e){
            errors.put("RoutingKey", e.getMessage());
        }
    }

    private void validExchangeDlq(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getExchangeDlq(), "exchange dlq cannot null");
        }catch (Exception e){
            errors.put("ExchangeDlq", e.getMessage());
        }
    }

    private void validExchangeNameDlq(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getExchangeDlq().getName(), "exchange name dlq cannot null");
        }catch (Exception e){
            errors.put("ExchangeNameDlq", e.getMessage());
        }
    }

    private void validExchangeTypeDlq(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getExchangeDlq().getExchangeType(), "exchangeType dlq cannot null");
        }catch (Exception e){
            errors.put("ExchangeTypeDlq", e.getMessage());
        }
    }

    private void validQueueDlq(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getQueueDlq(), "queue dlq cannot null");
        }catch (Exception e){
            errors.put("QueueDlq", e.getMessage());
        }
    }

    private void validQueueNameDlq(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getQueueDlq().getName(), "queue name dlq cannot null");
        }catch (Exception e){
            errors.put("QueueNameDlq", e.getMessage());
        }
    }

    private void validRoutingKeyDlq(Rabbit rabbit, HashMap<String, String> errors){
        try {
            notNullOrEmpty(rabbit.getQueueDlq().getRoutingKey(), "routingKey dlq cannot null");
        }catch (Exception e){
            errors.put("RoutingKeyDlq", e.getMessage());
        }
    }

    private void hasErrorsThrowRabbitValidationException(HashMap<String, String> errors){
        if (errors.size() > 0){
            throw new RabbitValidationException(errors.toString());
        }
    }

    private void notNullOrEmpty(Object object, String message){
        if (ObjectUtils.isEmpty(object)) {
            throw new IllegalArgumentException(message);
        }
    }
    private void notNullOrEmpty(String text, String message){
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
