package ua.university.service;

import ua.university.domain.Order;
import ua.university.payment.PaymentMethod;

public abstract class OrderProcessor {

    private final PaymentMethod paymentMethod;

    protected OrderProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public final void process(Order order) {
        validate(order);
        calculate(order);
        pay(order);
        generateInvoice(order);
        complete(order);
    }

    protected abstract void validate(Order order);
    protected abstract void calculate(Order order);
    protected abstract void generateInvoice(Order order);

    protected void pay(Order order) {
        paymentMethod.pay(order.getFinalAmount());
        order.setStatus(order.getStatus().next());
    }

    protected void complete(Order order) {
        order.setStatus(order.getStatus().next());
    }

    protected PaymentMethod getPaymentMethod() { return paymentMethod; }
}