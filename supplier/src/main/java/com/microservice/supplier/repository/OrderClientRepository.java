package com.microservice.supplier.repository;

import com.microservice.supplier.model.OrderClient;
import org.springframework.data.repository.CrudRepository;

public interface OrderClientRepository extends CrudRepository<OrderClient, Long> {
}
