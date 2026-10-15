package com.billing.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.service.model.BillingModel;

@Repository
public interface BillingRepository extends JpaRepository<BillingModel, Long> {

}
