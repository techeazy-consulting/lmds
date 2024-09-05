package com.techeazy.lmds.response;

import java.util.List;

import com.techeazy.lmds.entity.Parcel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse extends CommonResponse {
	
	List<Parcel> parcel;

}
