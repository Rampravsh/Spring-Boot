package com.rampravesh;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        PaymentService payment =new PaymentService();


        OrderService order =new OrderService(payment);
        order.placeOrder();
    }
}
