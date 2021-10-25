package com.microservice.store.controller;

import com.microservice.store.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.store.dtos.PurchaseDTO;
import com.microservice.store.service.PurchaseService;

@RestController
@RequestMapping("/stores")
public class PurchaseController {

	@Autowired
	private PurchaseService service;
	
	@PostMapping
	public Purchase insert(@RequestBody PurchaseDTO dto) {
		return service.insert(dto);
	}
	
}
