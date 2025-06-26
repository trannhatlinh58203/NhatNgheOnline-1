// CartServiceImpl.java
package com.poly.Service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Model.Cart;
import com.poly.Model.Product;
import com.poly.Model.User;
import com.poly.Repository.CartRepository;
import com.poly.Repository.ProductRepository;
import com.poly.Service.CartService;

import jakarta.transaction.Transactional;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	public Optional<Cart> findById(Integer id) {
		return cartRepository.findById(id);
	}

	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}

	public void deleteById(Integer id) {
		cartRepository.deleteById(id);
	}

	// cart
	@Override
	public List<Cart> getCartItems(User user) {
		return cartRepository.findByUser(user);
	}

	@Override
	public double getTotalPrice(User user) {
		List<Cart> cartItems = getCartItems(user);
		return cartItems.stream()
				.map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
	}

	@Override
	public void addToCart(User user, Integer productId, Integer quantity) {
		Product product = productRepository.findById(productId).orElseThrow();

		// Tìm cart item đã có chưa
		Cart existing = cartRepository.findByUserAndProduct(user, product);

		if (existing != null) {
			existing.setQuantity(existing.getQuantity() + quantity);
			existing.setAddedAt(LocalDateTime.now());
			cartRepository.save(existing);
		} else {
			Cart newItem = new Cart();
			newItem.setUser(user);
			newItem.setProduct(product);
			newItem.setQuantity(quantity);
			newItem.setAddedAt(LocalDateTime.now());
			cartRepository.save(newItem);
		}
	}

	@Override
	public void updateQuantity(User user, Integer productId, Integer quantity) {
		Cart item = cartRepository.findByUserAndProduct_ProductID(user, productId);
		if (item != null && quantity > 0) {
			item.setQuantity(quantity);
			cartRepository.save(item);
		}
	}

	@Override
	@Transactional
	public void removeFromCart(User user, Integer productId) {
		cartRepository.deleteByUserAndProduct_ProductID(user, productId);
	}

}
