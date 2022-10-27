package br.com.ctmait.asyncmanagement.tech.mysql.action;

import br.com.ctmait.asyncmanagement.abstraction.action.SaveElementsRabbitAction;
import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;
import br.com.ctmait.asyncmanagement.tech.infrastructure.annotation.Action;
import br.com.ctmait.asyncmanagement.tech.mysql.mapper.RabbitEntityMapper;
import br.com.ctmait.asyncmanagement.tech.mysql.repository.RabbitRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

@Action
@RequiredArgsConstructor
public class SaveElementsRabbitActionImpl implements SaveElementsRabbitAction {

    private static final Logger logger = LoggerFactory.getLogger(SaveElementsRabbitActionImpl.class);

    private final RabbitRepository rabbitRepository;

    @Override
    public void execute(Rabbit rabbit) {

        logger.info("SERAI-E-00 save Rabbit {}", rabbit);

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

        var entity = RabbitEntityMapper.INSTANCE.toRabbitEntity(rabbit);

        logger.info("SERAI-E-01 saving rabbitEntity {}", entity);

        rabbitRepository.save(entity);

        logger.info("SERAI-E-02 saved Rabbit {}", rabbit);

    }
}
