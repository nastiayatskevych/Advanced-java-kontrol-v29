package ua.university.payment;

import ua.university.domain.Money;
import ua.university.exception.PaymentException;

public class CardPayment implements PaymentMethod {

    @Override
    public void pay(Money amount) {
        if (amount.getAmount() > 40_000) {
            throw new PaymentException(
                    "Card payment exceeds limit of 40000. Amount: " + amount.getAmount(),
                    new RuntimeException("Limit exceeded")
            );
        }
        System.out.println("Paid " + amount.getAmount() + " via Card");
    }

    @Override
    public String getMethodName() { return "CardPayment"; }
}