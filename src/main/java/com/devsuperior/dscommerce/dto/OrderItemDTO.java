package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {

    private Long orderId;
    private String name;
    private Double price;
    private Integer quantity;


    public OrderItemDTO() {
    }

    public OrderItemDTO(Long orderId, String name, Double price, Integer quantity) {
        this.orderId = orderId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem entity){
        orderId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
    }

    public Long getOrderId() {
        return orderId;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public Double getSubTotal(){
        return price * quantity;
    }
}
