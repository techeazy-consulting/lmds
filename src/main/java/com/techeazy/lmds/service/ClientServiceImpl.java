package com.techeazy.lmds.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Client;
import com.techeazy.lmds.repositoryRead.ClientRepositoryRead;
import com.techeazy.lmds.repositoryWrite.ClientRepositoryWrite;
import com.techeazy.lmds.requests.NewClientRegister;
import com.techeazy.lmds.response.ClientResponse;
import com.techeazy.lmds.utility.LMDSUtility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

		// implement to check if client already register

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
	public ClientResponse registerClient(NewClientRegister newClient) {
		ClientResponse response = new ClientResponse();
		if (!Objects.isNull(newClient)) {
			Client getClient = clientRepositoryRead.getClientdetailByMobileEmail(newClient.getMobile(),
					newClient.getEmail());
			Client client = new Client();
			log.info("GET Client {}", getClient);
			if (getClient == null) {
				client.setCreateDate(LMDSUtility.getDate());
				client.setEmail(newClient.getEmail());
				client.setIsActive('Y');
				client.setIsDeleted('N');
				client.setIsOrderCreated('N');
				client.setName(newClient.getName());
				client.setPassword(newClient.getPassword());
				client.setRole(newClient.getRole());
				client.setMobile(newClient.getMobile());

				clientRepositoryWrite.save(client);
				response.setName(newClient.getName());
				response.setMobile(newClient.getMobile());
				response.setMessage("Thanks For Registring");
				response.setStatus(0);
				return response;
			}
			response.setMessage("You are already Registered");
			response.setStatus(-1);
			return response;
		}
		response.setMessage("Please entered your detail");
		response.setStatus(-1);
		return response;
	}

}
