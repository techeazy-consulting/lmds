package com.techeazy.lmds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.entity.Parcel;
import com.techeazy.lmds.response.CommonResponse;
import com.techeazy.lmds.service.ParcelService;

@RestController
public class ParcelController {
	
	@Autowired
	ParcelService parcelService;
	
	@GetMapping("/addParcelInOrder")
	public CommonResponse addParcel(Parcel parcel) {
		return parcelService.createParcel(parcel);

	}

}
