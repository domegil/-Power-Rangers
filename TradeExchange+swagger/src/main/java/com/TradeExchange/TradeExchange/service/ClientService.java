package com.TradeExchange.TradeExchange.service;

import com.TradeExchange.TradeExchange.dao.ClientDeo;
import com.TradeExchange.TradeExchange.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientDeo clientDeo;

    @Autowired
    public ClientService(@Qualifier("fakeDeo") ClientDeo clientDeo) {
        this.clientDeo = clientDeo;
    }

    public int addClient(ClientModel client){
        return clientDeo.insertClient(client);
    }
    public List<ClientModel> getAllClient(){
        return clientDeo.selectAllClient();
    }
    public Optional<ClientModel>getClientById(UUID id){
        return clientDeo.selectClientById(id);
    }
    public int deleteClient(UUID id){
        return clientDeo.deleteClientById(id);
    }
    public int updateClient(UUID id,ClientModel newClient){
        return clientDeo.updateClientById(id,newClient);
    }
}
