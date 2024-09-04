package com.techeazy.lmds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Client;
import com.techeazy.lmds.entity.Order;
import com.techeazy.lmds.repositoryRead.ClientRepositoryRead;
import com.techeazy.lmds.repositoryWrite.ClientRepositoryWrite;
import com.techeazy.lmds.response.OrderDetailResponse;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepositoryRead clientRepositoryRead;

	@Autowired
	private ClientRepositoryWrite clientRepositoryWrite;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Override
	public ResponseEntity<String> registerUser(Client client) {
		
		//
		
		//implement to check if client already register
		
		
		//
		
		try {
			String hashPwd = passwordEncoder.encode(client.getPassword());
			client.setPassword(hashPwd);
			Client savedCustomer = clientRepositoryWrite.save(client);

			if (savedCustomer.getId() > 0) {
				return ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully registered");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
			}
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occurred: " + ex.getMessage());
		}

	}


	@Override
	public OrderDetailResponse getOrderDetail(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OrderDetailResponse uploadOrderDetail(Order Order) {
		// TODO Auto-generated method stub
		return null;
	}




}
