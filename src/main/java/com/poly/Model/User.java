package com.poly.Model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;

	private String fullName;

	@Column(unique = true)
	private String email;

	private String passwordHash;

	private String address;

	private String phone;

	@Enumerated(EnumType.STRING)
	private Role role;

	private Date createdAt;

	private Date lastLogin;

	private String lastAction;

	private String lastIP;

	public enum Role {
		Customer, Staff, Admin
	}
}
