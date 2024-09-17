package com.techeazy.lmds.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.model.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {
	Parcel findByTrackingId(String trackingId);

	Parcel findByStatus(String status);

	Parcel findByTrackingIdAndStatus(String trackingId, String status);
}
