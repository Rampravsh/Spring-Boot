package dev.rpk;


import dev.rpk.notification.EmailService;
import dev.rpk.notification.NotificationService;
import dev.rpk.notification.PopUpNotificationService;

public class OrderService {

    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification=notification;
    }

    public OrderService(){}


    public void placeOrder(){
        System.out.println("order placed");
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}
