package com.m3bi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.m3bi.model.Hotelroom;

public interface HotelroomRepository extends CrudRepository<Hotelroom, Long> {
	
	public List<Hotelroom> findByHotelId(Long hotelId);

	public List<Hotelroom> findByRoomTypeId(Long roomTypeId);
	
	public Hotelroom findByHotelIdAndRoomTypeId(Long hotelId,Long roomTypeId);

}
