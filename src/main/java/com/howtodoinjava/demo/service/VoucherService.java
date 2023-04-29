package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.VoucherEntity;
import com.howtodoinjava.demo.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@Service
public class VoucherService {

    @Autowired
    VoucherRepository repository;

    public List<VoucherEntity> getAllVouchers(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<VoucherEntity> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<VoucherEntity>();
        }
    }

    public VoucherEntity getVoucherById(Long id) throws RecordNotFoundException
    {
        Optional<VoucherEntity> voucher = repository.findById(id);

        if(voucher.isPresent()) {
            return voucher.get();
        } else {
            throw new RecordNotFoundException("No voucher record exist for given id");
        }
    }

    public VoucherEntity createOrUpdateVoucher(VoucherEntity entity) throws RecordNotFoundException
    {
        Optional<VoucherEntity> voucher = repository.findById(entity.getId());

        if(voucher.isPresent())
        {
            VoucherEntity newEntity = voucher.get();
            newEntity.setId(entity.getId());
            newEntity.setVoucherAmount(entity.getVoucherAmount());
            newEntity.setVoucherCode(entity.getVoucherCode());
            newEntity.setVoucherExpiryDate(entity.getVoucherExpiryDate());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteVoucherById(Long id) throws RecordNotFoundException
    {
        Optional<VoucherEntity> voucher = repository.findById(id);

        if(voucher.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No voucher record exist for given id");
        }
    }
}