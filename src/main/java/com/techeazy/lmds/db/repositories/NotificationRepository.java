package com.techeazy.lmds.db.repositories;

import com.techeazy.lmds.db.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}