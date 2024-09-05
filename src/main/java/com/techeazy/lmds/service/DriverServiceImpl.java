package com.techeazy.lmds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Driver;
import com.techeazy.lmds.entity.Parcel;
import com.techeazy.lmds.repositoryRead.DriverRepoRead;
import com.techeazy.lmds.repositoryRead.ParcelRepoRead;
import com.techeazy.lmds.repositoryWrite.DriverWriteRepo;
import com.techeazy.lmds.requests.DriverRequest;
import com.techeazy.lmds.response.DriverResponse;
import com.techeazy.lmds.utility.Constant;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	DriverRepoRead driverRepoRead;
	
	@Autowired
	DriverWriteRepo driverRepoWrite;
	
	@Autowired
	ParcelRepoRead parcelRepoRead;

	@Override
	public DriverResponse registerDriver(DriverRequest driverRequest) {
		DriverResponse response= new DriverResponse();
		Driver driverDetail=driverRepoRead.getDriverDetail(driverRequest.getMobileNumber(),driverRequest.getEmail());
		if(driverDetail==null) {
			Driver driver= new Driver();
			driver.setName(driverRequest.getName());
			driver.setEmail(driverRequest.getEmail());
			driver.setLicense(driverRequest.getLicense());
			driver.setIsActive('Y');
			driver.setIsDeleted('N');
			driver.setMobile(driverRequest.getMobileNumber());
			driverRepoWrite.save(driver);
			response.setMessage("Registered");
			response.setStatus(0);
			return response;
		}
		response.setMessage("Already Registered");
		response.setStatus(-1);
		return response;
	}

	@Override
	public DriverResponse pickupOrders(DriverRequest driverRequest) {
		DriverResponse response= new DriverResponse();
		List<Parcel> pickParcel=parcelRepoRead.getParcelForDriver(driverRequest.getPincodeServes());
		if(!pickParcel.isEmpty()) {
			for(Parcel parcel:pickParcel) {
				parcel.setStatusCode(1);
				parcel.setParcelStatus("ORDERPICKEDUP");
			}
			response.setParcel(pickParcel);
			response.setMessage("Parcel Pickup by Driver");
			response.setStatus(0);
			return response;
		}
		response.setMessage("No available parcel");
		response.setStatus(-1);
		return response;
		
	}

	@Override
	public DriverResponse updateOrders(Long parcelId, int statusCode) {
		DriverResponse response= new DriverResponse();
		String statusDescription="";
		if(statusCode==Constant.ORDERPICKEDUP) {
			statusDescription="ORDERPICKEDUP";
		}
		if(statusCode==Constant.INTRANSIT) {
			statusDescription="INTRANSIT";
		}
		if(statusCode==Constant.DELIVERED) {
			statusDescription="DELIVERED";
		}
		int update=parcelRepoRead.updateStatus(statusCode,statusDescription,parcelId);
		if(update>=0) {
			response.setMessage("Request Updated");
			response.setStatus(0);
			return response;
		}
		response.setMessage("Request not Updated");
		response.setStatus(-1);
		return response;
	}

}
