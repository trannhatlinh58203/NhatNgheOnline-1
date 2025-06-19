package com.poly.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewID;

	@ManyToOne
	@JoinColumn(name = "productID")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;

	private int rating;

	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String comment;

	private Date createdAt;

	private boolean approved;
}
