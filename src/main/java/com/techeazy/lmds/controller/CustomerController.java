package com.techeazy.lmds.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.requests.CustomerRequest;
import com.techeazy.lmds.response.CommonResponse;
import com.techeazy.lmds.response.CustomerResponse;
import com.techeazy.lmds.service.CustomerService;

@RestController
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/registerCustomer")
	public CommonResponse registerCustomer(CustomerRequest request) {
		return customerService.registerCustomer(request);
	}
	
	
	@GetMapping("/getCustomerParcelStatus")
	public CustomerResponse getCustomerParcel(CustomerRequest request) {
		return customerService.getCustomerParcel(request);
	}
	
	@PostMapping("/cancelCustomerParcels")
	public CommonResponse cancelCustomerParcel(CustomerRequest request) {
		return customerService.cancelCustomerParcel(request);
	}
	
	@GetMapping("/getCustomerAllParcelStatus")
	public Map<String, String> customerParcelStatus(CustomerRequest request) {
		return customerService.customerParcelStatus(request);
	}
	
}
