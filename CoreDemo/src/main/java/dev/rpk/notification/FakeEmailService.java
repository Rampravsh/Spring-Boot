package dev.rpk.notification;

public class FakeEmailService implements NotificationService{
    @Override
    public void sendNotification(){
        System.out.println("Dummy Email sent");
    }
}
