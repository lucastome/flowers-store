package com.microservice.store.service;

import com.microservice.store.dtos.InfoOrderDTO;
import com.microservice.store.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.store.client.SupplierClient;
import com.microservice.store.dtos.PurchaseDTO;
import com.microservice.store.dtos.SupplierInformationDTO;

@Service
public class PurchaseService {
	
	@Autowired
	private SupplierClient supplierClient;
	
	public Purchase insert(PurchaseDTO dto) {
		SupplierInformationDTO info = supplierClient.getInfoByState(dto.getAddress().getState());
		InfoOrderDTO order =  supplierClient.placeOrder(dto.getItems());

		Purchase purchase = new Purchase();
		purchase.setOrderId(order.getId());
		purchase.setPreparationTime(order.getPreparationTime());
		purchase.setDestinationAddress(dto.getAddress().toString());

		return purchase;
	}

}
