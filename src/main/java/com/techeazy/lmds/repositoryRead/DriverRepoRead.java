package com.techeazy.lmds.repositoryRead;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.techeazy.lmds.entity.Driver;

public interface DriverRepoRead extends CrudRepository<Driver, Long>{
	
	@Query(value= "select b from Driver b where b.mobile=?1 and b.email=?2 and b.isDeleted='N' and b.isActive='Y'")
	Driver getDriverDetail(long mobile, String email);

}
