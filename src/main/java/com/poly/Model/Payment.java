package com.poly.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentID;

	@OneToOne
	@JoinColumn(name = "orderID")
	private Order order;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	private Date paymentDate;

	private String paymentStatus;

	private String transactionID;

	public enum PaymentMethod {
		Cash, CreditCard, BankTransfer, VNPay, MoMo
	}
}
