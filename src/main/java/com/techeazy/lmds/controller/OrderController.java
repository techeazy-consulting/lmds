package com.techeazy.lmds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.requests.OrderDetailRequest;
import com.techeazy.lmds.requests.OrderFetchRequest;
import com.techeazy.lmds.response.OrderDetailResponse;
import com.techeazy.lmds.service.OrderDetailService;

@RestController
public class OrderController {

	@Autowired
	OrderDetailService orderDetailService;

	@PostMapping("/createClientOrder")
	public OrderDetailResponse createOrder(OrderDetailRequest orderRequest) {
		return orderDetailService.createOrder(orderRequest);

	}
	
	@GetMapping("/getClientOrder")
	public OrderDetailResponse getOrder(OrderFetchRequest orderRequest) {
		return orderDetailService.getOrderOfClient(orderRequest);

	}

}
