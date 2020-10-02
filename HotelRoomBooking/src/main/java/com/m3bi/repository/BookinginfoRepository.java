package com.m3bi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.m3bi.model.Bookinginfo;

public interface BookinginfoRepository extends CrudRepository<Bookinginfo, Long> {
	
	public List<Bookinginfo> findByUserIdAndBookingStatus(Long id,String bookingStatus);

}
