package br.com.ctmait.asyncmanagement.tech.rest.mapper;

import br.com.ctmait.asyncmanagement.domain.rabbit.Rabbit;
import br.com.ctmait.asyncmanagement.tech.rest.payload.out.RabbitPayloadOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RabbitPayloadOutMapper {

    RabbitPayloadOutMapper INSTANCE = Mappers.getMapper( RabbitPayloadOutMapper.class );

    @Mapping(source = "exchange.name", target = "elementsDefault.exchange.name")
    @Mapping(source = "exchange.exchangeType", target = "elementsDefault.exchange.exchangeType", defaultValue = "TOPIC")
    @Mapping(source = "queue.name", target = "elementsDefault.queue.name")
    @Mapping(source = "queue.routingKey", target = "elementsDefault.queue.routingKey")
    @Mapping(source = "exchangeDlq.name", target = "elementsDlq.exchange.name")
    @Mapping(source = "exchangeDlq.exchangeType", target = "elementsDlq.exchange.exchangeType", defaultValue = "TOPIC")
    @Mapping(source = "queueDlq.name", target = "elementsDlq.queue.name")
    @Mapping(source = "queueDlq.routingKey", target = "elementsDlq.queue.routingKey")
    @Mapping(source="id", target="id")
    RabbitPayloadOut toRabbitPayloadOut (Rabbit rabbit);

}
