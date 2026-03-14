package ua.university.domain;

import ua.university.exception.ValidationException;

public class Email {
    private final String value;

    public Email(String value) {
        if (value == null || value.isBlank())
            throw new ValidationException("Email cannot be empty");
        if (!value.contains("@"))
            throw new ValidationException("Invalid email: " + value);
        this.value = value;
    }

    public String getValue() { return value; }

    @Override public String toString() { return value; }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Email e)) return false;
        return value.equalsIgnoreCase(e.value);
    }

    @Override public int hashCode() { return value.toLowerCase().hashCode(); }
}