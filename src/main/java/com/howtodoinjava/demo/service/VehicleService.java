package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.VehicleEntity;
import com.howtodoinjava.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository repository;

    public List<VehicleEntity> getAllVehicles(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<VehicleEntity> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<VehicleEntity>();
        }
    }

    public VehicleEntity getVehicleById(Long id) throws RecordNotFoundException
    {
        Optional<VehicleEntity> vehicle = repository.findById(id);

        if(vehicle.isPresent()) {
            return vehicle.get();
        } else {
            throw new RecordNotFoundException("No vehicle record exist for given id");
        }
    }

    public VehicleEntity createOrUpdateVehicle(VehicleEntity entity) throws RecordNotFoundException
    {
        Optional<VehicleEntity> vehicle = repository.findById(entity.getId());

        if(vehicle.isPresent())
        {
            VehicleEntity newEntity = vehicle.get();
            newEntity.setId(entity.getId());
            newEntity.setName(entity.getName());
            newEntity.setBrand(entity.getBrand());
            newEntity.setPlate(entity.getPlate());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteVehicleById(Long id) throws RecordNotFoundException
    {
        Optional<VehicleEntity> vehicle = repository.findById(id);

        if(vehicle.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No vehicle record exist for given id");
        }
    }
}