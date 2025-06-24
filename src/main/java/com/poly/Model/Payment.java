package com.poly.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Payments")
@Data
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaymentID")
	private Integer paymentID;

	@OneToOne
	@JoinColumn(name = "OrderID", nullable = false)
	private Order order;

	@Column(name = "PaymentMethod", nullable = false)
	private String paymentMethod;

	@Column(name = "PaymentDate")
	private LocalDateTime paymentDate;

	@Column(name = "PaymentStatus", nullable = false)
	private String paymentStatus;

	@Column(name = "TransactionID")
	private String transactionID;

	@Column(name = "PaymentNote", length = 500)
	private String paymentNote;
}
