package com.howtodoinjava.demo.repository;

import com.howtodoinjava.demo.model.VehicleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository
        extends PagingAndSortingRepository<VehicleEntity, Long> {

}