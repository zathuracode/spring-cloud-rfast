package com.vobi.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "acco_id", unique = true, nullable = false)
	private String accoId;

	@Column(name = "balance", nullable = false)
	private Double balance;

	@Column(name = "enable", nullable = false)
	private String enable;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "version", nullable = true)
	private Long version;
	
	@Column(name = "cust_id", nullable = false)
	private Integer custId;
	
}