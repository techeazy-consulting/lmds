package com.techeazy.lmds.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.model.Parcel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {

    Optional<Parcel> findByTrackingId(String trackingId);

    @Query("SELECT p FROM Parcel p WHERE p.orderDetail.client.id = :clientId AND p.status = :status")
    List<Parcel> findByClientIdAndStatus(@Param("clientId") Long clientId, @Param("status") String status);
}
