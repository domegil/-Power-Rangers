package com.example.demo.Deo;

import com.example.demo.Model.OrdersModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeDataService implements OrdersDeo {
    private static List<OrdersModel> ordersTable = new ArrayList<>();

    @Override
    public int insertOrder(UUID id, OrdersModel order) {
        ordersTable.add(new OrdersModel(id, order.getClientID(), order.getSide(), order.getProduct(), order.getPrice(),order.getQuantity()));
        return 1;
    }

    @Override
    public List<OrdersModel> selectAllOrders() {
        return ordersTable;
    }

    @Override
    public Optional<OrdersModel> selectOrderById(UUID id) {
        return ordersTable.stream().filter(OrdersModel -> OrdersModel.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteOrderById(UUID id) {
        Optional<OrdersModel> orderMaybe = selectOrderById(id);
        if(orderMaybe.isEmpty()){
            return 0;
        }

        ordersTable.remove(orderMaybe.get());
        return 1;
    }

    @Override
    public int updateOrderById(UUID id, OrdersModel update) {
        return selectOrderById(id)
                .map(order ->{
                    int indexOfOrderToUpdate = ordersTable.indexOf(order);
                    if(indexOfOrderToUpdate >= 0){
                        ordersTable.set(indexOfOrderToUpdate,new OrdersModel(id, update.getClientID(), update.getSide(), update.getProduct(),
                                update.getPrice(),update.getQuantity()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
