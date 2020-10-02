package com.m3bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m3bi.model.Hotel;
import com.m3bi.repository.HotelRepository;

@Service
@Transactional
public class HotelService {
	
	@Autowired HotelRepository repo;
	
	public void save(Hotel hotel) {
        repo.save(hotel);
    }
     
    public List<Hotel> listAllHotels() {
        return (List<Hotel>) repo.findAll();
        		}
     
    public Hotel get(Long id) {
        return repo.findById(id).get();
    }

    public Hotel findByHotelName(String hotelName) {
        return repo.findByHotelName(hotelName);
    }
}
