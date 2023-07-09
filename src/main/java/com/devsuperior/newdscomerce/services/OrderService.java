package com.devsuperior.newdscomerce.services;

import com.devsuperior.newdscomerce.dto.OrderDto;
import com.devsuperior.newdscomerce.entities.Order;
import com.devsuperior.newdscomerce.repositories.OrderRepository;
import com.devsuperior.newdscomerce.services.exceptions.ResourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repositoty;
    @Transactional(readOnly = true)
    public OrderDto findById(Long id){
        Order order = repositoty.findById(id).orElseThrow(() -> new ResourseNotFoundException("Recurso não encontrado"));
        return new OrderDto(order);

    }

}
