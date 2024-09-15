package com.techeazy.lmds.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Customer;
import com.techeazy.lmds.entity.Parcel;
import com.techeazy.lmds.repositoryRead.CustomerRepoRead;
import com.techeazy.lmds.repositoryRead.ParcelRepoRead;
import com.techeazy.lmds.repositoryWrite.CustomerWriteRepo;
import com.techeazy.lmds.repositoryWrite.ParcelRepoWrite;
import com.techeazy.lmds.requests.CustomerRequest;
import com.techeazy.lmds.response.CommonResponse;
import com.techeazy.lmds.response.CustomerResponse;
import com.techeazy.lmds.utility.Constant;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	public final static String CANCELLED="CANCELLED"; 

	@Autowired
	CustomerRepoRead customerRepoRead;
	
	@Autowired
	CustomerWriteRepo customerWriteRepo;

	@Autowired
	ParcelRepoRead parcelRepoRead;
	
	@Autowired
	ParcelRepoWrite parcelRepoWrite;

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
	@Cacheable(value="parcel", key="#id")
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

	@Override
	public CommonResponse cancelCustomerParcel(CustomerRequest request) {
		CommonResponse response= new CommonResponse();
		response.setStatus(-1);
		if(request.getMobileNumber()!=0 && request.getEmail()!=null && request.getParcelId()!=0) {
			Customer customer = customerRepoRead.getCustomerByMobileAndEmail(request.getMobileNumber(), request.getEmail());
			if (customer != null) {
				Parcel customerParcel= parcelRepoRead.getCustomerParcelwithParcelId(customer.getId(), request.getParcelId());
				if(customerParcel!=null) {
					int updateStatus=parcelRepoWrite.updateStatus(Constant.CANCELLED, CANCELLED, customerParcel.getParcelId());
					if(updateStatus>0) {
						response.setMessage("Your Parcel has been "+CANCELLED);
						response.setStatus(0);
						return response;
					}
					response.setMessage("Your Parcel cannot be "+CANCELLED);
				}
				response.setMessage("You Do not have parcel with ParcelID: "+customerParcel.getParcelId());
			}
			response.setMessage("Invalid User Mobile and Email combination");
		}
		return response;
		
	}

	@Override
	public CustomerResponse registerCustomer(CustomerRequest request) {

		CustomerResponse response= new CustomerResponse();
		Customer customerDetail=customerRepoRead.getCustomerByMobileAndEmail(request.getMobileNumber(),request.getEmail());
		if(customerDetail==null) {
			Customer customer= new Customer();
			customer.setName(request.getName());
			customer.setEmail(request.getEmail());
			customer.setIsActive('Y');
			customer.setIsDeleted('N');
			customer.setAddress(request.getAddress());
			customer.setPincode(request.getPincode());
			customer.setMobile(request.getMobileNumber());
			customerWriteRepo.save(customer);
			response.setMessage("Registered");
			response.setStatus(0);
			return response;
		}
		response.setMessage("Already Registered");
		response.setStatus(-1);
		return response;
	
		
	}

}
