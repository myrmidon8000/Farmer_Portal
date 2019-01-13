package com.lti.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;

import org.hibernate.validator.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
public class BankDetails implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bank_sequence")
	@SequenceGenerator(name="bank_sequence",sequenceName="bank_sequence")
	@Column
	private int bankId;
	@Column
	@NotEmpty(message = "IFSC Code cannot be empty!")
	private String ifscCode;
	@Column
	@NotEmpty(message = "AccountNumber cannot be empty!")
	private int accountNumber;
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "BankDetails [bankId=" + bankId + ", ifscCode=" + ifscCode + ", accountNumber=" + accountNumber + "]";
	}
	public BankDetails(String ifscCode, int accountNumber) {
		super();
	
		this.ifscCode = ifscCode;
		this.accountNumber = accountNumber;
	}
	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
