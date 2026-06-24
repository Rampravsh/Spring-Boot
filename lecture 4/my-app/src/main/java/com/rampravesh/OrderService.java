package com.rampravesh;

public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    public void placeOrder(){
        paymentService.processPayment();
        System.out.println("Order placed successfully!");
    }
}
