package com.howtodoinjava.demo.repository;

import com.howtodoinjava.demo.model.BookingEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository
        extends PagingAndSortingRepository<BookingEntity, Long> {
}
