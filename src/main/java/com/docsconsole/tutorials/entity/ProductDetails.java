package com.docsconsole.tutorials.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_DETAILS")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PROD_DET_ID")
	private long prodDetId;
	@Column(name = "PROD_NAME")
	private String prodName;
	@Column(name = "PROD_DESC")
	private String prodDesc;
	@Column(name = "PROD_PRICE")
	private float prodPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Product product;

	public ProductDetails() {
	}
}