package dev.rpk;

import dev.rpk.notification.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        NotificationService notificationService =new SmsService();
//        OrderService order = new OrderService(notificationService);
        OrderService order = new OrderService();
        order.setNotification(notificationService);
        order.placeOrder();
    }
}

// A class should ask what it needs and not
// build everything itself

// IOC --> Inversion of control