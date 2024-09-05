package com.techeazy.lmds.repositoryRead;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.entity.Order;

@Repository
public interface OderDetailRepoRead extends CrudRepository<Order, Long> {
	@Query(value= "select b from Order b where b.isActive='Y' and b.isDeleted='N'")
	List<Order> getAllClientsOrder();
	
	@Query(value= "select b from Order b where b.clientId=?1 and b.isDeleted='N' and b.isActive='Y'")
	Order getClientOrder(long clientId);
	
	@Query(value= "select b from Order b where b.location=?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Order> getAllOrdersByLocation(String address);
	
	@Query(value= "select b from Order b where b.pincode=?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Order> getAllOrdersByPincode(long pincode);
	
	@Query(value= "select b from Order b where b.createDate >=?1 and b.isActive='Y' and b.isDeleted='N'")
	List<Order> getClientOrderByCreateDate(Date startDate, Date endDate);

}
