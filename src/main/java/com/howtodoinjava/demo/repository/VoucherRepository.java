package com.howtodoinjava.demo.repository;

import com.howtodoinjava.demo.model.VoucherEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository
        extends PagingAndSortingRepository<VoucherEntity, Long> {

}
