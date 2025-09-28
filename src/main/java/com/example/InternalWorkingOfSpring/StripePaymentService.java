package com.example.InternalWorkingOfSpring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;

@Controller
@ConditionalOnProperty(name="payment.provider",havingValue = "stripe")
public class StripePaymentService implements PaymentService {
    @Override
    public String pay() {
        String payment = "Stripe Pay Service";
        System.out.println("Payment from " + payment);
        return payment;
    }
}
