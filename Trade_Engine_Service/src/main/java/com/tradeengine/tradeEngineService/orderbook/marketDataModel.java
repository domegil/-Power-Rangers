package com.tradeengine.tradeEngineService.orderbook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class marketDataModel {
    @JsonProperty("TICKER")
    private String  ticker;
    @JsonProperty("SELL_LIMIT")
    private int sell_limit;
    @JsonProperty("LAST_TRADED_PRICE")
    private double last_traded_price;
    @JsonProperty("MAX_SHIFT_PRICE")
    private double max_shift_price;
    @JsonProperty("ASK_PRICE")
    private double ask_price;
    @JsonProperty("BID_PRICE")
    private double bid_price;
    @JsonProperty("BUY_LIMIT")
    private int buy_limit;

    public marketDataModel(){}

    public marketDataModel(String ticker, int sell_limit, double last_traded_price, double max_shift_price, double ask_price, double bid_price, int buy_limit) {
        this.ticker = ticker;
        this.sell_limit = sell_limit;
        this.last_traded_price = last_traded_price;
        this.max_shift_price = max_shift_price;
        this.ask_price = ask_price;
        this.bid_price = bid_price;
        this.buy_limit = buy_limit;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getSell_limit() {
        return sell_limit;
    }

    public void setSell_limit(int sell_limit) {
        this.sell_limit = sell_limit;
    }

    public double getLast_traded_price() {
        return last_traded_price;
    }

    public void setLast_traded_price(double last_traded_price) {
        this.last_traded_price = last_traded_price;
    }

    public double getMax_shift_price() {
        return max_shift_price;
    }

    public void setMax_shift_price(double max_shift_price) {
        this.max_shift_price = max_shift_price;
    }

    public double getAsk_price() {
        return ask_price;
    }

    public void setAsk_price(double ask_price) {
        this.ask_price = ask_price;
    }

    public double getBid_price() {
        return bid_price;
    }

    public void setBid_price(double bid_price) {
        this.bid_price = bid_price;
    }

    public int getBuy_limit() {
        return buy_limit;
    }

    public void setBuy_limit(int buy_limit) {
        this.buy_limit = buy_limit;
    }

    @Override
    public String toString() {
        return "MarketDataModel{" +
                "ticker='" + ticker + '\'' +
                ", sell_limit=" + sell_limit +
                ", last_traded_price=" + last_traded_price +
                ", max_shift_price=" + max_shift_price +
                ", ask_price=" + ask_price +
                ", bid_price=" + bid_price +
                ", buy_limit=" + buy_limit +
                '}';
    }
}
