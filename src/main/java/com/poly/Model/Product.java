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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productID;

	private String productName;

	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String description;

	private double price;

	private String imageURL;

	private int stockQuantity;

	@ManyToOne
	@JoinColumn(name = "categoryID")
	private Category category;

	private Date createdAt;
}
