// CartService.java
package com.poly.Service;

import java.util.List;
import java.util.Optional;

import com.poly.Model.Cart;

public interface CartService {
	List<Cart> findAll();

	Optional<Cart> findById(Integer id);

	Cart save(Cart cart);

	void deleteById(Integer id);
}
