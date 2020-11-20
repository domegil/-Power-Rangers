package com.TradeExchange.TradeExchange.dao;

import com.TradeExchange.TradeExchange.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class clientDataAccessService implements ClientDeo{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public clientDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertClient(UUID id,String startDate, ClientModel client) {
        final String insertClientSql = "INSERT INTO client(id,fullname,password,email,balance,creditcard,startdate) VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(insertClientSql,id,
                client.getFullName(),client.getPassword(),client.getEmail(),client.getBalance(),
                client.getCreditCard(),startDate);
    }


    @Override
    public List<ClientModel> selectAllClient() {
        final String getAllClientSql = "SELECT * FROM client";
        List<ClientModel> clientMode = jdbcTemplate.query(getAllClientSql, (resultSet,i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String fullName = resultSet.getString("fullName");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            float balance = resultSet.getFloat("balance");
            String creditCard = resultSet.getString("creditCard");
            Date startDate = resultSet.getDate("startDate");
            return new ClientModel(id, fullName, password, email, balance, creditCard, startDate );
        });
        return clientMode;
    }

    @Override
    public Optional<ClientModel> selectClientById(UUID id) {
        final String getAllClientSql = "SELECT * FROM client WHERE id = ?";
        ClientModel clientModel = jdbcTemplate.queryForObject(getAllClientSql, new Object[]{id}, (resultSet, i) -> {
            UUID person_id = UUID.fromString(resultSet.getString("id"));
            String fullName = resultSet.getString("fullName");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            float balance = resultSet.getFloat("balance");
            String creditCard = resultSet.getString("creditCard");
            Date startDate = resultSet.getDate("startDate");
            return new ClientModel(person_id, fullName, password, email, balance, creditCard, startDate);
        });
        return Optional.ofNullable(clientModel);


    }

    @Override
    public int deleteClientById(UUID id) {
        final String deleteById = "DELETE FROM client WHERE id = ?";
        //Optional<ClientModel> getclient = selectClientById(id);
        return jdbcTemplate.update(deleteById,id);
    }

    @Override
    public int updateClientById(UUID id, ClientModel update) {
//        final String updateclient = "DELETE FROM client WHERE id = ?";
//        return selectClientById(id)
//                .map(client ->{
//                    return jdbcTemplate.update(updateclient,selectAllClient());
//                }).orElse(0);
        return 0;
    }

}
