package com.NNTeachie.controller;


import com.NNTeachie.dto.OrdersDto;
import com.NNTeachie.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrdersService service;

    @GetMapping("/allOrders")
    public ResponseEntity<List<OrdersDto>> getAllOrders() {
        return ResponseEntity.ok(service.getAllOrders());
    }

    @GetMapping("/allOrders/{catagory}")
    public ResponseEntity<List<OrdersDto>> getOrders(@PathVariable String catagory) {
        return ResponseEntity.ok(service.ordersByCatagory(catagory));
    }
}
