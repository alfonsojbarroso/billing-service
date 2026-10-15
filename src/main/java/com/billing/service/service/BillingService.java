package com.billing.service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.billing.service.dto.OrderDto;
import com.billing.service.enums.OrderStatus;
import com.billing.service.model.BillingModel;
import com.billing.service.repository.BillingRepository;

@Service
public class BillingService {

    private final BillingRepository billingRepository;
    private final KafkaTemplate<String, OrderDto> kafkaTemplate;

    public BillingService(BillingRepository billingRepository, KafkaTemplate<String, OrderDto> kafkaTemplate) {
        this.billingRepository = billingRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "service-requested-topic", groupId = "billing-service-group")
    public void saveBilling(OrderDto orderDto) {
        BillingModel billingModel = new BillingModel();
        billingModel.setCustomerName(orderDto.customerName());
        billingModel.setPaymentStatus(OrderStatus.COMPLETED.getDescription());
        billingRepository.save(billingModel);
        kafkaTemplate.send("order-completed-topic", orderDto);
    }

}
