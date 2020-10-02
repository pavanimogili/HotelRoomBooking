package com.m3bi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3bi.model.Roominfo;
import com.m3bi.service.RoominfoService;

@RestController
@RequestMapping("/room")
public class RoominfoController {
	
	@Autowired
	RoominfoService roominfoService;
	
	@PostMapping("/save")
	public void saveRoom(@RequestBody Roominfo roominfo) {
		roominfoService.save(roominfo);
	}
	
	@GetMapping("/listAll")
	public List<Roominfo> listAllRoomss() {
		return roominfoService.listAll();
	}

	@GetMapping("id/{id}")
	public Roominfo getUserById(@PathVariable Long id) {
		return roominfoService.findByRoomId(id) ;
	}

	@GetMapping("name/{name}")
	public Roominfo getUserById(@PathVariable String name) {
		return roominfoService.findByRoomType(name) ;
	}
}
