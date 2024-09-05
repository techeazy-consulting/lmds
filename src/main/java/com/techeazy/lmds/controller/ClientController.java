package com.techeazy.lmds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.requests.NewClientRegister;
import com.techeazy.lmds.response.ClientResponse;
import com.techeazy.lmds.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
//	@PostMapping("/registerClient")
//	public String registerClient(Client client) {
//		
//		ResponseEntity<String> registerUser= clientService.registerUser(client);
//		if(registerUser.getStatusCode().is2xxSuccessful()) {
//			return"success";
//		}
//		return "not success";
//		
//	}
	
	
	
	@PostMapping("/registerClient")
	public ClientResponse registerClient(NewClientRegister client) {
		return clientService.registerClient(client);
	}
	
	

}
