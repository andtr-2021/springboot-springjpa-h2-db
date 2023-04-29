package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.BookingEntity;
import com.howtodoinjava.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public List<BookingEntity> getAllBookings(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<BookingEntity> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<BookingEntity>();
        }
    }

    public BookingEntity getBookingById(Long id) throws RecordNotFoundException
    {
        Optional<BookingEntity> booking = repository.findById(id);

        if(booking.isPresent()) {
            return booking.get();
        } else {
            throw new RecordNotFoundException("No booking record exist for given id");
        }
    }

    public BookingEntity createOrUpdateBooking(BookingEntity entity) throws RecordNotFoundException
    {
        Optional<BookingEntity> booking = repository.findById(entity.getId());

        if(booking.isPresent())
        {
            BookingEntity newEntity = booking.get();
            newEntity.setId(entity.getId());
            newEntity.setBookingDate(entity.getBookingDate());
            newEntity.setUser(entity.getUser());
            newEntity.setBookingPickUpLocation(entity.getBookingPickUpLocation());
            newEntity.setBookingDropOffLocation(entity.getBookingDropOffLocation());
            newEntity.setBookingPickUpTime(entity.getBookingPickUpTime());
            newEntity.setBookingDropOffTime(entity.getBookingDropOffTime());
            newEntity.setBookingNumberOfPassengers(entity.getBookingNumberOfPassengers());
            newEntity.setVehicle(entity.getVehicle());
            newEntity.setDriver(entity.getDriver());
            newEntity.setPayment(entity.getPayment());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteBookingById(Long id) throws RecordNotFoundException
    {
        Optional<BookingEntity> booking = repository.findById(id);

        if(booking.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No booking record exist for given id");
        }
    }
}
