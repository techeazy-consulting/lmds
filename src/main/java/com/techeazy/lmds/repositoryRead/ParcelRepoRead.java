package com.techeazy.lmds.repositoryRead;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.techeazy.lmds.entity.Parcel;

public interface ParcelRepoRead extends CrudRepository<Parcel, Long>{
	
	@Query(value= "select b from Parcel b where b.clientId=?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Parcel> getClientParcel(long clientId);

}
