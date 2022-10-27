package br.com.ctmait.asyncmanagement.tech.rabbit.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class RabbitConfig {



    @Bean
    public RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }



//    @Bean
//    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener(
//            RabbitAdmin rabbitAdmin) {
//        return event -> rabbitAdmin.initialize();
//    }

}
