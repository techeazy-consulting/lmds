package com.techeazy.lmds.controller;

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

	@GetMapping("/greetings")
	public String getMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
		return helloService.greetUser(name);
	}
}
