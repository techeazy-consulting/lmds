package com.techeazy.lmds.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Order;
import com.techeazy.lmds.repositoryRead.OderDetailRepoRead;
import com.techeazy.lmds.repositoryRead.ParcelRepoRead;
import com.techeazy.lmds.requests.CommonRequest;
import com.techeazy.lmds.requests.SupervisorRequest;
import com.techeazy.lmds.response.SupervisorResponse;

@Service
public class SupervisorServiceImpl implements SupervisorService {

	@Autowired
	OderDetailRepoRead oderDetailRepoRead;
	
	@Autowired
	ParcelRepoRead parcelRepoRead;

	@Override
	public SupervisorResponse getAllOrderOfClients(CommonRequest request) {
		SupervisorResponse response= new SupervisorResponse();
		List<Order> getAllOrders=oderDetailRepoRead.getAllClientsOrder();
		if(!getAllOrders.isEmpty()) {
			response.setOrders(getAllOrders);
			response.setMessage("All Clients Orders");
			response.setStatus(0);
			return response;
		}
		response.setMessage("No Orders");
		response.setStatus(0);
		return response;
	}

	@Override
	public SupervisorResponse getAllOrdersByLocation(SupervisorRequest request) {
		SupervisorResponse response= new SupervisorResponse();
		List<Order> getAllOrders=oderDetailRepoRead.getAllOrdersByLocation(request.getAddress());
		if(!getAllOrders.isEmpty()) {
			response.setOrders(getAllOrders);
			response.setMessage("Location Based Orders");
			response.setStatus(0);
			return response;
		}
		response.setMessage("No Orders");
		response.setStatus(0);
		return response;
	}

	@Override
	public SupervisorResponse getAllOrdersByPincode(SupervisorRequest request) {
		SupervisorResponse response= new SupervisorResponse();
		List<Order> getAllOrders=oderDetailRepoRead.getAllOrdersByPincode(request.getPincode());
		if(!getAllOrders.isEmpty()) {
			response.setOrders(getAllOrders);
			response.setMessage("Pincode Based Orders");
			response.setStatus(0);
			return response;
		}
		response.setMessage("No Orders");
		response.setStatus(-1);
		return response;
	}

	@Override
	public SupervisorResponse getParticularClientOrder(SupervisorRequest request) {
		SupervisorResponse response= new SupervisorResponse();
		Order order= oderDetailRepoRead.getClientOrder(request.getClientId());
		if(order!=null) {
			response.setOrders(Arrays.asList(order));
			response.setMessage("Client order for clientId "+request.getClientId());
			response.setStatus(0);
			return response;
		}
		response.setMessage("No order for "+request.getClientId() +" exist");
		response.setStatus(-1);
		return response;

	}
	




}
