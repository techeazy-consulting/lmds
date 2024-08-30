package com.techeazy.lmds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.entity.Client;
import com.techeazy.lmds.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/registerClient")
	public String registerClient(Client client) {
		
		ResponseEntity<String> registerUser= clientService.registerUser(client);
		if(registerUser.getStatusCode().is2xxSuccessful()) {
			return"success";
		}
		return "not success";
		
	}

}
