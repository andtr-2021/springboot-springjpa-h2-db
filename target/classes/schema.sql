DROP TABLE IF EXISTS TBL_EMPLOYEES;
 
CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  phone_number VARCHAR(250) DEFAULT NULL,
  password VARCHAR(250) DEFAULT NULL,
  role VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS TBL_VEHICLES;

CREATE TABLE TBL_VEHICLES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  brand VARCHAR(250) NOT NULL,
  plate VARCHAR(250) NOT NULL,
  color VARCHAR(250) NOT NULL,
  seat_number VARCHAR(250) NOT NULL

);

DROP TABLE IF EXISTS TBL_DRIVERS;

  CREATE TABLE TBL_DRIVERS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    driver_name VARCHAR(250) NOT NULL,
    driver_phone_number VARCHAR(250) NOT NULL,
    driver_license_number VARCHAR(250) NOT NULL,
    driver_year_of_experience VARCHAR(250) NOT NULL,
    driver_avatar VARCHAR(250) NOT NULL,
    driver_password VARCHAR(250) NOT NULL

  );

  DROP TABLE IF EXISTS TBL_USERS;

  CREATE TABLE TBL_USERS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    user_email VARCHAR(250) NOT NULL,
    user_password VARCHAR(250) NOT NULL,
    user_phone_number VARCHAR(250) NOT NULL

  );

  DROP TABLE IF EXISTS TBL_PAYMENTS;

  CREATE TABLE TBL_PAYMENTS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    payment_type VARCHAR(250) NOT NULL,
    payment_amount VARCHAR(250) NOT NULL,
    payment_status VARCHAR(250) NOT NULL,
    payment_date VARCHAR(250) NOT NULL
  );

   DROP TABLE IF EXISTS TBL_VOUCHERS;

    CREATE TABLE TBL_VOUCHERS (
      id INT AUTO_INCREMENT  PRIMARY KEY,
      voucher_amount VARCHAR(250) NOT NULL,
      voucher_code VARCHAR(250) NOT NULL,
      voucher_expire_date VARCHAR(250) NOT NULL,
    );

    DROP TABLE IF EXISTS TBL_BOOKINGS;

    CREATE TABLE TBL_BOOKINGS (
      id INT AUTO_INCREMENT  PRIMARY KEY,
      booking_date VARCHAR(250) NOT NULL,
      user_id INT NOT NULL,
      booking_pick_up_location VARCHAR(250) NOT NULL,
      booking_drop_off_location VARCHAR(250) NOT NULL,
      booking_pick_up_time VARCHAR(250) NOT NULL,
      booking_drop_off_time VARCHAR(250) NOT NULL,
      booking_number_of_passengers VARCHAR(250) NOT NULL,
      vehicle_id INT NOT NULL,
      driver_id INT NOT NULL,
      payment_id INT NOT NULL,
      booking_status VARCHAR(250) NOT NULL

    );
