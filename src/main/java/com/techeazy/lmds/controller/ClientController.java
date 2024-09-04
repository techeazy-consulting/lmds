package com.techeazy.lmds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.entity.Client;
import com.techeazy.lmds.entity.Order;
import com.techeazy.lmds.response.OrderDetailResponse;
import com.techeazy.lmds.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/registerClient")
	public String registerClient(Client client) {
		
		ResponseEntity<String> registerUser= clientService.registerUser(client);
		if(registerUser.getStatusCode().is2xxSuccessful()) {
			return"success";
		}
		return "not success";
		
	}
	
	@GetMapping("/getOrderDetail/{id}")
	public OrderDetailResponse getOrderDetail(@PathVariable int id) {
		return clientService.getOrderDetail(id);
		
	}
	
	@GetMapping("/getOrderDetail/{order}")
	public OrderDetailResponse uploadOrderDetail(Order order) {
		return clientService.uploadOrderDetail(order);
	}

}
