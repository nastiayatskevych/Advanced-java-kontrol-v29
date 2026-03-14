package ua.university.domain;

import ua.university.exception.AppException;

public enum OrderStatus {
    NEW, PAID, INVOICE_SENT, SHIPPED, DELIVERED;

    public OrderStatus next() {
        OrderStatus[] vals = values();
        if (this == DELIVERED) {
            throw new AppException("Order already delivered");
        }
        return vals[this.ordinal() + 1];
    }
}