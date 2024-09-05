package com.techeazy.lmds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.requests.SupervisorRequest;
import com.techeazy.lmds.response.SupervisorResponse;
import com.techeazy.lmds.service.SupervisorService;

@RestController
public class SupervisorController {
	
	@Autowired
	SupervisorService supervisorService;
	
	@GetMapping("/getAllClientsOrder")
	public SupervisorResponse getAllClientOrders(SupervisorRequest request) {
		return supervisorService.getAllOrderOfClients(request);
	}
	
	@GetMapping("/getParticularClientOrder")
	public SupervisorResponse getParticularClientOrder(SupervisorRequest request) {
		return supervisorService.getParticularClientOrder(request);
	}

  }
