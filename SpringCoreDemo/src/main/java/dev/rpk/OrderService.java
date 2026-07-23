package dev.rpk;

import dev.rpk.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    @Autowired
    private final PaymentService paymentService;

    @Autowired
    public OrderService(@Qualifier("cardPayment") PaymentService paymentService){
        this.paymentService=paymentService;
    }

//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("order is placed");
    }

}
