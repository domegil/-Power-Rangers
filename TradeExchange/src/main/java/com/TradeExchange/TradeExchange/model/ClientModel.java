package com.TradeExchange.TradeExchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class ClientModel {
    private final UUID id;
    private final String fullName;
    private final String password;
    private final String email;
    private final double balance;
    private final String creditCard;
    private final Date startDate;

    public ClientModel(@JsonProperty("id") UUID id, @JsonProperty("fullName")String fullName, @JsonProperty("password")String password,
                       @JsonProperty("email")String email, @JsonProperty("balance")double balance, @JsonProperty("creditCard")String creditCard, @JsonProperty("startDate")Date startDate) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.creditCard = creditCard;
        this.startDate = startDate;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public Date getStartDate() {
        return startDate;
    }
}
