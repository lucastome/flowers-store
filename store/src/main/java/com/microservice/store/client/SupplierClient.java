package com.microservice.store.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.store.dtos.SupplierInformationDTO;

@FeignClient("supplier")
public interface SupplierClient {
	
	@GetMapping("infos/{state}")
	SupplierInformationDTO getInfoByState(@PathVariable String state); 

}
