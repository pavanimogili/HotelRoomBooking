package com.m3bi.repository;

import org.springframework.data.repository.CrudRepository;

import com.m3bi.model.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Long>{
	
	public Hotel findByHotelName(String hotelName);

}
