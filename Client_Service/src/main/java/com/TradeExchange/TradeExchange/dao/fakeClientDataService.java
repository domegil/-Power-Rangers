//package com.TradeExchange.TradeExchange.dao;
//
//import com.TradeExchange.TradeExchange.model.ClientModel;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository("fakeclient")
//public class fakeClientDataService implements ClientDeo{
//    private static List<ClientModel> dataBase = new ArrayList<>();
//
//    @Override
//    public int insertClient(UUID id, ClientModel client) {
//        dataBase.add(new ClientModel(id,client.getFullName(),client.getPassword(), client.getEmail(), client.getBalance(),client.getCreditCard(),client.getStartDate()));
//        return 1;
//    }
//
//    @Override
//    public List<ClientModel> selectAllClient() {
//        return dataBase;
//    }
//
//    @Override
//    public Optional<ClientModel> selectClientById(UUID id) {
//        return dataBase.stream().filter(clientModel -> clientModel.getId().equals(id)).findFirst();
//    }
//
//    @Override
//    public int deleteClientById(UUID id) {
//        Optional<ClientModel> clientMybe = selectClientById(id);
//        if(clientMybe.isEmpty()){
//            return 0;
//        }
//
//        dataBase.remove(clientMybe.get());
//        return 1;
//    }
//
//    @Override
//    public int updateClientById(UUID id, ClientModel update) {
//        return selectClientById(id)
//                .map(client ->{
//                    int indexOfClientToUpdate = dataBase.indexOf(client);
//                    if(indexOfClientToUpdate >= 0){
//                        dataBase.set(indexOfClientToUpdate,new ClientModel(id,update.getFullName(),
//                                update.getPassword(),update.getEmail(),update.getBalance(),update.getCreditCard(),update.getStartDate()));
//                        return 1;
//                    }
//                    return 0;
//                }).orElse(0);
//    }
//}
