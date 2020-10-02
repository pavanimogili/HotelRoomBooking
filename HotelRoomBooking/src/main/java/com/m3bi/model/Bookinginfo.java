package com.m3bi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bookinginfo {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	
	private Long  hotelId;
	private Long  hotelRoomId;
	private Long  userId;
	
	private Date bookingDate;
	
	private String bookingStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getHotelRoomId() {
		return hotelRoomId;
	}

	public void setHotelRoomId(Long hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	
}
