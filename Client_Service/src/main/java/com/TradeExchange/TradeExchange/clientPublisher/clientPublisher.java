package com.TradeExchange.TradeExchange.clientPublisher;

import com.TradeExchange.TradeExchange.model.ClientModel;
import redis.clients.jedis.Jedis;

import java.util.UUID;

public class clientPublisher {
    Jedis clientpub = new Jedis("localhost");

    public void publishClient(String channel,UUID id ,ClientModel clientModel){
        UUID getId = clientModel.getId();
        clientpub.publish(channel, String.format(String.format("Name " + clientModel.getFullName() + " Balance " + clientModel.getBalance() +
                " Email " + clientModel.getEmail() + " ID " + clientModel.getId())));
    }

}
