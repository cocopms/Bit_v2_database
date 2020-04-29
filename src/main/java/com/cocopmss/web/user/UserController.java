package com.cocopmss.web.user;

import java.util.List;

//상위개념, 일은 서버단에서
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
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;

	// 기본적인 rest API(url)
	@PostMapping("/register")
	public Messanger register(@RequestBody User user) {
		service.register(user);
		return Messanger.SUCCESS;
	}

	@GetMapping("/list")
	public List<User> list() {
		return service.findAll();
	}

	@GetMapping("/{employeeNumber}") //왜 여기부터 이렇게 쓰는가.
	public User detail(@PathVariable String employeeNumber) {
		return service.findOne(employeeNumber);
	}

	@PutMapping("/{employeeNumber}")
	public Messanger put(@RequestBody User user) {
		service.modify(user);
		return Messanger.SUCCESS;
	}

	@DeleteMapping("/{employeeNumber}")
	public Messanger delete(@RequestBody User user) {
		service.remove(user);
		return Messanger.SUCCESS;
	}
}