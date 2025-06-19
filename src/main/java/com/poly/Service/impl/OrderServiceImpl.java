// OrderServiceImpl.java
package com.poly.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Model.Order;
import com.poly.Repository.OrderRepository;
import com.poly.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository repo;

	public List<Order> findAll() {
		return repo.findAll();
	}

	public Optional<Order> findById(Integer id) {
		return repo.findById(id);
	}

	public Order save(Order order) {
		return repo.save(order);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
