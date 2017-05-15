package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {

    private String firstName;

    private String surname;

    private Address address;

    @Autowired
    public Customer(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }
}