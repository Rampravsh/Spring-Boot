# BeanScopeDemo — Detailed README

## Overview
This small Spring Boot demo illustrates bean scopes (singleton vs prototype) and how their lifecycle and instances behave in a Spring context. Use it to learn how scope changes affect object sharing and instantiation in simple, observable examples.

## What you'll learn
- Difference between singleton and prototype bean scopes
- How Spring manages bean lifecycle and instantiation
- How to observe instance identity and lifecycle in a running app

## Project structure (important files)
- src/main/java/dev/rpk/User.java — Simple POJO with fields `name` and `age`. Useful as a sample bean type for scope experiments.
- src/main/java/... — (Look for Application class and any configuration classes that define beans and scopes.)
- pom.xml — Maven build file.

Note: User.java is a plain Java class (no annotations). You can register it as a bean (singleton or prototype) in a @Configuration class or annotate a factory method with @Scope.

## How to run
1. Build with Maven:
   mvn clean package

2. Run with Maven (recommended during development):
   mvn spring-boot:run

3. Or run the packaged jar:
   java -jar target/*your-artifact-name*.jar

## How to experiment with bean scopes
1. Register User as a bean in a configuration class, for example:

```java
@Bean
@Scope("prototype") // or "singleton"
public User user() {
    return new User();
}
```

2. Autowire or look up the bean multiple times and log/print their identity (System.identityHashCode or toString) to observe whether the same instance is returned.

Example (pseudo):

```java
@Autowired
private ApplicationContext ctx;

public void demo() {
    User u1 = ctx.getBean(User.class);
    User u2 = ctx.getBean(User.class);
    System.out.println(u1 == u2); // false for prototype, true for singleton
}
```

## Example expectations
- Singleton: same instance is returned from the container every time; identity comparisons are true.
- Prototype: a new instance is created each time the bean is requested; identity comparisons are false.

## Testing tips
- Add logging to constructors or init methods to see when instances are created.
- Use unit or integration tests to assert behavior programmatically.

## Further ideas
- Explore request and session scopes in web apps.
- Add @PostConstruct/@PreDestroy to observe lifecycle callbacks (note: destruction callback for prototype beans must be managed manually).

## Notes
This README is intentionally generic so it applies regardless of how the repository currently wires User.java. If specific configuration classes should be documented, point to them and this README can be updated with exact class names and example outputs.

---
Generated for the BeanScopeDemo project. Update the run instructions if your artifactId or main class differs.
