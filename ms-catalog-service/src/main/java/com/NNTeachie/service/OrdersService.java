package com.NNTeachie.service;


import com.NNTeachie.dto.OrdersDto;
import com.NNTeachie.repo.OrderRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Autowired
    private OrderRepo repo;


    @PostConstruct
    public void saveData() {
        try {
            List<OrdersDto> list = Arrays.asList(
                    new OrdersDto(null, "Iphone", "Mobiles", 99999.0),
                    new OrdersDto(null, "SamsungTV", "Electronics", 75000.0),
                    new OrdersDto(null, "Dell Laptop", "Computers", 55000.0),
                    new OrdersDto(null, "Sony Headphones", "Accessories", 5000.0),
                    new OrdersDto(null, "LG Refrigerator", "Appliances", 45000.0),
                    new OrdersDto(null, "Nike Shoes", "Footwear", 8000.0),
                    new OrdersDto(null, "Wooden Dining Table", "Furniture", 12000.0),
                    new OrdersDto(null, "Casio Watch", "Accessories", 3000.0),
                    new OrdersDto(null, "Microwave Oven", "Appliances", 15000.0),
                    new OrdersDto(null, "Xbox Series X", "Gaming", 50000.0)
            );
            repo.saveAll(list);
        } catch (Exception e) {
            throw new IllegalStateException("Error initializing data in saveData()", e);
        }
    }

    public List<OrdersDto> getAllOrders() {
        return repo.findAll();
    }

    //This one of the way
    public List<OrdersDto> ordersCatagory(String name) {
        return repo.findAll().stream().filter(ordersDto -> ordersDto.getCatagory().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Directly fetch from Database

    public List<OrdersDto> ordersByCatagory(String name) {
        return repo.findByCatagory(name);
    }


}
