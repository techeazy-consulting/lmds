package com.techeazy.lmds.repositoryRead;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.entity.Client;

@Repository
public interface ClientRepositoryRead extends CrudRepository<Client,Long>{
	
	Optional<Client> findByEmail(String emailAdress);
	
	@Query(value= "select b from Client b where b.mobile=?1 and b.email=?2 and b.isActive='Y' and b.isDeleted='N'")
	Client getClientdetailByMobileEmail(long mobile, String email);

}
