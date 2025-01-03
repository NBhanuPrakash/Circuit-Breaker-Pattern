package com.NNTeachie.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
public class OrdersDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String productName;

    private String catagory;

    private Double price;

    public OrdersDto() {
    }

    public OrdersDto(Integer orderId, String productName, String catagory, Double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.catagory = catagory;
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
