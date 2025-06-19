// CartServiceImpl.java
package com.poly.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Model.Cart;
import com.poly.Repository.CartRepository;
import com.poly.Service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository repo;

	public List<Cart> findAll() {
		return repo.findAll();
	}

	public Optional<Cart> findById(Integer id) {
		return repo.findById(id);
	}

	public Cart save(Cart cart) {
		return repo.save(cart);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
