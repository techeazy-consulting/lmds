package com.techeazy.lmds.repositoryRead;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.entity.Parcel;

@Repository
public interface ParcelRepoRead extends CrudRepository<Parcel, Long>{
	
	@Query(value= "select b from Parcel b where b.clientId=?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Parcel> getClientParcel(long clientId);
	
	@Query(value= "select b from Parcel b where b.customerId=?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Parcel> getCustomerParcel(long customerId);
	
	@Query(value= "select b from Parcel b where b.customerId=?1 and b.ParcelId=?2 and b.isDeleted='N' and b.isActive='Y'")
	Parcel getCustomerParcelwithParcelId(long customerId,long parcelId);
	
	@Query(value= "select b from Parcel b where b.pincode IN ?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Parcel> getParcelForDriver(List<Long> pincode);
	
	@Query(value= "select b from Parcel b where b.location=?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Parcel> getAllParcelByLocation(String address);
	
	@Query(value= "select b from Parcel b where b.pincode=?1 and b.isDeleted='N' and b.isActive='Y'")
	List<Parcel> getAllParcelByPincode(long pincode);
	
	

}
