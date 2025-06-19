// UserService.java
package com.poly.Service;

import java.util.List;
import java.util.Optional;

import com.poly.Model.User;

public interface UserService {
	List<User> findAll();

	Optional<User> findById(Integer id);

	User save(User user);

	void deleteById(Integer id);
}
