package dev.rpk;

import dev.rpk.notification.NotificationService;
import dev.rpk.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    @Autowired
    private final PaymentService paymentService;
    private final NotificationService notificationService;


    @Autowired
    public OrderService(@Qualifier("up") PaymentService paymentService, @Qualifier("popup") NotificationService notificationService){
        this.paymentService=paymentService;
        this.notificationService = notificationService;
    }


//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("order is placed");
        notificationService.sendNotification();
    }

}
