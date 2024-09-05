package com.techeazy.lmds.repositoryRead;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.entity.Customer;

@Repository
public interface CustomerRepoRead extends CrudRepository<Customer, Long> {
	
	@Query(value= "select b from Customer b where b.mobile=?1 and b.email=?2 and b.isActive='Y' and b.isDeleted='N'")
	Customer getCustomerByMobileAndEmail(long mobile, String email);

}
