package com.howtodoinjava.demo.repository;

import com.howtodoinjava.demo.model.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends PagingAndSortingRepository<UserEntity, Long> {

}
