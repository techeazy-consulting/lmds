package com.techeazy.lmds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@Column(name="CLIENTID",unique = true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="MOBILE",unique = true, nullable=false)
	private long mobile;
	
	@Column(name="EMAIL",unique = true, nullable=false)
	private String email;
	
	@Column(name="ADDRESS", nullable=false)
	private String address;
	
	@Column(name="PINCODE", nullable=false)
	private long pincode;
	
	@Column(name="ISACTIVE", nullable=false)
	private char isActive;
	
	@Column(name="ISDELETED", nullable=false)
	private char isDeleted;
	
	@Column(name="PARCELID",unique = true, nullable=false)
	private long parcelId;
	
	@Column(name="EXFILEd")
	private String exfield;
	
//	@OneToOne
//	private Parcel parcel;

}
