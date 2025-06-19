// OrderService.java
package com.poly.Service;

import java.util.List;
import java.util.Optional;

import com.poly.Model.Order;

public interface OrderService {
	List<Order> findAll();

	Optional<Order> findById(Integer id);

	Order save(Order order);

	void deleteById(Integer id);
}
