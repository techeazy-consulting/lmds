package com.techeazy.lmds.repository;

import com.techeazy.lmds.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
