package com.techeazy.lmds.repositoryWrite;

import org.springframework.data.repository.CrudRepository;

import com.techeazy.lmds.entity.Customer;

public interface CustomerWriteRepo extends CrudRepository<Customer, Long> {
	
	

}
