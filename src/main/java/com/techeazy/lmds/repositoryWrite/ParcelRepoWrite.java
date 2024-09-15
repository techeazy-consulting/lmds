package com.techeazy.lmds.repositoryWrite;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.techeazy.lmds.entity.Parcel;

import jakarta.transaction.Transactional;

public interface ParcelRepoWrite extends CrudRepository<Parcel, Long> {
	
	@Transactional
	@Modifying
	@Query("update Parcel c SET c.statusCode =?1, c.parcelStatus=?2 WHERE c.id =?3")
	int updateStatus( int statusCode, String parcelStatus, long parcelId);
	
	

}
