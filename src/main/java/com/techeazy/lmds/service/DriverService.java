package com.techeazy.lmds.service;

import com.techeazy.lmds.requests.DriverRequest;
import com.techeazy.lmds.response.DriverResponse;

public interface DriverService {
	
	DriverResponse registerDriver(DriverRequest driverRequest);
	DriverResponse pickupOrders(DriverRequest driverRequest);
	DriverResponse updateOrders(Long parcelId, int statusCode);

}
