package ua.university.service;

import ua.university.domain.Money;
import ua.university.domain.Order;
import ua.university.exception.ValidationException;
import ua.university.payment.BankTransferPayment;
import ua.university.payment.PaymentMethod;

public class DefaultOrderProcessor extends OrderProcessor {

    public DefaultOrderProcessor(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    @Override
    protected void validate(Order order) {
        Money total = order.calculateTotal();
        if (!total.isGreaterThanOrEqual(new Money(500))) {
            throw new ValidationException(
                    "Order total must be >= 500. Current: " + total.getAmount()
            );
        }
    }

    @Override
    protected void calculate(Order order) {
        Money total = order.calculateTotal();
        if (getPaymentMethod() instanceof BankTransferPayment bankTransfer) {
            order.setFinalAmount(bankTransfer.applyDiscount(total));
        } else {
            order.setFinalAmount(total);
        }
    }

    @Override
    protected void generateInvoice(Order order) {
        order.setStatus(order.getStatus().next()); // PAID -> INVOICE_SENT
    }
}