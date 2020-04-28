package com.cocopmss.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocopmss.web.util.Messanger;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired AdminService service;
	
	@PostMapping("/register")
	public Messanger register(@RequestBody Admin admin) {
		service.add(admin);
		return Messanger.SUCCESS;
	}
}