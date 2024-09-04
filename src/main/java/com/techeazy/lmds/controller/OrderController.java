package com.techeazy.lmds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.requests.OrderDetailRequest;
import com.techeazy.lmds.response.OrderDetailResponse;
import com.techeazy.lmds.service.OrderDetailService;

@RestController
public class OrderController {

	@Autowired
	OrderDetailService orderDetailService;

	@PostMapping("/createOrder")
	public OrderDetailResponse createOrder(@RequestBody OrderDetailRequest orderRequest) {
		return orderDetailService.createOrder(orderRequest);

	}

}
