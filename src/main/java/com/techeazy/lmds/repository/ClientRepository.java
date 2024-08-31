package com.techeazy.lmds.repository;

import com.techeazy.lmds.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
