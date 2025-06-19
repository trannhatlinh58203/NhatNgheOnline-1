// UserServiceImpl.java
package com.poly.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Model.User;
import com.poly.Repository.UserRepository;
import com.poly.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public Optional<User> findById(Integer id) {
		return repo.findById(id);
	}

	public User save(User user) {
		return repo.save(user);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
