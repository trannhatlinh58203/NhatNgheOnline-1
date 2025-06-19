// ProductRepository.java
package com.poly.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	// Optional: tìm theo danh mục
	List<Product> findByCategory_CategoryID(Integer categoryId);
}
