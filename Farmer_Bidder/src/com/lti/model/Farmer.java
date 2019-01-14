package com.lti.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Size;
import org.springframework.stereotype.Component;

@Component	
@Entity
public class Farmer implements Serializable  {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="farmer_sequence")
@SequenceGenerator(name="farmer_sequence",sequenceName="farmer_sequence")
@Column
private int farmerId;
@Column
@NotEmpty(message = "Name cannot be empty!")
private String farmerName;

@Column
@NotEmpty(message = "Phone Number cannot be empty!")
@Size(max=10, min=10, message="Phone Number Should be 10 number long" )
private String phoneNumber;

@OneToOne(cascade=CascadeType.ALL)
private Login login;


@OneToOne(cascade=CascadeType.ALL)
private BankDetails bankDetails;

@OneToOne(cascade=CascadeType.ALL)
private Address address;

@OneToOne(cascade=CascadeType.ALL)
private LandDetails landDetails;

@OneToOne(cascade=CascadeType.ALL)
private DocumentDetails documentDetails;

@OneToMany(cascade=CascadeType.ALL,mappedBy="farmer")
private Set<PotentialCrop> cropList;

public Login getLogin() {
	return login;
}
public void setLogin(Login login) {
	this.login = login;
}
public int getFarmerId() {
	return farmerId;
}
public void setFarmerId(int farmerId) {
	this.farmerId = farmerId;
}
public String getFarmerName() {
	return farmerName;
}
public void setFarmerName(String farmerName) {
	this.farmerName = farmerName;
}
public Farmer() {
	super();
	// TODO Auto-generated constructor stub
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public BankDetails getBankDetails() {
	return bankDetails;
}
public void setBankDetails(BankDetails bankDetails) {
	this.bankDetails = bankDetails;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public LandDetails getLandDetails() {
	return landDetails;
}
public void setLandDetails(LandDetails landDetails) {
	this.landDetails = landDetails;
}
public DocumentDetails getDocumentDetails() {
	return documentDetails;
}
public void setDocumentDetails(DocumentDetails documentDetails) {
	this.documentDetails = documentDetails;
}

@Override
public String toString() {
	return "Farmer [farmerId=" + farmerId + ", farmerName=" + farmerName + ", phoneNumber=" + phoneNumber + ", login="
			+ login + ", bankDetails=" + bankDetails + ", address=" + address + ", landDetails=" + landDetails
			+ ", documentDetails=" + documentDetails + ", cropList=" + cropList + "]";
}
public Farmer(String farmerName, String phoneNumber, Login login, BankDetails bankDetails, Address address,
		LandDetails landDetails, DocumentDetails documentDetails) {
	super();

	this.farmerName = farmerName;
	this.phoneNumber = phoneNumber;
	this.login = login;
	this.bankDetails = bankDetails;
	this.address = address;
	this.landDetails = landDetails;
	this.documentDetails = documentDetails;
}
public Set<PotentialCrop> getCropList() {
	return cropList;
}
public void setCropList(Set<PotentialCrop> cropList) {
	this.cropList = cropList;
}


}
