package br.com.ctmait.asyncmanagement.tech.rabbit.action;

import br.com.ctmait.asyncmanagement.abstraction.action.CreateElementsRabbitAction;
import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;
import br.com.ctmait.asyncmanagement.tech.infrastructure.annotation.Action;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.util.Assert;

@Action
@RequiredArgsConstructor
public class CreateElementsRabbitActionImpl implements CreateElementsRabbitAction {

    private static final Logger logger = LoggerFactory.getLogger(CreateElementsRabbitActionImpl.class);

    private final RabbitAdmin rabbitAdmin;

    @Override
    public void execute(Rabbit rabbit) {

        logger.info("CERAI-E-00 create elements Rabbit {}", rabbit);

        Assert.notNull(rabbit, "rabbit cannot null");
        Assert.notNull(rabbit.getExchange(), "exchange cannot null");
        Assert.notNull(rabbit.getExchange().getName(), "exchange name cannot null");
        Assert.notNull(rabbit.getExchange().getExchangeType(), "exchangeType cannot null");
        Assert.notNull(rabbit.getQueue(), "queue cannot null");
        Assert.notNull(rabbit.getQueue().getName(), "queue name cannot null");
        Assert.notNull(rabbit.getQueue().getRoutingKey(), "routingKey cannot null");
        Assert.notNull(rabbit.getExchangeDlq(), "exchange dlq cannot null");
        Assert.notNull(rabbit.getExchangeDlq().getName(), "exchange name dlq cannot null");
        Assert.notNull(rabbit.getExchangeDlq().getExchangeType(), "exchangeType dlq cannot null");
        Assert.notNull(rabbit.getQueueDlq(), "queue dlq cannot null");
        Assert.notNull(rabbit.getQueueDlq().getName(), "queue name dlq cannot null");
        Assert.notNull(rabbit.getQueueDlq().getRoutingKey(), "routingKey dlq cannot null");

        rabbit.visit(this::generateElementsDlq);
        rabbit.visit(this::generateElementsDefault);

        logger.info("CERAI-E-01 created elements Rabbit {}", rabbit);
    }

    private Exchange generateExchange(String exchangeName){
        return ExchangeBuilder
                .topicExchange(exchangeName)
                .durable(true)
                .build();
    }

    private Queue generateQueue(String queueName, String exchangeDlq, String routingKey){
        return QueueBuilder
                .durable(queueName)
                .deadLetterExchange(exchangeDlq)
                .deadLetterRoutingKey(routingKey)
                .build();
    }

    private Queue generateQueue(String queueName){
        return QueueBuilder
                .durable(queueName)
                .build();
    }

    public Binding generateBinding(Exchange exchange, Queue queue, String routingKey) {
        return  BindingBuilder.bind(queue)
                .to(exchange)
                .with(routingKey)
                .noargs();
    }

    private void generateElementsDefault(Rabbit rabbit){

        logger.info("CERAI-GED-00 create elements default Rabbit {}", rabbit);

        var exchange = generateExchange(rabbit.getExchange().getName());

        logger.info("CERAI-GED-01 create elements default exchange {}", exchange);

        var queue = generateQueue(rabbit.getQueue().getName(), rabbit.getExchangeDlq().getName(), rabbit.getQueueDlq().getRoutingKey());

        logger.info("CERAI-GED-02 create elements default queue {}", queue);

        var routingKey = rabbit.getQueue().getRoutingKey();

        var binding = generateBinding(exchange,queue,routingKey);

        logger.info("CERAI-GED-03 create elements default binding {}", binding);

        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(binding);

        logger.info("CERAI-GED-04 created elements default Rabbit {}", rabbit);
    }

    private void generateElementsDlq(Rabbit rabbit){

        logger.info("CERAI-GED-00 create elements dlq Rabbit {}", rabbit);

        var exchange = generateExchange(rabbit.getExchangeDlq().getName());

        logger.info("CERAI-GED-01 create elements dlq exchange {}", exchange);

        var queue = generateQueue(rabbit.getQueueDlq().getName());

        logger.info("CERAI-GED-02 create elements dlq queue {}", queue);

        var routingKey = rabbit.getQueueDlq().getRoutingKey();
        var binding = generateBinding(exchange,queue,routingKey);

        logger.info("CERAI-GED-03 create elements dlq binding {}", binding);

        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(binding);

        logger.info("CERAI-GED-04 created elements dlq Rabbit {}", rabbit);
    }
}
