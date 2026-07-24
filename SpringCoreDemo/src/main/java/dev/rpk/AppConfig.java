package dev.rpk;

import dev.rpk.notification.EmailService;
import dev.rpk.notification.NotificationService;
import dev.rpk.notification.PopUpNotificationService;
import dev.rpk.notification.SmsService;
import org.springframework.beans.factory.annotation.Qualifier;
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


    @Bean
    @Qualifier("sms")
    public NotificationService createSmsService(){
        return new SmsService();
    }

    @Bean
    @Qualifier("email")
    public NotificationService createEmailService(){
        return new EmailService();
    }

    @Bean
    @Qualifier("popup")
    public NotificationService createPopUpNotificationService(){
        return new PopUpNotificationService();
    }


}
