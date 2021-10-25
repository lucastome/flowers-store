package com.microservice.store.dtos;

import java.util.List;

public class PurchaseDTO {
	
	private List<ItemDTO> items;
	private AddressDTO address;
	
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
}

