
# Spring Learning Notes

## 1. **Dependency Injection (DI) in Spring**

In this project, I learned how **dependency injection** works in Spring:

### Ways to inject dependencies:

1. **Constructor Injection**

   * Dependencies are passed through the class constructor.
   * **Advantage:** Allows declaring dependencies as `final` for immutability.
   * Example:

     ```java
     @Component
     public class PaymentService {
         private final PaymentProcessor processor;

         public PaymentService(PaymentProcessor processor) {
             this.processor = processor;
         }
     }
     ```

2. **@Autowired Injection**

   * Spring automatically injects the bean into a field, setter, or constructor.
   * Example:

     ```java
     @Component
     public class PaymentService {
         @Autowired
         private PaymentProcessor processor;
     }
     ```

**Conclusion:** Constructor injection is preferred because it promotes immutability and makes testing easier.

---

## 2. **@Component Annotation**

* **Purpose:** Marks a class as a Spring-managed bean so that Spring can automatically create and manage its instance.
* Example:

  ```java
  @Component
  public class RazorpayProcessor implements PaymentProcessor {
      // Implementation
  }
  ```

---

## 3. **@ConditionalOnProperty**

* **Purpose:** Loads a bean conditionally based on a property value in `application.properties`.
* Example:

  ```java
  @Component
  @ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
  public class RazorpayProcessor implements PaymentProcessor {
      // Implementation
  }
  ```
* **How it works:**

  * Spring checks if the property `payment.provider=razorpay` is present.
  * If true, it creates the bean; otherwise, it is ignored.

---

## 4. **Using JSP with Spring**

To integrate JSP views in a Spring Boot project:

## Note that While doing this you must add this dependency *tomcat-embed-jasper* in pom.xml
## also note that naming convention of src/main/webapp/WEB-INF/views/* must be same 
## and adding this in application.properties 
# **spring.mvc.view.prefix=/WEB-INF/views/**
# **spring.mvc.view.suffix=.jsp**


### Steps:

1. Create a folder structure:

   ```
   src/main/webapp/
       └── views/
           └── Home.jsp
   ```

2. Configure `application.properties`:

   ```properties
   spring.mvc.view.prefix=/WEB-INF/views/
   spring.mvc.view.suffix=.jsp
   ```

3. Create a controller to return the view:

   ```java
   @Controller
   public class HomeController {

       @GetMapping("/")
       public String home() {
           return "Home";  // Resolves to /WEB-INF/views/Home.jsp
       }
   }
   ```

---

## 5. **Key Takeaways**

* **Dependency Injection:** Constructor injection is preferred; `@Autowired` is convenient but less safe for `final` fields.
* **Bean Creation:** `@Component` registers classes as beans.
* **Conditional Beans:** `@ConditionalOnProperty` enables dynamic bean creation based on properties.
* **JSP Integration:** Create `webapp/views` folder and configure `spring.mvc.view.prefix` and `suffix` for JSP resolution.

---
