package com.TradeExchange.TradeExchange.api;

import com.TradeExchange.TradeExchange.clientPublisher.clientPublisher;
import com.TradeExchange.TradeExchange.model.ClientModel;
import com.TradeExchange.TradeExchange.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/client")
@RestController
public class ClientController {
    private final ClientService clientService;
    clientPublisher clientPublisher = new clientPublisher();
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping
    public void addClient(  @NonNull @RequestBody ClientModel client){
        clientService.addClient(client);
        clientPublisher.publishClient("client",client.getId(),client);
    }
    @GetMapping
    public List<ClientModel> getAllClient(){
        return clientService.getAllClient();
    }

    @GetMapping(path = "{id}")
    public ClientModel getClientById(@PathVariable("id") UUID id){
        return clientService.getClientById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable UUID id){
        clientService.deleteClient(id);

    }
    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") UUID id, @NonNull @RequestBody ClientModel clientToUpdate){
        clientService.updateClient(id,clientToUpdate);
    }
}
