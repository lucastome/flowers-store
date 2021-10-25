package com.microservice.supplier.controller;

import com.microservice.supplier.dtos.ItemOrderDTO;
import com.microservice.supplier.model.OrderClient;
import com.microservice.supplier.service.OrderClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(OrderClientController.class);

    @Autowired
    private OrderClientService service;

    @PostMapping
    public OrderClient placeOrder(@RequestBody List<ItemOrderDTO> items) {
        LOG.info("Request received at endpoint placeOrder");
        return service.placeOrder(items);
    }

    @GetMapping("/{id}")
    public OrderClient getOrderClientById(@PathVariable Long id) {
        LOG.info("Request received at endpoint getOrderClientById {}", id);
        return service.getOrderClientById(id);
    }
}
