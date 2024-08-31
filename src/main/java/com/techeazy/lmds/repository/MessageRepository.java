package com.techeazy.lmds.repository;

import com.techeazy.lmds.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
