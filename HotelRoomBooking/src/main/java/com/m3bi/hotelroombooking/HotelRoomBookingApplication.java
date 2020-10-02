package com.m3bi.hotelroombooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.m3bi.*")
@EnableJpaRepositories(basePackages = "com.m3bi.*")
@EntityScan(basePackages = "com.m3bi.*")
public class HotelRoomBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRoomBookingApplication.class, args);
	}

}
