// PaymentServiceImpl.java
package com.poly.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Model.Payment;
import com.poly.Repository.PaymentRepository;
import com.poly.Service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository repo;

	public List<Payment> findAll() {
		return repo.findAll();
	}

	public Optional<Payment> findById(Integer id) {
		return repo.findById(id);
	}

	public Payment save(Payment payment) {
		return repo.save(payment);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
