package com.techeazy.lmds.repositoryRead;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.entity.Order;

@Repository
public interface OderDetailRepoRead extends CrudRepository<Order, Long> {
	@Query(value= "select b from Order b where b.isActive=?1 and b.isDeleted=?2")
	List<Order> getAllOrder(char isActive, char isDeleted);
	
	@Query(value= "select b from Order b where b.clientId=?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Order> getClientOrder(long clientId);

}
