package org.example.z13_spring_boot.service.impl;

import jakarta.transaction.Transactional;
import org.example.z13_spring_boot.repo.ItemRepo;
import org.example.z13_spring_boot.repo.OrderDetailRepo;
import org.example.z13_spring_boot.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlaceOrderImpl {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;


    void placeOrder() {
        //qty management
        itemRepo.updateQTY();
        //persist - order
        orderRepo.save();
        //persist - order-detail
        orderDetailRepo.save();
    }
}
