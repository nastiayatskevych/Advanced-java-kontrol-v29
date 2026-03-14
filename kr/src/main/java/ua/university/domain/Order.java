package ua.university.domain;

import java.util.Arrays;

public class Order {
    private final String id;
    private final Email customerEmail;
    private final OrderItem[] items;   // defensive copy
    private OrderStatus status;
    private Money finalAmount;

    public Order(String id, Email customerEmail, OrderItem[] items) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.items = Arrays.copyOf(items, items.length); // defensive copy
        this.status = OrderStatus.NEW;
    }

    public OrderItem[] getItems() {
        return Arrays.copyOf(items, items.length);       // defensive copy
    }

    public Money calculateTotal() {
        Money total = new Money(0.0);
        for (OrderItem item : items) {
            total = total.add(item.getTotalPrice());
        }
        return total;
    }

    public String getId() { return id; }
    public Email getCustomerEmail() { return customerEmail; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public Money getFinalAmount() { return finalAmount; }
    public void setFinalAmount(Money finalAmount) { this.finalAmount = finalAmount; }


    @Override public String toString() {
        return "Order{id=" + id + ", status=" + status + ", total=" + calculateTotal() + "}";
    }
}