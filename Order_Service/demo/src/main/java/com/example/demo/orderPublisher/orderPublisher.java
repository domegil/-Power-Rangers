package com.example.demo.orderPublisher;

import com.example.demo.Model.OrdersModel;
import redis.clients.jedis.Jedis;

public class orderPublisher {
    Jedis orderPub = new Jedis();

    public void publishOrder(String channel, OrdersModel ordersModel){
        orderPub.publish("order", " Product: "+ ordersModel.getProduct()+ " Quantity: " + ordersModel.getQuantity() +
                " Order Type: " + ordersModel.getSide() + " Price: " + ordersModel.getPrice());
    }
}
