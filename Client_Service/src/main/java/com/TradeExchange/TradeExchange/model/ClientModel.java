package com.TradeExchange.TradeExchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class ClientModel {
    private final UUID id;
    @NotBlank
    private final String fullName;
    @NotBlank
    private final String password;

    @NotBlank
    private final String email;
    @NotBlank
    private final double balance;
    @NotBlank
    private final String creditCard;
    private final String startDate;

    public ClientModel(@JsonProperty("id") UUID id, @JsonProperty("fullName")String fullName, @JsonProperty("password")String password,
                       @JsonProperty("email")String email, @JsonProperty("balance")double balance, @JsonProperty("creditCard")String creditCard, @JsonProperty("startDate")String startDate) {
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

    public String getStartDate() {
        return startDate;
    }
}
