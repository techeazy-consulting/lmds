package com.techeazy.lmds.repositoryRead;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.entity.Client;

@Repository
public interface ClientRepositoryRead extends CrudRepository<Client,Long>{
	
	Optional<Client> findByEmail(String emailAdress);

}
