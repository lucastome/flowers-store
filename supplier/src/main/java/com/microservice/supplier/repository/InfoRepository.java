package com.microservice.supplier.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.microservice.supplier.model.InfoSupplier;

@Repository
public interface InfoRepository extends CrudRepository<InfoSupplier, Long>{

	
	InfoSupplier findByState(String state);
	
}


