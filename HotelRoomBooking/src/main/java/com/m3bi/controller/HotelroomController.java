package com.m3bi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3bi.model.Hotel;
import com.m3bi.model.Hotelroom;
import com.m3bi.service.HotelService;
import com.m3bi.service.HotelroomService;

@RestController
@RequestMapping("/Hotelroom")
public class HotelroomController {
	
	@Autowired
	HotelroomService hotelroomService;
	
	@PostMapping("/save")
	public void saveHotel(@RequestBody Hotelroom hotelroom) {
		hotelroomService.save(hotelroom);
	}
	
	@GetMapping("/listAll")
	public List<Hotelroom> listAllHotels() {
		return hotelroomService.listHotelRooms();
	}
	
	
	@GetMapping("/hotelId/{id}")
	public List<Hotelroom> findByHotelId(@PathVariable Long id) {
		return hotelroomService.findByHotelId(id);
	}
	 
	
	@GetMapping("/roomId/{id}")
	public List<Hotelroom> findByRoomTypeId(@PathVariable Long id) {
		return hotelroomService.findByRoomTypeId(id);
	}

}
