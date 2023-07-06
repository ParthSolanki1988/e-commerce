package com.simform.ecommerceapi.service;

import com.simform.ecommerceapi.entity.Orders;
import com.simform.ecommerceapi.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrderRepo orderRepo;

    public Orders addOrder(Orders order) {
        Orders saveOrder = orderRepo.save(order);
        return saveOrder;
    }

    public List<Orders> getAllOrders() {
        Optional<List<Orders>> allOrders = Optional.of(orderRepo.findAll());
        if (allOrders.isPresent()) {
            return allOrders.get();
        } else {
            throw new RuntimeException("All Orders List is empty");
        }
    }

    public Orders getOrderById(int id) {
        Optional<Orders> order = orderRepo.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new RuntimeException("order id is invalid");
        }
    }

    public void deleteOrderById(int id) {
        orderRepo.deleteById(id);

    }

    public Orders updateOrderById(Orders order) {
        return orderRepo.save(order);
    }
}


