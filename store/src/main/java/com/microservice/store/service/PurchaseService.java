package com.microservice.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.store.client.SupplierClient;
import com.microservice.store.dtos.PurchaseDTO;
import com.microservice.store.dtos.SupplierInformationDTO;

@Service
public class PurchaseService {
	
	@Autowired
	private SupplierClient supplierClient;
	
	public void insert(PurchaseDTO dto) {
		SupplierInformationDTO info = supplierClient.getInfoByState(dto.getAddress().getState());
	}

}
