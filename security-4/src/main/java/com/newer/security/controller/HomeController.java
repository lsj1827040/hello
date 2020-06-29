package com.newer.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/user")
	public String user(){
		return "普通用户";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "后台管理";
	}
}
