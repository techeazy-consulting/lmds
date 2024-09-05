package com.techeazy.lmds.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverRequest extends CommonRequest{
	
	private String name;
	private String license;
	private int age;
	private String adress;
	private List<Long> pincodeServes;
	

}
