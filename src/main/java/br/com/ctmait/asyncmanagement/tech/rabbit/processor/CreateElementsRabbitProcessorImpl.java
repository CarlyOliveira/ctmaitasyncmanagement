package br.com.ctmait.asyncmanagement.tech.rabbit.processor;

import br.com.ctmait.asyncmanagement.abstraction.action.CreateElementsRabbitAction;
import br.com.ctmait.asyncmanagement.abstraction.action.SaveElementsRabbitAction;
import br.com.ctmait.asyncmanagement.abstraction.processor.CreateElementsRabbitProcessor;
import br.com.ctmait.asyncmanagement.abstraction.validation.CreateElementsRabbitValidation;
import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;
import br.com.ctmait.asyncmanagement.tech.infrastructure.annotation.Processor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Processor
@RequiredArgsConstructor
public class CreateElementsRabbitProcessorImpl implements CreateElementsRabbitProcessor {

    private static final Logger logger = LoggerFactory.getLogger(CreateElementsRabbitProcessorImpl.class);

    private final CreateElementsRabbitAction createElementsRabbitAction;
    private final SaveElementsRabbitAction saveElementsRabbitAction;
    private final CreateElementsRabbitValidation createElementsRabbitValidation;

    @Override
    public void execute(Rabbit rabbit) {

        logger.info("CERPI-E-00 ");

        rabbit.visit(createElementsRabbitValidation::execute);

        rabbit.visit(createElementsRabbitAction::execute);

        rabbit.visit(saveElementsRabbitAction::execute);

        logger.info("CERPI-E-01 ");
    }
}
