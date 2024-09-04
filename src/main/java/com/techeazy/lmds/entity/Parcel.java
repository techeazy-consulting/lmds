package com.techeazy.lmds.entity;



import java.util.Date;

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
@Table(name = "PARCEL")
public class Parcel {
	
	@Id
	@Column(name="PARCELID", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="PARCELNAME", nullable=false)
	private String parcelName;
	
	@Column(name="CLIENTID", nullable=false)
	private long clientId;
	
//	@Column(name="CUSTOMERID", nullable=false)
//	private long customerId;
	
//	@Column(name="LOCATION", nullable=false)
//	private String location;
//	
//	@Column(name="PINCODE", nullable=false)
//	private long pincode;
//	
//	@OneToOne
//	private Customer customer;
	
//	@OneToMany
//	private List<Item> item;
	
	@Column(name="ISACTIVE", nullable=false)
	private char isActive;
	
	@Column(name="ISDELETED", nullable=false)
	private char isDeleted;
	
	@Column(name="CREATEDATE", nullable=false)
	private Date createDate;

}
