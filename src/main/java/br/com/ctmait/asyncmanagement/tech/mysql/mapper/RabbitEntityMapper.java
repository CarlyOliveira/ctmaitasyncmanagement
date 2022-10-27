package br.com.ctmait.asyncmanagement.tech.mysql.mapper;

import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;
import br.com.ctmait.asyncmanagement.tech.mysql.entity.RabbitEntity;
import br.com.ctmait.asyncmanagement.tech.rest.payload.out.RabbitPayloadOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RabbitEntityMapper {

    RabbitEntityMapper INSTANCE = Mappers.getMapper( RabbitEntityMapper.class );

    @Mapping(source = "exchange.name", target = "exchangeName")
    @Mapping(source = "exchange.exchangeType", target = "exchangeType", defaultValue = "TOPIC")
    @Mapping(source = "queue.name", target = "queueName")
    @Mapping(source = "queue.routingKey", target = "routingKey")
    @Mapping(source = "exchangeDlq.name", target = "exchangeNameDlq")
    @Mapping(source = "exchangeDlq.exchangeType", target = "exchangeTypeDlq", defaultValue = "TOPIC")
    @Mapping(source = "queueDlq.name", target = "queueNameDlq")
    @Mapping(source = "queueDlq.routingKey", target = "routingKeyDlq")
    @Mapping(source="id", target="uuid")
    @Mapping(target = "id", ignore = true)
    RabbitEntity toRabbitEntity (Rabbit rabbit);
}
