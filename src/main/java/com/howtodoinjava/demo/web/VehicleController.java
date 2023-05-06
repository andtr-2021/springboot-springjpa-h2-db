package com.howtodoinjava.demo.web;

import java.util.List;

import com.howtodoinjava.demo.model.VehicleEntity;
import com.howtodoinjava.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vehicles")
public class VehicleController
{
    @Autowired
    VehicleService service;

    @GetMapping
    public ResponseEntity<List<VehicleEntity>> getAllVehicles(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<VehicleEntity> list = service.getAllVehicles(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<VehicleEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleEntity> getVehicleById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        VehicleEntity entity = service.getVehicleById(id);

        return new ResponseEntity<VehicleEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleEntity> createOrUpdateVehicle(@RequestBody VehicleEntity vehicle)
            throws RecordNotFoundException {
        VehicleEntity updated = service.createOrUpdateVehicle(vehicle);
        return new ResponseEntity<VehicleEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteVehicleById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteVehicleById(id);
        return HttpStatus.FORBIDDEN;
    }

}