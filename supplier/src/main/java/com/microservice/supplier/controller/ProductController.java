package com.microservice.supplier.controller;

import com.microservice.supplier.model.Product;
import com.microservice.supplier.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/{state}")
    public List<Product> getProductsByState(@PathVariable("state") String state) {
        return service.getProductsByState(state);
    }
}
