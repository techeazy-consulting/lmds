package com.techeazy.lmds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.requests.OrderDetailRequest;
import com.techeazy.lmds.requests.OrderFetchRequest;
import com.techeazy.lmds.requests.ParcelRequest;
import com.techeazy.lmds.response.OrderDetailResponse;
import com.techeazy.lmds.service.OrderDetailService;

@RestController
public class OrderController {

	@Autowired
	OrderDetailService orderDetailService;

	
	//http://localhost:9090/createClientOrder?mobileNumber=987654321&email=amazon.com&role=client&parcels[name]=iphone 16&parcels[pincode]=110009&parcels[address]=delhi&parcels[customerId]=2&parcels[name]=iphone 14&parcels[pincode]=110009&parcels[address]=delhi&parcels[customerId]=3

	
	@PostMapping("/createClientOrder")
	public OrderDetailResponse createOrder(@RequestParam Map<String, String> allParams) {
		OrderDetailRequest orderRequest = new OrderDetailRequest();
		orderRequest.setMobileNumber(Long.valueOf(allParams.get("mobileNumber")));
		orderRequest.setEmail(allParams.get("email"));
		orderRequest.setRole(allParams.get("role"));

		List<ParcelRequest> parcels = new ArrayList<>();
		int i = 0;
		while (allParams.containsKey("parcels[" + i + "][name]")) {
			ParcelRequest parcel = new ParcelRequest();
			parcel.setName(allParams.get("parcels[" + i + "][name]"));
			parcel.setPincode(Long.valueOf(allParams.get("parcels[" + i + "][pincode]")));
			parcel.setAddress(allParams.get("parcels[" + i + "][address]"));
			parcel.setCustomerId(Long.parseLong(allParams.get("parcels[" + i + "][customerId]")));
			parcels.add(parcel);
			i++;

		}
		orderRequest.setParcels(parcels);
		return orderDetailService.createOrder(orderRequest);

	}
	
	@GetMapping("/getClientOrder")
	public OrderDetailResponse getOrder(OrderFetchRequest orderRequest) {
		return orderDetailService.getOrderOfClient(orderRequest);

	}

}
