package com.techeazy.lmds.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.service.HelloService;

@RestController
@RequestMapping("/api")
public class HelloResource {
	@Autowired
	private HelloService helloService;

	@GetMapping("/admin/greetings")
	public String getMessageAdmin(@RequestParam(value = "name", defaultValue = "admin") String name) {
		return helloService.greetUser(name);
	}

	@GetMapping("/user/greetings")
	public String getMessageUser(@RequestParam(value = "name", defaultValue = "user") String name) {
		return helloService.greetUser(name);
	}
}
