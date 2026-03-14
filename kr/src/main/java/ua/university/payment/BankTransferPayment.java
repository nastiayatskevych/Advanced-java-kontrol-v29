package ua.university.payment;

import ua.university.domain.Money;

public class BankTransferPayment implements PaymentMethod {

    private static final double COMMISSION_RATE = 0.03;
    private static final double DISCOUNT_RATE = 0.03;

    @Override
    public void pay(Money amount) {
        double withCommission = amount.getAmount() * (1 + COMMISSION_RATE);
        double withDiscount   = amount.getAmount() * (1 - DISCOUNT_RATE);
        System.out.println("Commission applied: " + withCommission);
        System.out.println("Discount applied:   " + withDiscount);
        System.out.println("Paid " + amount.getAmount() + " via Bank Transfer");
    }

    public Money applyDiscount(Money amount) {
        return new Money(amount.getAmount() * (1 - DISCOUNT_RATE));
    }

    @Override
    public String getMethodName() { return "BankTransferPayment"; }
}