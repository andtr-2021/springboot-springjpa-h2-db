package com.howtodoinjava.demo.web;

import java.util.List;


import com.howtodoinjava.demo.model.BookingEntity;
import com.howtodoinjava.demo.service.BookingService;
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
@RequestMapping("/bookings")
public class BookingController
{
    @Autowired
    BookingService service;

    @GetMapping
    public ResponseEntity<List<BookingEntity>> getAllBookings(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<BookingEntity> list = service.getAllBookings(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<BookingEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingEntity> getBookingById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        BookingEntity entity = service.getBookingById(id);

        return new ResponseEntity<BookingEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingEntity> createOrUpdateBooking(BookingEntity booking)
            throws RecordNotFoundException {
        BookingEntity updated = service.createOrUpdateBooking(booking);
        return new ResponseEntity<BookingEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteBookingById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteBookingById(id);
        return HttpStatus.FORBIDDEN;
    }

}