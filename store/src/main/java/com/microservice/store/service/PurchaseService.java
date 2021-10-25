package com.microservice.store.service;

import com.microservice.store.client.SupplierClient;
import com.microservice.store.dtos.InfoOrderDTO;
import com.microservice.store.dtos.PurchaseDTO;
import com.microservice.store.dtos.SupplierInformationDTO;
import com.microservice.store.model.Purchase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

	private static final Logger LOG = LoggerFactory.getLogger(PurchaseService.class);

	@Autowired
	private SupplierClient supplierClient;
	
	public Purchase insert(PurchaseDTO dto) {
		LOG.info("Searching for supplier information {}", dto.getAddress().getState());
		SupplierInformationDTO info = supplierClient.getInfoByState(dto.getAddress().getState());

		LOG.info("Placing an order");
		InfoOrderDTO order =  supplierClient.placeOrder(dto.getItems());

		Purchase purchase = new Purchase();
		purchase.setOrderId(order.getId());
		purchase.setPreparationTime(order.getPreparationTime());
		purchase.setDestinationAddress(dto.getAddress().toString());

		return purchase;
	}

}
