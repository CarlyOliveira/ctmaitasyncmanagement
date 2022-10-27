package br.com.ctmait.asyncmanagement.tech.rabbit.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(
        value = "app.deploy.rabbit-startup-create",
        havingValue = "true",
        matchIfMissing = false)
public class RabbitBindingConfig {

  private final RabbitExchangeConfig rabbitExchangeConfig;
  private final RabbitQueueConfig rabbitQueueConfig;

  @Value("${app.rabbitmq.routing-key}")
  private String routingKey;

  @Value("${app.rabbitmq.routing-key-dlq}")
  private String routingKeyDlq;

  @Bean
  public Binding bindingCreateDoccumentWithDocumentEvent() {
    return  BindingBuilder.bind(rabbitQueueConfig.queueCreateDocument())
        .to(rabbitExchangeConfig.exchangeEventDocument())
        .with(routingKey)
        .noargs();
  }

  @Bean
  public Binding bindingCreateDoccumentWithDocumentEventDlq() {
    return  BindingBuilder.bind(rabbitQueueConfig.queueCreateDocumentDlq())
        .to(rabbitExchangeConfig.exchangeEventDocumentDlq())
        .with(routingKeyDlq)
        .noargs();
  }

}
