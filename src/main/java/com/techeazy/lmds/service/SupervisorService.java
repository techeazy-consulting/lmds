package com.techeazy.lmds.service;

import com.techeazy.lmds.requests.CommonRequest;
import com.techeazy.lmds.requests.SupervisorRequest;
import com.techeazy.lmds.response.SupervisorResponse;

public interface SupervisorService {
	
	SupervisorResponse getAllOrderOfClients(CommonRequest request);
	
	SupervisorResponse getAllOrdersByLocation(SupervisorRequest request);
	
	SupervisorResponse getAllOrdersByPincode(SupervisorRequest request);
	
	SupervisorResponse getParticularClientOrder(SupervisorRequest request);

}
