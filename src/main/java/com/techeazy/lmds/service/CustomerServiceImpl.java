package com.techeazy.lmds.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Customer;
import com.techeazy.lmds.entity.Parcel;
import com.techeazy.lmds.repositoryRead.CustomerRepoRead;
import com.techeazy.lmds.repositoryRead.ParcelRepoRead;
import com.techeazy.lmds.requests.CustomerRequest;
import com.techeazy.lmds.response.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepoRead customerRepoRead;

	@Autowired
	ParcelRepoRead parcelRepoRead;

	@Override
	public CustomerResponse getCustomerParcel(CustomerRequest request) {
		CustomerResponse response = new CustomerResponse();
		response.setMessage("There is an Error");
		response.setStatus(-1);
		Customer customer = customerRepoRead.getCustomerByMobileAndEmail(request.getMobileNumber(), request.getEmail());
		if (customer != null) {
			List<Parcel> getParcel = parcelRepoRead.getCustomerParcel(customer.getId());
			if (!getParcel.isEmpty()) {
				response.setParcel(getParcel);
				response.setMessage("Hello " + customer.getName() + " here is your parcel ");
				response.setStatus(0);
			}
			response.setMessage("You Don't have any Parcel");
		}
		response.setMessage("You are not existed in our record. Register yourself first");
		return response;

	}

	// optimize it using redis cluster
	@Override
	public Map<String, String> customerParcelStatus(CustomerRequest request) {
		Map<String, String> parcelStatus = new HashMap<String, String>();
		Customer customer = customerRepoRead.getCustomerByMobileAndEmail(request.getMobileNumber(), request.getEmail());
		if (customer != null) {
			List<Parcel> getParcel = parcelRepoRead.getCustomerParcel(customer.getId());
			if (!getParcel.isEmpty()) {
				for(Parcel parcel:getParcel) {
					parcelStatus.put(parcel.getParcelName(), parcel.getParcelStatus());
				}
			}
		}
		return parcelStatus;


	}

}
