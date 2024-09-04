package com.techeazy.lmds.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewClientRegister {
	
	private String name;
	private String role;
	private Long mobile;
	private String email;
	private String password;
	
	

}
