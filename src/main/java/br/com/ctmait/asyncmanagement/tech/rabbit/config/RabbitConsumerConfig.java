package br.com.ctmait.asyncmanagement.tech.rabbit.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConsumerConfig {


//    @Bean
//    RetryOperationsInterceptor interceptor() {
//        return RetryInterceptorBuilder.stateless()
//                .withMaxAttempts(5)
//                .setRecoverer(new RepublishMessageRecoverer(amqpTemplate(), "bar", "baz"))
//                .build();
//    }

//    @Bean
//    RetryOperationsInterceptor retryOperationsInterceptor(){
//        return RetryInterceptorBuilder.stateless()
//                .maxAttempts(5)
//                .backOffOptions(1000,1.0,1000)
//                .build();
//    }
}
