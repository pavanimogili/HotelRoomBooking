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
import com.m3bi.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	
	@Autowired
	HotelService hotelService;
	
	@PostMapping("/save")
	public void saveHotel(@RequestBody Hotel hotel) {
		hotelService.save(hotel);
	}
	
	@GetMapping("/listAll")
	public List<Hotel> listAllHotels() {
		return hotelService.listAllHotels();
	}

	@GetMapping("id/{id}")
	public Hotel getUserById(@PathVariable Long id) {
		return hotelService.get(id) ;
	}
}
