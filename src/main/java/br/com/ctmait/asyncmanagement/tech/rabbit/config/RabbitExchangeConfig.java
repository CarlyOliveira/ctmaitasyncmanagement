package br.com.ctmait.asyncmanagement.tech.rabbit.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitExchangeConfig {

  @Value("${app.rabbitmq.topic-exchange}")
  private String topicExchange;

  @Value("${app.rabbitmq.topic-exchange-dlq}")
  private String topicExchangeDlq;

  @Bean
  public Exchange exchangeEventDocument() {
    return ExchangeBuilder
            .topicExchange(topicExchange)
            .durable(true)
            .build();
  }

  @Bean
  public Exchange exchangeEventDocumentDlq() {
    return ExchangeBuilder
            .topicExchange(topicExchangeDlq)
            .durable(true)
            .build();
  }

}
