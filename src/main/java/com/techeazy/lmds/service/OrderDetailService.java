package com.techeazy.lmds.service;

import com.techeazy.lmds.model.OrderDetail;
import com.techeazy.lmds.repo.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrderDetails(){
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetail> getOrderById(Long id){
        return orderDetailRepository.findById(id);
    }

    public OrderDetail createOrderDetail(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);
    }

    public void deleteOrderDetail(Long id){
        orderDetailRepository.deleteById(id);
    }
}
