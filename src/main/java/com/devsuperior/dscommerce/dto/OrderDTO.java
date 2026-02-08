package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus orderStatus;

    public ClientDTO client;

    public PaymentDTO payment;

    @NotEmpty(message = "A ordem deve conter pelo menos um item")
    public List<OrderItemDTO> itens = new ArrayList<>();

    public OrderDTO( Long id, Instant moment, OrderStatus orderStatus, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO (Order entity){
        id = entity.getId();
        moment = entity.getMoment();
        orderStatus = entity.getStatus();
        client = new ClientDTO(entity.getClient());
        payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
    }

    public Long getId() {
        return id;
    }

    public List<OrderItemDTO> getItens() {
        return itens;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public ClientDTO getClient() {
        return client;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Instant getMoment() {
        return moment;
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItemDTO item : itens){
            sum = sum + item.getSubTotal();
        }
        return sum;
    }
}
