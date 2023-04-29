package com.howtodoinjava.demo.repository;

import com.howtodoinjava.demo.model.PaymentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository
        extends PagingAndSortingRepository<PaymentEntity, Long> {

}
