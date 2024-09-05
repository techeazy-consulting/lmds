package com.techeazy.lmds.service;

import org.springframework.http.ResponseEntity;

import com.techeazy.lmds.entity.Client;
import com.techeazy.lmds.requests.NewClientRegister;
import com.techeazy.lmds.response.ClientResponse;

public interface ClientService {

	ResponseEntity<String> registerUser(Client client);
	//OrderDetailResponse getOrderDetail(long clientId);
	//OrderDetailResponse uploadOrderDetail(Order Order);
	ClientResponse registerClient(NewClientRegister newClient);
}
