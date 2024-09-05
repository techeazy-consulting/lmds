package com.techeazy.lmds.service;

import java.util.Map;

import com.techeazy.lmds.requests.CustomerRequest;
import com.techeazy.lmds.response.CustomerResponse;

public interface CustomerService {
	
	CustomerResponse getCustomerParcel(CustomerRequest request);
	
	Map<String, String> customerParcelStatus(CustomerRequest request);

}
