package com.techeazy.lmds.service;

import com.techeazy.lmds.entity.Order;
import com.techeazy.lmds.response.OrderManagementBean;

public interface OrderManagementService {
	
	OrderManagementBean processOrders(Order order);

}
