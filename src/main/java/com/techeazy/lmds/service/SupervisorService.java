package com.techeazy.lmds.service;

import java.util.List;

import com.techeazy.lmds.entity.Order;

public interface SupervisorService {
	
	List<Order> getAllorder();
	
	List<Order> getOrdersByLocation();
	
	List<Order> getOrdersByPincode();

}
