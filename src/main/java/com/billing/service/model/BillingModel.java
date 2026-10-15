package com.billing.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing")
public class BillingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "requestId")
    private Long requestId;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "paymentStatus")
    private String paymentStatus;

    public BillingModel() {
    }

    public BillingModel(Long id, Long requestId, String customerName, String paymentStatus) {
        this.id = id;
        this.requestId = requestId;
        this.customerName = customerName;
        this.paymentStatus = paymentStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

}
