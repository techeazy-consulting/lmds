package com.techeazy.lmds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Client;
import com.techeazy.lmds.entity.Order;
import com.techeazy.lmds.entity.Parcel;
import com.techeazy.lmds.repositoryRead.ClientRepositoryRead;
import com.techeazy.lmds.repositoryRead.OderDetailRepoRead;
import com.techeazy.lmds.repositoryRead.ParcelRepoRead;
import com.techeazy.lmds.repositoryWrite.OrderDetailWriteRepo;
import com.techeazy.lmds.repositoryWrite.ParcelRepoWrite;
import com.techeazy.lmds.requests.OrderDetailRequest;
import com.techeazy.lmds.requests.OrderFetchRequest;
import com.techeazy.lmds.requests.ParcelRequest;
import com.techeazy.lmds.response.OrderDetailResponse;
import com.techeazy.lmds.utility.LMDSUtility;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OderDetailRepoRead oderDetailRepoRead;

	@Autowired
	OrderDetailWriteRepo orderDetailWriteRepo;

	@Autowired
	ParcelRepoRead parcelRepoRead;

	@Autowired
	ParcelRepoWrite parcelRepoWrite;

	@Autowired
	ClientRepositoryRead ClientRepositoryRead;

	@Override
	public OrderDetailResponse createOrder(OrderDetailRequest orderRequest) {
		OrderDetailResponse response = new OrderDetailResponse();
		if (orderRequest.getMobileNumber() == 0 && orderRequest.getEmail() != null) {
			Client client = ClientRepositoryRead.getClientdetailByMobileEmail(orderRequest.getMobileNumber(),
					orderRequest.getEmail());
			// also check order already created
			if (client != null && client.getRole().equalsIgnoreCase(orderRequest.getRole())) {
				Order createOrder = new Order();
				createOrder.setClientId(client.getId());
				createOrder.setIsActive('Y');
				createOrder.setIsDeleted('N');
//				createOrder.setLocation(orderRequest.getAddress());
//				createOrder.setPincode(orderRequest.getPincode());
				for (ParcelRequest eachParcel : orderRequest.getParcels()) {
					Parcel parcel = new Parcel();
					parcel.setClientId(client.getId());
					parcel.setCreateDate(LMDSUtility.getDate());
					parcel.setIsActive('Y');
					parcel.setIsDeleted('N');
					parcel.setParcelName(eachParcel.getName());
					parcelRepoWrite.save(parcel);
				}
				orderDetailWriteRepo.save(createOrder);
				response.setStatus(0);
				response.setMessage("Your Order Created");
				return response;
			}
			response.setStatus(-1);
			response.setMessage("You are not Authorized to create Order");
		}
		return response;

	}

	@Override
	public OrderDetailResponse getOrderOfClient(OrderFetchRequest orderFetchRequest) {
		OrderDetailResponse response = new OrderDetailResponse();
		Client client=ClientRepositoryRead.getClientdetailByMobileEmail(orderFetchRequest.getMobileNumber(), orderFetchRequest.getEmail());
		if(client.getId()!=0) {
			Order orders= oderDetailRepoRead.getClientOrder(client.getId());
			List<Parcel> parcels= parcelRepoRead.getClientParcel(client.getId());
			response.setClientName(client.getName());
			response.setMessage("Your List of Parcels");
			response.setOrders(orders);
			response.setParcels(parcels);
			response.setStatus(0);
			return response;
		}
		response.setStatus(-1);
		response.setMessage("You Don't have orders");
		return response;

	}

}
