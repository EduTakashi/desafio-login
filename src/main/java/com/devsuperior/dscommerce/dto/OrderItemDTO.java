package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {

    private Long orderId;
    private String name;
    private Double price;
    private Integer quantity;
    private String imgUrl;


    public OrderItemDTO() {
    }

    public OrderItemDTO(Long orderId, String name, Double price, Integer quantity, String imgUrl) {
        this.orderId = orderId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }

    public OrderItemDTO(OrderItem entity){
        orderId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        imgUrl = entity.getProduct().getImgUrl();
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

    public String getImgUrl(){
        return imgUrl;
    }

    public Double getSubTotal(){
        return price * quantity;
    }
}
