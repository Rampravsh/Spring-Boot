package dev.rpk;

import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class OrderService {
    PaymentService paymentService;

    public  OrderService(@Lazy PaymentService paymentService){
        this.paymentService =paymentService;
        System.out.println("OrderService created");
    }

    public void placeOrder(){
        paymentService.pay();

        System.out.println("Order placed");
    }

    public void orderDetail(){
        System.out.println("Order details");
    }

}
