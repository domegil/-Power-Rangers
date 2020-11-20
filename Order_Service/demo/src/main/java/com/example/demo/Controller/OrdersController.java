package com.example.demo.Controller;

import com.example.demo.Model.OrdersModel;
import com.example.demo.Services.OrdersService;
import com.example.demo.orderPublisher.orderPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.orderPublisher.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/order")
@RestController
public class OrdersController {
    private final OrdersService orderService;
    orderPublisher orderPublisher = new orderPublisher();

    @Autowired
    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public void addOrder(@RequestBody OrdersModel order){
        orderService.addOrder(order);
        orderPublisher.publishOrder("order",order);
    }
    @GetMapping("/getallorder")
    public List<OrdersModel> getAllOrders(){
        return orderService.getAllOrder();
    }

    @GetMapping(path = "{id}")
    public OrdersModel getOrderById(@PathVariable("id") UUID id){
        return orderService.getOrdersById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteOrderById(@PathVariable UUID id){
        orderService.deleteOrder(id);
    }
    @PutMapping(path = "{id}")
    public void updateOrder(@PathVariable("id") UUID id, @RequestBody OrdersModel orderToUpdate){
        orderService.updateOrder(id,orderToUpdate);
    }
}
