package com.m3bi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roominfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  roomId;
	
	private String roomType;
	private double roomCost;
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRoomCost() {
		return roomCost;
	}
	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}
	
}
