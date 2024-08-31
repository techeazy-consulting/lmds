package com.techeazy.lmds.db.repositories;

import com.techeazy.lmds.db.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}