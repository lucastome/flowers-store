package com.microservice.supplier.service;

import com.microservice.supplier.dtos.ItemOrderDTO;
import com.microservice.supplier.model.ItemOrder;
import com.microservice.supplier.model.OrderClient;
import com.microservice.supplier.model.Product;
import com.microservice.supplier.repository.OrderClientRepository;
import com.microservice.supplier.repository.ProductRepositoy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderClientService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderClientService.class);

    @Autowired
    private OrderClientRepository repositoy;

    @Autowired
    private ProductRepositoy productRepositoy;

    public OrderClient placeOrder(List<ItemOrderDTO> items) {

        if(items == null) {
            return null;
        }

        LOG.info("Convertendo ItemsDTO to Items");
        List<ItemOrder> itemsOrder = this.toItemOrder(items);
        OrderClient order = new OrderClient(itemsOrder);
        order.setPreparationTime(itemsOrder.size());
        LOG.info("Saving Order Client");

        return repositoy.save(order);
    }

    public OrderClient getOrderClientById(Long id) {
        LOG.info("Searching order by id {}", id);
        return this.repositoy.findById(id).orElse(new OrderClient());
    }

    private List<ItemOrder> toItemOrder(List<ItemOrderDTO> items) {
        List<Long> idsProdutos = items
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());

        List<Product> productsOrder = productRepositoy.findByIdIn(idsProdutos);

        List<ItemOrder> itemsOrder = items
                .stream()
                .map(item -> {
                    Product product = productsOrder
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    ItemOrder itemOrder = new ItemOrder();
                    itemOrder.setProduct(product);
                    itemOrder.setQuantity(item.getQuantity());
                    return itemOrder;
                })
                .collect(Collectors.toList());

        return itemsOrder;
    }

}
