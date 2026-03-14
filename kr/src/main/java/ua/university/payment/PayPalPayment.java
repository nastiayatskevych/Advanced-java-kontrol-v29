package ua.university.payment;

import ua.university.domain.Money;
import ua.university.exception.PaymentException;

public class PayPalPayment implements PaymentMethod {

    @Override
    public void pay(Money amount) {
        if (amount.getAmount() < 500) {
            throw new PaymentException(
                    "PayPal requires minimum 500. Amount: " + amount.getAmount(),
                    new RuntimeException("Amount too low")
            );
        }
        System.out.println("Paid " + amount.getAmount() + " via PayPal");
    }

    @Override
    public String getMethodName() { return "PayPalPayment"; }
}