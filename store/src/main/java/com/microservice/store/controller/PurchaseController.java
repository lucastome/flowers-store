package com.microservice.store.controller;

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
	public void insert(@RequestBody PurchaseDTO dto) {
		service.insert(dto);
	}
	
}
