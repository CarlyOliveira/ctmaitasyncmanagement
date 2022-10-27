package br.com.ctmait.asyncmanagement.tech.rest.resources;


import br.com.ctmait.asyncmanagement.abstraction.processor.CreateElementsRabbitProcessor;
import br.com.ctmait.asyncmanagement.tech.rest.mapper.RabbitPayloadInMapper;
import br.com.ctmait.asyncmanagement.tech.rest.mapper.RabbitPayloadOutMapper;
import br.com.ctmait.asyncmanagement.tech.rest.payload.in.RabbitPayloadIn;
import br.com.ctmait.asyncmanagement.tech.rest.payload.out.RabbitPayloadOut;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/rabbit")
@RequiredArgsConstructor
public class RabbitResources {

    private static final Logger logger = LoggerFactory.getLogger(RabbitResources.class);

    private final CreateElementsRabbitProcessor createElementsRabbitProcessor;

    @PostMapping
    public ResponseEntity<RabbitPayloadOut> create(@RequestBody RabbitPayloadIn payload,
                                                   @RequestHeader(value = "transactionId", required = true) String transactionId) {

        logger.info("RR-C-00 received payload {}", payload);

        var rabbit = RabbitPayloadInMapper.INSTANCE.toRabbit(payload, transactionId);

        logger.info("RR-C-01 Domain Rabbit {}", rabbit);

        rabbit.visit(createElementsRabbitProcessor::execute);

        var responseBody = RabbitPayloadOutMapper.INSTANCE.toRabbitPayloadOut(rabbit);

        logger.info("RR-C-02 responseBody {}", responseBody);

        var response = ResponseEntity.status(HttpStatus.CREATED).body(responseBody);

        return response;
    }
}
