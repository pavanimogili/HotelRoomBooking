package com.m3bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m3bi.exception.BookingExceptions;
import com.m3bi.model.Bookinginfo;
import com.m3bi.model.Hotel;
import com.m3bi.repository.BookinginfoRepository;

@Service
@Transactional
public class BookinginfoService {
	@Autowired
	BookinginfoRepository repo;

	public List<Bookinginfo> findByUserIdAndBookingStatus(Long id, String bookingStatus) {

		return repo.findByUserIdAndBookingStatus(id, bookingStatus);
	}

	public void saveAll(List<Bookinginfo> confirmedBookings) {
		repo.saveAll(confirmedBookings);
	}

	public List<Bookinginfo> listAllBookings() {
        return (List<Bookinginfo>) repo.findAll();
        		}
	public void save(Bookinginfo bookinginfo) throws BookingExceptions, Exception {
		repo.save(bookinginfo);

	}
}