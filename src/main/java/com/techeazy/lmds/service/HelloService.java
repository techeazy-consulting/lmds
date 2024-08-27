package com.techeazy.lmds.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	public String greetUser(String userName) {
		return "Hello  " + userName;
	}
}
