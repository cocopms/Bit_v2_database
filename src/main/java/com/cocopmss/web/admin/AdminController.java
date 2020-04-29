package com.cocopmss.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocopmss.web.util.Messanger;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired AdminService service;
	
	//crud
	@PostMapping("/register")
	public Messanger post(@RequestBody Admin admin) {
		service.register(admin);
		return Messanger.SUCCESS;
	}
	
	@GetMapping("")
	public List<Admin> list() {
		return service.findAll();
	}
	
	//연구
	@GetMapping("/{employeeNumber}") //이렇게 하는 이유 : url로 너무 다 보일까봐..보안
	public Admin detail(@PathVariable String employeeNumbe) {
		return service.findOne(employeeNumbe);
	}
	
	@PutMapping("/{employeeNumber}") //이렇게 하는 이유 : url로 너무 다 보일까봐..보안
	public Messanger put(@RequestBody Admin admin) {
		service.modify(admin);
		return Messanger.SUCCESS;
	}
	
	@DeleteMapping("/{employeeNumber}") //이렇게 하는 이유 : url로 너무 다 보일까봐..보안
	public Messanger delete(@RequestBody Admin admin) {
		service.remove(admin);
		return Messanger.SUCCESS;
	}
}