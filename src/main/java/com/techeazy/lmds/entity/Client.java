package com.techeazy.lmds.entity;

import java.sql.Date;

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
@Table(name = "CLIENT")
public class Client {
	@Id
	@Column(name="CLIENTID",unique = true, nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="MOBILE", nullable=false)
	private long mobile;

	@Column(name="EMAIL", nullable=false)
	private String email;

	@Column(name="PASSWORD", nullable=false)
	private String password;

	@Column(name="ROLE", nullable=false)
	private String role;
	
	@Column(name="ISACTIVE", nullable=false)
	private char isActive;
	
	@Column(name="ISDELETED", nullable=false)
	private char isDeleted;
	
	@Column(name="ISORDERCREATED", nullable=false)
	private char isOrderCreated;
	
	@Column(name="CREATEDATE", nullable=false)
	private Date createDate;
	
	@Column(name="EXFIELED")
	private String exfield;
	
//	@OneToOne
//	private Order order;

}
