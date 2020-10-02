package com.m3bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m3bi.model.Hotelroom;
import com.m3bi.repository.HotelroomRepository;

@Service
@Transactional
public class HotelroomService {

	
	@Autowired HotelroomRepository repo;
	
	public void save(Hotelroom hotelroom) {
		repo.save(hotelroom);
	}

	public List<Hotelroom> findByHotelId(Long hotelId) {
		return  repo.findByHotelId(hotelId);
	}
	
	public List<Hotelroom> listHotelRooms() {
		return (List<Hotelroom>) repo.findAll();
	}
	
	public List<Hotelroom> findByRoomTypeId(Long roomTypeId) {
		return  repo.findByRoomTypeId(roomTypeId);
	}
	
	public Hotelroom  findByHotelIdAndRoomTypeId(Long hotelId,Long roomTypeId) {
		return repo.findByHotelIdAndRoomTypeId(hotelId,roomTypeId);
		
	}

}
