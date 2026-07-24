package dev.rpk;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("dev.rpk")
public class AppConfig {

    @Bean
    public OrderService createOrderservice(){
        return new OrderService();
    }
    @Bean
    public OrderService createOrderservice2(){
        return new OrderService();
    }

}
