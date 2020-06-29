package com.newer.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.security.service.AccountService;

@RestController
public class joinController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/join")
	public ResponseEntity<String> join(
			@RequestParam("u") String username,
			@RequestParam("p") String password) {
		
		accountService.join(username, password);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
