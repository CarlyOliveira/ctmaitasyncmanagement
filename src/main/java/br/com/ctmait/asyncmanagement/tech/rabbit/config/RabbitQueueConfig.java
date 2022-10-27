package br.com.ctmait.asyncmanagement.tech.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueConfig {

  @Value("${app.rabbitmq.queues.create-document-by-event-offer}")
  private String createDocumentByEventOfferQueue;

  @Value("${app.rabbitmq.queues.create-document-by-event-offer-dlq}")
  private String createDocumentByEventOfferQueueDlq;

  @Value("${app.rabbitmq.topic-exchange-dlq}")
  private String topicExchangeDlq;

  @Value("${app.rabbitmq.routing-key-dlq}")
  private String routingKeyDlq;

    @Bean
    public Queue queueCreateDocument() {
      return QueueBuilder
          .durable(createDocumentByEventOfferQueue)
          .deadLetterExchange(topicExchangeDlq)
          .deadLetterRoutingKey(routingKeyDlq)
          .build();
    }

  @Bean
  public Queue queueCreateDocumentDlq() {
    return QueueBuilder
        .durable(createDocumentByEventOfferQueueDlq)
        .build();
  }

  //example queue model
//  @Bean
//  public Queue example() {
//    return QueueBuilder
//        .nonDurable(createDocumentByEventOfferQueue)
        //        .deadLetterExchange(topicExchangeDlq) tópico para onde as msgs que falharam são enviadas
        //        .deadLetterRoutingKey(routingKeyDlq) chave de roteamento para o tópico de falha rotear as mensagens
        //        .ttl() time to live, tempo que a msg vai existir na fila
        //        .autoDelete() exclui a fila automaticament se não existir nenhum consumidor
        //        .maxLength() Quantas msgs a fila pode ter até começar a descartar as antigas ou rejeitas novas msgs
//        .build();
//  }

}
