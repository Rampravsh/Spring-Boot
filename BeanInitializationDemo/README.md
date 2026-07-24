# Bean Initialization Demo

A Spring Framework demonstration project showcasing **bean initialization** and **lazy loading** patterns in Spring's Dependency Injection container.

## 📋 Project Overview

This project illustrates how Spring manages bean lifecycle, particularly focusing on:
- **Eager Initialization** (default behavior)
- **Lazy Initialization** using the `@Lazy` annotation
- **Constructor Injection** with lazy dependencies
- **Spring ApplicationContext** and bean management

## 🏗️ Project Structure

```
BeanInitializationDemo/
├── pom.xml
└── src/main/java/dev/rpk/
    ├── AppConfig.java        # Spring Configuration class
    ├── Main.java             # Entry point demonstrating bean initialization
    ├── OrderService.java     # Service with lazy-loaded dependency
    └── PaymentService.java   # Lazy-initialized service component
```

## 📦 Dependencies

- **Spring Context** (v7.0.7) - For Spring IoC container and bean management
- **Java 25** - Target and source compatibility

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>7.0.7</version>
</dependency>
```

## 🔍 Component Details

### 1. **AppConfig.java**
The main Spring configuration class that enables component scanning.

```java
@Configuration
@ComponentScan("dev.rpk")
public class AppConfig {
}
```

- **@Configuration**: Marks this class as a Spring configuration source
- **@ComponentScan**: Automatically discovers and registers components in the `dev.rpk` package

### 2. **PaymentService.java**
A service component marked for lazy initialization.

```java
@Component
@Lazy
public class PaymentService {
    private OrderService orderService;

    public PaymentService(OrderService orderService){
        this.orderService = orderService;
        System.out.println("PaymentService created");
    }

    public void pay(){
        System.out.println("payment done");
        orderService.orderDetail();
    }
}
```

**Key Features:**
- **@Component**: Registers this class as a Spring bean
- **@Lazy**: Delays bean initialization until it's first requested
- **Constructor Injection**: Receives `OrderService` dependency via constructor
- **Print Statement**: Demonstrates when the bean is actually instantiated

### 3. **OrderService.java**
A service that depends on `PaymentService` with lazy loading.

```java
@Component
public class OrderService {
    PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService){
        this.paymentService = paymentService;
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
```

**Key Features:**
- **@Component**: Registers as an eager-loaded bean (initialized on context startup)
- **@Lazy on Parameter**: The `PaymentService` dependency is injected lazily
- The `PaymentService` bean is only created when `pay()` is called, not at startup

### 4. **Main.java**
The application entry point demonstrating the initialization behavior.

```java
public class Main {
    static void main() {
        // Create Spring context - eager beans are initialized here
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get OrderService (already created during context initialization)
        OrderService order = context.getBean(OrderService.class);
        
        System.out.println("payment Service not started yet");
        
        // Call placeOrder() - this triggers PaymentService initialization
        order.placeOrder();
    }
}
```

## 🚀 Execution Flow

### Without @Lazy annotation:
1. `ApplicationContext` is created
2. **OrderService** is initialized → prints "OrderService created"
3. **PaymentService** is initialized → prints "PaymentService created"
4. Then your code executes

### With @Lazy annotation (Current Implementation):
1. `ApplicationContext` is created
2. **OrderService** is initialized → prints "OrderService created"
3. **PaymentService** is NOT initialized yet (deferred)
4. `order.placeOrder()` is called
5. **PaymentService** is lazily initialized → prints "PaymentService created"
6. `payment.pay()` executes → prints "payment done" and "Order details"

## 🎯 Key Concepts

### Eager Initialization (Default)
```java
@Component
public class MyBean {
    public MyBean() {
        System.out.println("MyBean created immediately");
    }
}
```
- Bean is instantiated when the `ApplicationContext` is created
- Suitable for beans that must exist at startup

### Lazy Initialization
```java
@Component
@Lazy
public class MyLazyBean {
    public MyLazyBean() {
        System.out.println("MyLazyBean created only when requested");
    }
}
```
- Bean is instantiated only when first accessed via `getBean()` or injected
- Improves startup time by deferring non-critical bean creation
- Useful for heavy or optional components

### Constructor Injection with @Lazy
```java
@Component
public class Service {
    public Service(@Lazy HeavyDependency dependency) {
        this.dependency = dependency;
    }
}
```
- The dependency is wrapped in a proxy that creates the actual bean on first use
- Service initializes immediately, but `HeavyDependency` is deferred

## 💡 Use Cases

**Use `@Lazy` for:**
- Heavy dependencies that may not be needed immediately
- Optional features that not all code paths use
- Database connections or external service clients
- Reducing application startup time

**Avoid `@Lazy` for:**
- Critical startup operations (connection pools, cache initialization)
- Beans required for security or authentication
- Configuration validation that should fail fast

## 🔧 Running the Application

### Prerequisites
- Java 25+
- Maven

### Build
```bash
mvn clean compile
```

### Run
```bash
mvn exec:java -Dexec.mainClass="dev.rpk.Main"
```

### Expected Output
```
OrderService created
payment Service not started yet
PaymentService created
payment done
Order details
Order placed
```

## 📚 Learning Objectives

By studying this project, you'll understand:

1. ✅ How Spring's ApplicationContext manages bean lifecycle
2. ✅ The difference between eager and lazy initialization
3. ✅ How to use `@Lazy` annotation for deferred bean creation
4. ✅ Constructor injection with lazy dependencies
5. ✅ Component scanning and automatic bean registration
6. ✅ Spring configuration and dependency management best practices

## 🔗 Related Spring Concepts

- **ApplicationContext**: Spring's central interface for managing beans
- **@Configuration**: Marks a class as a configuration source
- **@Component**: Generic stereotype for any Spring-managed component
- **@ComponentScan**: Enables automatic component discovery
- **@Lazy**: Delays bean instantiation until first use
- **Dependency Injection**: Constructor, setter, and field injection patterns

## 📖 Further Reading

- [Spring Framework Documentation - Bean Scopes](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes)
- [Spring @Lazy Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Lazy.html)
- [Spring Dependency Injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-dependencies)

---

**Created for:** Learning Spring Bean Initialization and Lazy Loading patterns  
**Framework:** Spring Framework 7.0.7  
**Java Version:** 25  
