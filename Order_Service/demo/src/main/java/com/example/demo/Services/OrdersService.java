package com.example.demo.Services;

import com.example.demo.Deo.OrdersDeo;
import com.example.demo.Model.OrdersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrdersService {
    private final OrdersDeo orderDeo;

    @Autowired
    public OrdersService(@Qualifier("fakeDao") OrdersDeo orderDeo) {
        this.orderDeo = orderDeo;
    }

    public int addOrder(OrdersModel order){
        return orderDeo.insertOrder(order);
    }
    public List<OrdersModel> getAllOrder(){
        return orderDeo.selectAllOrders();
    }
    public Optional<OrdersModel> getOrdersById(UUID id){
        return orderDeo.selectOrderById(id);
    }
    public int deleteOrder(UUID id){
        return orderDeo.deleteOrderById(id);
    }
    public int updateOrder(UUID id,OrdersModel newOrder){
        return orderDeo.updateOrderById(id,newOrder);
    }
}
