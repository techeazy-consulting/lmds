package com.techeazy.lmds.service;

import com.techeazy.lmds.entity.Parcel;
import com.techeazy.lmds.response.CommonResponse;

public interface ParcelService {
	
	CommonResponse createParcel(Parcel parcel);
	
	

}
