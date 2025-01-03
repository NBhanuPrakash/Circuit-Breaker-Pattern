package com.NNTeachie.controller;

import com.NNTeachie.dto.OrdersDto;
import com.NNTeachie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/userorders")
    public ResponseEntity<List<OrdersDto>> getAllOrders(@RequestParam(required = false) String category){
        return ResponseEntity.ok(service.displayOrders(category));
    }
}
