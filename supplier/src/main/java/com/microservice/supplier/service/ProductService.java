package com.microservice.supplier.service;

import com.microservice.supplier.model.Product;
import com.microservice.supplier.repository.ProductRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepositoy repositoy;

    public List<Product> getProductsByState(String estado) {
        return repositoy.findByState(estado);
    }
}
