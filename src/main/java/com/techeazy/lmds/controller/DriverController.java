package com.techeazy.lmds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.requests.DriverRequest;
import com.techeazy.lmds.response.DriverResponse;
import com.techeazy.lmds.service.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@PostMapping("/registerDriver")
	public DriverResponse registerDriver(DriverRequest request) {
		return driverService.registerDriver(request);
	}
	
	
	@GetMapping("/pickupParcels")
	public DriverResponse pickupParcel(DriverRequest request) {
		return driverService.registerDriver(request);
	}
	
	@PostMapping("/updateParcels")
	public DriverResponse update(DriverRequest request) {
		return driverService.registerDriver(request);
	}

}
