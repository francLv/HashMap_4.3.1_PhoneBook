package com.company;

import java.util.Objects;

public class Contact {
    private final String name;
    private final String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + " -> " + number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass().equals(obj.getClass())) return false;
        Contact contact = (Contact) obj;
        return Objects.equals(name, contact.name) && Objects.equals(number, contact.number);
    }
}
