package com.simform.ecommerceapi.controller;

import com.simform.ecommerceapi.entity.Orders;
import com.simform.ecommerceapi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrdersService ordersService;

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrder(@PathVariable int id) {
        return ordersService.getOrderById(id);
    }

    @PostMapping
    public Orders addOrder(@RequestBody Orders order) {
        return ordersService.addOrder(order);
    }

    @PutMapping
    public Orders updateOrder(@RequestBody Orders order) {
        return ordersService.updateOrderById(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable int id) {
        ordersService.deleteOrderById(id);
    }


}
