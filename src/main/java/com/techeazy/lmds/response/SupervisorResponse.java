package com.techeazy.lmds.response;

import java.util.List;

import com.techeazy.lmds.entity.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupervisorResponse extends CommonResponse{
	
	List<Order> orders;

}
