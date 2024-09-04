package com.techeazy.lmds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Order;
import com.techeazy.lmds.repositoryRead.OderDetailRepoRead;
import com.techeazy.lmds.response.OrderManagementBean;

@Service
public class OrderManagementServiceImpl implements OrderManagementService{

	
	@Autowired
	OderDetailRepoRead orderDetailRepoRead;
	
	
	@Override
	public OrderManagementBean processOrders(Order order) {
		OrderManagementBean orderManagementBean= new OrderManagementBean();
		List<Order> getOrder= orderDetailRepoRead.getAllOrder('Y', 'Y');
		return orderManagementBean;
	}

}
