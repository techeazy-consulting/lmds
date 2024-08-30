package com.techeazy.lmds.db.repositories;

import com.techeazy.lmds.db.entities.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}