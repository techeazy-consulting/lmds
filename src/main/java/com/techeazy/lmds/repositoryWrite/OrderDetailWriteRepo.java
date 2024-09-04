package com.techeazy.lmds.repositoryWrite;

import org.springframework.data.repository.CrudRepository;

import com.techeazy.lmds.entity.Order;

public interface OrderDetailWriteRepo extends CrudRepository<Order, Long> {

}
