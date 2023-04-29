package com.howtodoinjava.demo.web;

import java.util.List;


import com.howtodoinjava.demo.model.VoucherEntity;
import com.howtodoinjava.demo.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.howtodoinjava.demo.exception.RecordNotFoundException;

@RestController
@RequestMapping("/vouchers")
public class VoucherController
{
    @Autowired
    VoucherService service;

    @GetMapping
    public ResponseEntity<List<VoucherEntity>> getAllVouchers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<VoucherEntity> list = service.getAllVouchers(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<VoucherEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoucherEntity> getVoucherById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        VoucherEntity entity = service.getVoucherById(id);

        return new ResponseEntity<VoucherEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VoucherEntity> createOrUpdateVoucher(VoucherEntity voucher)
            throws RecordNotFoundException {
        VoucherEntity updated = service.createOrUpdateVoucher(voucher);
        return new ResponseEntity<VoucherEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteVoucherById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteVoucherById(id);
        return HttpStatus.FORBIDDEN;
    }

}