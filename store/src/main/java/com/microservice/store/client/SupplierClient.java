package com.microservice.store.client;

import com.microservice.store.dtos.InfoOrderDTO;
import com.microservice.store.dtos.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.store.dtos.SupplierInformationDTO;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("supplier")
public interface SupplierClient {
	
	@GetMapping("infos/{state}")
	SupplierInformationDTO getInfoByState(@PathVariable String state);

	@PostMapping("/orders")
	InfoOrderDTO placeOrder (List<ItemDTO> items);

}
