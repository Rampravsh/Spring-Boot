package dev.rpk;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentService {

    private OrderService orderService;


    public PaymentService(OrderService orderService){
        this.orderService=orderService;
        System.out.println("PaymentService created");
    }

    public void pay(){
        System.out.println("payment done");
        orderService.orderDetail();

    }
}
