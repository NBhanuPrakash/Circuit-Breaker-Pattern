package com.NNTeachie.service;

import com.NNTeachie.dto.OrdersDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    private static final String BASRURL = "http://localhost:9091/allOrders";

    private static final String USERSERVICE = "userService";

    private int attempt = 1;

//    @CircuitBreaker(name = USERSERVICE, fallbackMethod = "getAllProducts")
    @Retry(name = USERSERVICE,fallbackMethod = "getAllProducts")
    public List<OrdersDto> displayOrders(String category) {

        String url = category == null ? BASRURL : BASRURL + "/" + category;
        System.out.println("retry method called "+attempt++ +"times "+"at "+new Date());
        return restTemplate.getForObject(url, ArrayList.class);
    }

    public List<OrdersDto> getAllProducts(Exception e) {
        List<OrdersDto> list = Arrays.asList(
                new OrdersDto(101, "Iphone", "Mobiles", 99999.0),
                new OrdersDto(102, "SamsungTV", "Electronics", 75000.0),
                new OrdersDto(103, "Dell Laptop", "Computers", 55000.0),
                new OrdersDto(104, "Sony Headphones", "Accessories", 5000.0),
                new OrdersDto(105, "LG Refrigerator", "Appliances", 45000.0),
                new OrdersDto(106, "Nike Shoes", "Footwear", 8000.0),
                new OrdersDto(107, "Wooden Dining Table", "Furniture", 12000.0),
                new OrdersDto(108, "Casio Watch", "Accessories", 3000.0),
                new OrdersDto(109, "Microwave Oven", "Appliances", 15000.0),
                new OrdersDto(110, "Xbox Series X", "Gaming", 50000.0)
        );
        return list;
    }
}
