package ua.university.domain;

public class OrderItem {
    private final String productName;
    private final int quantity;
    private final Money unitPrice;

    public OrderItem(String productName, int quantity, Money unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderItem(String productName, int quantity, double price) {
        this(productName, quantity, new Money(price));
    }

    public Money getTotalPrice() {
        return unitPrice.multiply(quantity);
    }

    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public Money getUnitPrice() { return unitPrice; }


    @Override public String toString() {
        return productName + " x" + quantity + " @ " + unitPrice;
    }
}