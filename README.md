# HotelRoomBooking

Problem Statement :

There is a hotel booking website.

Expose an API to book a room based on user bonus points.

 

Conditions:
If User has 'n' bonus points and Price to book the hotel is 'n’ ,Status of room changes to "BOOKED".

If User has 'n' bonus points and Price to book the hotel is greater than 'n’ , Status of room changes to "PENDING APPROVAL".

Any changes to user bonus is tracked in the system.

 

Devise a solution with proper architecture and documentation.

Note:
You can make necessary assumptions while devising the solution. Use JAVA , Node.js , Spring and any of the database.

Important points to consider:

1) Clean code

2) Design

3) Tests if possible

4) API documentation

 
SQL schema:



Hibernate: 
    
    drop table if exists bookinginfo
Hibernate: 
    
    drop table if exists hotel
Hibernate: 
    
    drop table if exists hotelroom
Hibernate: 
    
    drop table if exists roominfo
Hibernate: 
    
    drop table if exists user
Hibernate: 
    
    create table bookinginfo (
       id bigint not null auto_increment,
        booking_date datetime(6),
        booking_status varchar(255),
        hotel_id bigint,
        hotel_room_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB
	
	INSERT INTO `hotelbooking`.`bookinginfo` (`booking_date`, `booking_status`, `hotel_id`, `hotel_room_id`, `user_id`) VALUES ('2020-05-29', 'BOOKED', '1', '1', '1');

Hibernate: 
    
    create table hotel (
       hotel_id bigint not null auto_increment,
        area_name varchar(255),
        hotel_name varchar(255),
        primary key (hotel_id)
    ) engine=InnoDB
	
	INSERT INTO `hotelbooking`.`hotel` (`area_name`, `hotel_name`) VALUES ('hyderabad', 'novatel');
INSERT INTO `hotelbooking`.`hotel` (`area_name`, `hotel_name`) VALUES ('doha', 'strato');

Hibernate: 
    
    create table hotelroom (
       id bigint not null auto_increment,
        hotel_id bigint,
        room_type_id bigint,
        primary key (id)
    ) engine=InnoDB
	INSERT INTO `hotelbooking`.`hotelroom` (`hotel_id`, `room_type_id`) VALUES ('1', '2');
INSERT INTO `hotelbooking`.`hotelroom` (`hotel_id`, `room_type_id`) VALUES ('2', '1');

	
Hibernate: 
    
    create table roominfo (
       room_id bigint not null auto_increment,
        room_cost double precision not null,
        room_type varchar(255),
        primary key (room_id)
    ) engine=InnoDB
	
INSERT INTO `hotelbooking`.`roominfo` (`room_cost`, `room_type`) VALUES ('2000', 'r1');
INSERT INTO `hotelbooking`.`roominfo` (`room_cost`, `room_type`) VALUES ('3000', 'r2');
	
	
Hibernate: 
    
    create table user (
       user_id bigint not null auto_increment,
        bonus_points integer not null,
        user_name varchar(255),
        primary key (user_id)
    ) engine=InnoDB
	
	
	ALTER TABLE `hotelbooking`.`user` 
CHANGE COLUMN `bonus_points` `bonus_points` INT NOT NULL DEFAULT 500 ,
CHANGE COLUMN `user_name` `user_name` VARCHAR(255) NOT NULL ;


INSERT INTO `hotelbooking`.`user` (`user_name`) VALUES ('pavani');
INSERT INTO `hotelbooking`.`user` (`user_name`) VALUES ('pranavi');
INSERT INTO `hotelbooking`.`user` (`user_name`) VALUES ('rishabh');
INSERT INTO `hotelbooking`.`user` (`user_name`) VALUES ('samanyu');


postman request collection

https://www.getpostman.com/collections/765a766f0144c1d1972d
