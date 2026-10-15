package com.billing.service.dto;

import java.time.LocalDateTime;

import com.billing.service.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record OrderDto(
        @JsonIgnore String id,
        String customerName,
        String serviceDescription,
        String status,
        @JsonIgnore LocalDateTime createdAt) {

    public OrderDto {
        status = OrderStatus.IN_PROGRESS.getDescription();
        createdAt = LocalDateTime.now();
    }

}
