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
@Table(name = "ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERID", nullable=false)
	private long id;
	
//	@OneToOne
//	@JoinColumn(name="fk_client", referencedColumnName = "id")
//	private Client client;
	
//	@OneToMany
//	@JoinColumn(name="fk_parcel", referencedColumnName = "id")
//	private List<Parcel> item;
	
	@Column(name="CLIENTID", nullable=false)
	private long clientId;
	
	@Column(name="ISORDERCREATED", nullable=false)
	private char isOrderCreated;
	
	@Column(name="PARCELID", nullable=false)
	private long parcelId;
	
	@Column(name="LOCATION", nullable=false)
	private String location;
	
	@Column(name="PINCODE", nullable=false)
	private long pincode;
	
	@Column(name="ISACTIVE", nullable=false)
	private char isActive;
	
	@Column(name="ISDELETED", nullable=false)
	private char isDeleted;
	
	@Column(name="CREATEDATE", nullable=false)
	private Date createDate;
	
	
	

}
