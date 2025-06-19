// CartRepository.java
package com.poly.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findByUser_UserID(Integer userId);
}
