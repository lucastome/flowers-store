package com.microservice.supplier.repository;

import com.microservice.supplier.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepositoy extends CrudRepository<Product, Long> {

    List<Product> findByState(String state);

    List<Product> findByIdIn(List<Long> ids);
}
