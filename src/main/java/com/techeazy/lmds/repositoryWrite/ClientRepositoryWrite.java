package com.techeazy.lmds.repositoryWrite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.entity.Client;

@Repository
public interface ClientRepositoryWrite extends CrudRepository<Client,Long>{


}
