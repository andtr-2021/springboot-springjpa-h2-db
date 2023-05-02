package com.howtodoinjava.demo.repository;

import com.howtodoinjava.demo.model.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverRepository
        extends PagingAndSortingRepository<DriverEntity, Long>, JpaRepository<DriverEntity, Long> {

}
