package dev.rpk.notification;

public class EmailService implements NotificationService {

    @Override
    public void sendNotification(){
        System.out.println("Email notification sent");
    }
}
