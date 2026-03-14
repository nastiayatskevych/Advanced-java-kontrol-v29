package ua.university.domain;

public class Money {
    private final double amount;

    public Money(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount must be >= 0");
        this.amount = amount;
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    public Money multiply(double factor) {
        return new Money(this.amount * factor);
    }

    public double getAmount() { return amount; }

    public boolean isGreaterThanOrEqual(Money other) {
        return this.amount >= other.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money m)) return false;
        return Double.compare(amount, m.amount) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(amount);
    }

    @Override
    public String toString() {
        return "Money{amount=" + amount + "}";
    }
}