package com.TradeExchange.TradeExchange.dao;

import com.TradeExchange.TradeExchange.model.ClientModel;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDeo {
    int insertClient(UUID id, ClientModel client);
    default int insertClient(ClientModel client){
        UUID id = UUID.randomUUID();
        return  insertClient(id,client);
    }
    List<ClientModel> selectAllClient();
    Optional<ClientModel> selectClientById(UUID id);
    int deleteClientById(UUID id);
    int updateClientById(UUID id,ClientModel client);
}
