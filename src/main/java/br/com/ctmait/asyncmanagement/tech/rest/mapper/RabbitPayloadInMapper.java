package br.com.ctmait.asyncmanagement.tech.rest.mapper;

import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;
import br.com.ctmait.asyncmanagement.tech.rest.payload.in.RabbitPayloadIn;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RabbitPayloadInMapper {

    RabbitPayloadInMapper INSTANCE = Mappers.getMapper( RabbitPayloadInMapper.class );

    @Mapping(target = "exchange.name", source = "rabbitPayloadIn.exchangeName")
    @Mapping(target = "exchange.exchangeType", source = "rabbitPayloadIn.exchangeType", defaultValue = "TOPIC")
    @Mapping(target = "queue.name", source = "rabbitPayloadIn.queueName")
    @Mapping(target = "queue.routingKey", source = "rabbitPayloadIn.routingKey")
    @Mapping(target = "exchangeDlq.name", source = "rabbitPayloadIn.exchangeNameDlq")
    @Mapping(target = "exchangeDlq.exchangeType", source = "rabbitPayloadIn.exchangeTypeDlq", defaultValue = "TOPIC")
    @Mapping(target = "queueDlq.name", source = "rabbitPayloadIn.queueNameDlq")
    @Mapping(target = "queueDlq.routingKey", source = "rabbitPayloadIn.routingKeyDlq")
    @Mapping(target="id", source="transactionId")
    Rabbit toRabbit (RabbitPayloadIn rabbitPayloadIn, String transactionId);
}