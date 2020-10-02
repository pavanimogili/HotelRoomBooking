package com.m3bi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3bi.exception.BookingExceptions;
import com.m3bi.model.Bookinginfo;
import com.m3bi.model.Hotel;
import com.m3bi.model.HotelRoomBookingRequest;
import com.m3bi.model.Hotelroom;
import com.m3bi.model.Roominfo;
import com.m3bi.model.User;
import com.m3bi.service.BookinginfoService;
import com.m3bi.service.HotelService;
import com.m3bi.service.HotelroomService;
import com.m3bi.service.RoominfoService;
import com.m3bi.service.UserService;
import com.m3bi.util.Constants;

@RestController
@RequestMapping("/booking")
public class BookinginfoController {
	
	@Autowired
	BookinginfoService bookinginfoService;
	@Autowired
	HotelService hotelService;

	@Autowired
	HotelroomService hotelroomService;

	@Autowired
	RoominfoService roominfoService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/listAll")
	public List<Bookinginfo> listAllHotels() {
		return bookinginfoService.listAllBookings();
	}
	
	
	@PostMapping("/save")
	public void save(@RequestBody HotelRoomBookingRequest bookingReq) throws BookingExceptions, Exception {

		if (!StringUtils.isEmpty(bookingReq.getHotelName())) {
			String hotelName = bookingReq.getHotelName();
			Hotel hotel = hotelService.findByHotelName(bookingReq.getHotelName());

			if (null != hotel) {

				Roominfo roominfo = roominfoService.findByRoomType(bookingReq.getRoomType());

				if (null != roominfo) {

					Hotelroom hotelroom = hotelroomService.findByHotelIdAndRoomTypeId(hotel.getHotelId(),
							roominfo.getRoomId());
					if (null != hotelroom) {
						User user = userService.search(bookingReq.getUserName());
						if (null != user) {

							Date bookingDate = bookingReq.getBookingDate();
							long millis = System.currentTimeMillis();
							Date currentDate = new Date(millis);
							if (!bookingDate.before(currentDate)) {
								Bookinginfo bookinginfo = new Bookinginfo();
								bookinginfo.setBookingDate(bookingDate);
								bookinginfo.setBookingStatus(
										(roominfo.getRoomCost() <= user.getBonusPoints()) ? Constants.BOOKED
												: Constants.PENDING_APPROVAL);
								bookinginfo.setHotelId(hotel.getHotelId());
								bookinginfo.setHotelRoomId(roominfo.getRoomId());
								bookinginfo.setUserId(user.getUserId());
								bookinginfoService.save(bookinginfo);

								if (Constants.BOOKED.equals(bookinginfo.getBookingStatus())) {

									user.setBonusPoints((user.getBonusPoints() - (int) roominfo.getRoomCost()));
									userService.save(user);
								}
							} else {
								throw new BookingExceptions("only accepts future bookings");
							}

						} else {
							throw new BookingExceptions("user " + bookingReq.getUserName() + " is not found in repo");
						}
					} else {
						throw new BookingExceptions(
								"Room Type  " + bookingReq.getRoomType() + " is not found in Hotel " + hotelName + ".");
					}
				} else {
					throw new BookingExceptions(
							"Room Type  " + bookingReq.getRoomType() + " is not found in repository.");
				}

			} else {
				throw new BookingExceptions("Hotel " + hotelName + " is not found in repository.");
			}

		} else {
			throw new BookingExceptions("Hotel name field is empty.");
		}

	}


}
