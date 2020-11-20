package com.example.demo.Deo;

import com.example.demo.Model.OrdersModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersDeo {
    int insertOrder(UUID id, OrdersModel order);
    default int insertOrder(OrdersModel order){
        UUID id = UUID.randomUUID();
        return insertOrder(id, order);
    }
    List<OrdersModel> selectAllOrders();
    Optional<OrdersModel> selectOrderById(UUID id);
    int deleteOrderById(UUID id);
    int updateOrderById(UUID id, OrdersModel order);
}
