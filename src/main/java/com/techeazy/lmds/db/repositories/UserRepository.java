package com.techeazy.lmds.db.repositories;

import com.techeazy.lmds.db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}