package com.example.InternalWorkingOfSpring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component // this @Component Annotation tells the Spring that we have to create a bean for this class without this it behvaves like normal implementation of java classes
@ConditionalOnProperty(name="payment.provider",havingValue = "razorpay")
public class RazorPaymentService implements PaymentService{
    @Override
    public String pay(){
        String payment="Razor Pay Service";
        System.out.println("Payment from "+payment); 
        return payment;
    }
}
