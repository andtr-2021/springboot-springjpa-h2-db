package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@Service
public class DriverService {

    @Autowired
    DriverRepository repository;

    public List<DriverEntity> getAllDrivers(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<DriverEntity> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<DriverEntity>();
        }
    }

    public DriverEntity getDriverById(Long id) throws RecordNotFoundException
    {
        Optional<DriverEntity> driver = repository.findById(id);

        if(driver.isPresent()) {
            return driver.get();
        } else {
            throw new RecordNotFoundException("No driver record exist for given id");
        }
    }

    public DriverEntity createOrUpdateDriver(DriverEntity entity) throws RecordNotFoundException
    {
        Optional<DriverEntity> driver = repository.findById(entity.getId());

        if(driver.isPresent())
        {
            DriverEntity newEntity = driver.get();
            newEntity.setId(entity.getId());
            newEntity.setDriverName(entity.getDriverName());
            newEntity.setDriverPhoneNumber(entity.getDriverPhoneNumber());
            newEntity.setDriverLicenseNumber(entity.getDriverLicenseNumber());
            newEntity.setDriverYearOfExperience(entity.getDriverYearOfExperience());
            newEntity.setDriverAvatar(entity.getDriverAvatar());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteDriverById(Long id) throws RecordNotFoundException
    {
        Optional<DriverEntity> driver = repository.findById(id);

        if(driver.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No driver record exist for given id");
        }
    }
}
