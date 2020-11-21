package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class OrdersModel {
    private final UUID id;
    private final UUID clientID;
    private final String product;
    private final String side;
    private final double price;
    private final int quantity;

    public OrdersModel(@JsonProperty("id") UUID id, @JsonProperty("clientID") UUID clientID, @JsonProperty("side") String side,
                       @JsonProperty("product") String product, @JsonProperty("price") double price, @JsonProperty("quantity") int quantity) {
        this.id = id;
        this.clientID = clientID;
        this.side = side;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public UUID getClientID() {
        return clientID;
    }

    public String getProduct() {
        return product;
    }

    public String getSide() {
        return side;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
