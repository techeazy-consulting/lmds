package com.techeazy.lmds.repositoryWrite;

import org.springframework.data.repository.CrudRepository;

import com.techeazy.lmds.entity.Driver;

public interface DriverWriteRepo extends CrudRepository<Driver, Long> {
	
	

}
