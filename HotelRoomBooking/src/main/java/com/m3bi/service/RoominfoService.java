package com.m3bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m3bi.model.Roominfo;
import com.m3bi.model.User;
import com.m3bi.repository.RoominfoRepository;

@Service
@Transactional
public class RoominfoService {
	
	@Autowired RoominfoRepository repo;

	public Roominfo findByRoomId(Long hotelRoomId) {
		return repo.findById(hotelRoomId).get();
	}
	
	public Roominfo findByRoomType(String roomType) {
		return repo.findByRoomType(roomType);
		
	}

	public void save(Roominfo roominfo) {
		repo.save(roominfo);
	}

	 public List<Roominfo> listAll() {
	        return (List<Roominfo>) repo.findAll();
	        		}
}
