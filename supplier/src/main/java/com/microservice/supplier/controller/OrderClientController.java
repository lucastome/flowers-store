package com.microservice.supplier.controller;

import com.microservice.supplier.dtos.ItemOrderDTO;
import com.microservice.supplier.model.OrderClient;
import com.microservice.supplier.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderClientController {

    @Autowired
    private OrderClientService service;

    @PostMapping
    public OrderClient placeOrder(@RequestBody List<ItemOrderDTO> items) {
        return service.placeOrder(items);
    }

    @GetMapping("/{id}")
    public OrderClient getOrderClientById(@PathVariable Long id) {
        return service.getOrderClientById(id);
    }
}
