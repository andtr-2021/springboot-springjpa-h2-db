INSERT INTO 
	TBL_EMPLOYEES (first_name, last_name, email, phone_number)
VALUES
  	('Lokesh', 'Gupta', 'howtodoinjava@gmail.com', '1234567');


INSERT INTO
	TBL_VEHICLES (name, brand, plate)
VALUES
  	('Camry', 'Honda', '1234'),
  	('Benz', 'Honda', '1235');

INSERT INTO
	TBL_DRIVERS (driver_name, driver_phone_number, driver_license_number, driver_year_of_experience, driver_avatar)
VALUES
  	('John', '011223344', 'E1234', '10', 'John.png');


INSERT INTO
	TBL_USERS (user_name, user_email, user_password, user_phone_number)
VALUES
  	('Tommy', 'tommy@gmail.com', 'tommy123', '01223344');


INSERT INTO
	TBL_PAYMENTS (payment_type, payment_amount, payment_status, payment_date)
VALUES
  	('Cash', '100', 'Paid', '2020-01-01');

INSERT INTO
	TBL_VOUCHERS (voucher_amount, voucher_code, voucher_expire_date)
VALUES
  	('100', 'ABC123', '2020-01-01');

INSERT INTO
	TBL_BOOKINGS (booking_date, user_id, booking_pick_up_location, booking_drop_off_location, booking_pick_up_time, booking_drop_off_time, booking_number_of_passengers ,vehicle_id, driver_id, payment_id)
VALUES
  	('2020-01-01', 1, 'SaiGon', 'HoiAn', '2020-01-01 10:00:00', '2020-01-01 12:00:00', '10', 1, 1, 1);