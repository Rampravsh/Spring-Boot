package dev.rpk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("dev.rpk")

public class AppConfig {

    @Bean
    public User createUser(){
        return new User("Rampravesh",21);
    }

}
