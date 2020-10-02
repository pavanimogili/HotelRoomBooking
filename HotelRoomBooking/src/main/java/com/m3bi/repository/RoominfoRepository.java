package com.m3bi.repository;

import org.springframework.data.repository.CrudRepository;

import com.m3bi.model.Roominfo;

public interface RoominfoRepository extends CrudRepository<Roominfo, Long>{
	
	public Roominfo findByRoomType(String roomType);

}
