package com.poly.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Orders")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private Integer orderID;

	@ManyToOne
	@JoinColumn(name = "UserID", nullable = false)
	private User user;

	@Column(name = "OrderDate")
	private LocalDateTime orderDate;

	@Column(name = "Status", nullable = false)
	private String status;

	@Column(name = "TrackingCode")
	private String trackingCode;

	@Column(name = "ShippingAddress")
	private String shippingAddress;
}
