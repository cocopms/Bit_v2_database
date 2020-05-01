package com.cocopmss.web;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootConfiguration
@Controller
public class HomeController {
		@GetMapping("/")
		public String hello() {
			return "index"; //html 붙이면 static으로 넘어감
		}
		@GetMapping("/home") //thymeleaf와 맞춰주기
		public String home() {
			return "user";
		}
		@GetMapping("/admin")
		public String admin() {
			return "admin";
		}
}