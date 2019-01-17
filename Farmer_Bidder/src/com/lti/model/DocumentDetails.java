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
public class DocumentDetails implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( unique=true)
	private int documentId;
	@Column 
	@NotEmpty
	private String aadharNumber;
	@Column 
	@NotEmpty
	private String panNumber;
	@Column 
	private String certificateNumber;
	@Column 
	private String traderLicenseNumber;
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getTraderLicenseNumber() {
		return traderLicenseNumber;
	}
	public void setTraderLicenseNumber(String traderLicenseNumber) {
		this.traderLicenseNumber = traderLicenseNumber;
	}
	@Override
	public String toString() {
		return "DocumentDetails [documentId=" + documentId + ", aadharNumber=" + aadharNumber + ", panNumber="
				+ panNumber + ", certificateNumber=" + certificateNumber + ", traderLicenseNumber="
				+ traderLicenseNumber + "]";
	}
	public DocumentDetails(String aadharNumber, String panNumber, String certificateNumber,
			String traderLicenseNumber) {
		super();
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.certificateNumber = certificateNumber;
		this.traderLicenseNumber = traderLicenseNumber;
	}
	public DocumentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
