package dev.rpk;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")  //lazy initialization

@Scope("singleton")  //Eager initialization
public class OrderService {

    public OrderService(){
        System.out.println("Order service created");
    }
    public void palceOrder(){
        System.out.println("Order place");
    }

}
