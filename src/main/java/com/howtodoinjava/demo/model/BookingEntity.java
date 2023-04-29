package com.howtodoinjava.demo.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_BOOKINGS")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BookingEntity() {

    }

    @Column(name="booking_date")
    private String bookingDate;

    @ManyToOne
    @Column(name="booking_user_id", nullable=false)
    private UserEntity bookingUserId;
    @Column(name="booking_pick_up_location")
    private String bookingPickUpLocation;

    @Column(name="booking_drop_off_location")
    private String bookingDropOffLocation;

    @Column(name="booking_pick_up_time")
    private String bookingPickUpTime;

    @Column(name="booking_drop_off_time")
    private String bookingDropOffTime;

    @Column(name="booking_number_of_passengers")
    private String bookingNumberOfPassengers;

    @ManyToOne
    @Column(name="booking_vehicle_id")
    private VehicleEntity bookingVehicleId;

    @ManyToOne
    @Column(name="booking_driver_id")
    private DriverEntity bookingDriverId;

    @OneToOne
    @Column(name="booking_payment_id")
    private PaymentEntity bookingPaymentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public UserEntity getBookingUserId() {
        return bookingUserId;
    }

    public void setBookingUserId(UserEntity bookingUserId) {
        this.bookingUserId = bookingUserId;
    }

    public String getBookingPickUpLocation() {
        return bookingPickUpLocation;
    }

    public void setBookingPickUpLocation(String bookingPickUpLocation) {
        this.bookingPickUpLocation = bookingPickUpLocation;
    }

    public String getBookingDropOffLocation() {
        return bookingDropOffLocation;
    }

    public void setBookingDropOffLocation(String bookingDropOffLocation) {
        this.bookingDropOffLocation = bookingDropOffLocation;
    }

    public String getBookingPickUpTime() {
        return bookingPickUpTime;
    }

    public void setBookingPickUpTime(String bookingPickUpTime) {
        this.bookingPickUpTime = bookingPickUpTime;
    }

    public String getBookingDropOffTime() {
        return bookingDropOffTime;
    }

    public void setBookingDropOffTime(String bookingDropOffTime) {
        this.bookingDropOffTime = bookingDropOffTime;
    }

    public String getBookingNumberOfPassengers() {
        return bookingNumberOfPassengers;
    }

    public void setBookingNumberOfPassengers(String bookingNumberOfPassengers) {
        this.bookingNumberOfPassengers = bookingNumberOfPassengers;
    }

    public VehicleEntity getBookingVehicleId() {
        return bookingVehicleId;
    }

    public void setBookingVehicleId(VehicleEntity bookingVehicleId) {
        this.bookingVehicleId = bookingVehicleId;
    }

    public DriverEntity getBookingDriverId() {
        return bookingDriverId;
    }

    public void setBookingDriverId(DriverEntity bookingDriverId) {
        this.bookingDriverId = bookingDriverId;
    }

    public PaymentEntity getBookingPaymentId() {
        return bookingPaymentId;
    }

    public void setBookingPaymentId(PaymentEntity bookingPaymentId) {
        this.bookingPaymentId = bookingPaymentId;
    }
}
