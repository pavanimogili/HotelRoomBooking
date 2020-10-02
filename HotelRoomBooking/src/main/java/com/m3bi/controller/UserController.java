package com.m3bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3bi.model.Bookinginfo;
import com.m3bi.model.Roominfo;
import com.m3bi.model.User;
import com.m3bi.service.BookinginfoService;
import com.m3bi.service.RoominfoService;
import com.m3bi.service.UserService;
import com.m3bi.util.Constants;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookinginfoService bookinginfoService;//RoominfoService
	
	@Autowired
	RoominfoService roominfoService;
	

	@PostMapping("/save")
	public void saveUser(@RequestBody User user) {
		userService.save(user);
	}
	
	@PutMapping("/update")
	public void updateUser(@RequestBody User user) {
		User existingUserinfo = userService.search(user.getUserName());
		if(existingUserinfo != null && existingUserinfo.getBonusPoints() != user.getBonusPoints()) {
			existingUserinfo.setBonusPoints(existingUserinfo.getBonusPoints() + user.getBonusPoints());
			
			
			List<Bookinginfo> pendingBookingsOfUser = bookinginfoService.findByUserIdAndBookingStatus(user.getUserId(), Constants.PENDING_APPROVAL);
			List<Bookinginfo> confirmedBookings = new ArrayList<>();
			
					for(Bookinginfo bookinginfo :pendingBookingsOfUser) {
						Roominfo roominfo = roominfoService.findByRoomId(bookinginfo.getHotelRoomId());
						int roomCost = (int) roominfo.getRoomCost();
						if(roomCost <= existingUserinfo.getBonusPoints() ) {
							bookinginfo.setBookingStatus(Constants.BOOKED) ;
							confirmedBookings.add(bookinginfo);
							existingUserinfo.setBonusPoints(existingUserinfo.getBonusPoints()-roomCost);
						}
					}
					if(confirmedBookings.size()>0) {
						
						bookinginfoService.saveAll(confirmedBookings);
					}
					
					userService.save(existingUserinfo);	
		}
	}

	@GetMapping("/listAll")
	public List<User> getUsers() {
		return userService.listAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.get(id);
	}
}
