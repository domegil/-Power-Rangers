package com.TradeExchange.TradeExchange.dao;

import com.TradeExchange.TradeExchange.model.ClientModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDeo {

    int insertClient(UUID id,String startDate, ClientModel client);

    default int insertClient(ClientModel client){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String startdate = dtf.format(now);
        UUID id = UUID.randomUUID();
        return  insertClient(id,startdate,client);
    }
    List<ClientModel> selectAllClient();
    Optional<ClientModel> selectClientById(UUID id);
    int deleteClientById(UUID id);
    int updateClientById(UUID id,ClientModel client);
}
