package com.techeazy.lmds.repositoryWrite;

import org.springframework.data.repository.CrudRepository;

import com.techeazy.lmds.entity.Parcel;

public interface ParcelRepoWrite extends CrudRepository<Parcel, Long> {

}
