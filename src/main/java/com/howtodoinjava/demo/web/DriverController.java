package com.howtodoinjava.demo.web;

import java.util.List;

import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.model.VehicleEntity;
import com.howtodoinjava.demo.service.DriverService;
import com.howtodoinjava.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/drivers")
public class DriverController
{
    @Autowired
    DriverService service;

    @GetMapping
    public ResponseEntity<List<DriverEntity>> getAllDrivers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<DriverEntity> list = service.getAllDrivers(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<DriverEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverEntity> getDriverById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        DriverEntity entity = service.getDriverById(id);

        return new ResponseEntity<DriverEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DriverEntity> createOrUpdateDriver(DriverEntity driver)
            throws RecordNotFoundException {
        DriverEntity updated = service.createOrUpdateDriver(driver);
        return new ResponseEntity<DriverEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDriverById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteDriverById(id);
        return HttpStatus.FORBIDDEN;
    }

}