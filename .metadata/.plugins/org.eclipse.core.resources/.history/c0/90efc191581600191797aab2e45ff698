package com.lti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BidderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bidderdetails_sequence")
	@SequenceGenerator(name="bidderdetails_sequence",sequenceName="bidderdetails_sequence")
	@Column
private int bidderDetailsId;
@Column
@NotEmpty(message = "Phone Number cannot be empty!")
@Size(max=10, min=10, message="Phone Number Should be 10 number long" )
private int phoneNumber;
@OneToOne(cascade=CascadeType.ALL)
private BankDetails bankDetails;
@OneToOne(cascade=CascadeType.ALL)
private Address address;
@OneToOne(cascade=CascadeType.ALL)
private DocumentDetails documentDetails;
public int getBidderDetailsId() {
	return bidderDetailsId;
}
public void setBidderDetailsId(int bidderDetailsId) {
	this.bidderDetailsId = bidderDetailsId;
}
public int getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(int phoneNumber) {
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
public DocumentDetails getDocumentDetails() {
	return documentDetails;
}
public void setDocumentDetails(DocumentDetails documentDetails) {
	this.documentDetails = documentDetails;
}
@Override
public String toString() {
	return "BidderDetails [bidderDetailsId=" + bidderDetailsId + ", phoneNumber=" + phoneNumber + ", bankDetails="
			+ bankDetails + ", address=" + address + ", documentDetails=" + documentDetails + "]";
}
public BidderDetails(int bidderDetailsId, int phoneNumber, BankDetails bankDetails, Address address,
		DocumentDetails documentDetails) {
	super();
	this.bidderDetailsId = bidderDetailsId;
	this.phoneNumber = phoneNumber;
	this.bankDetails = bankDetails;
	this.address = address;
	this.documentDetails = documentDetails;
}
public BidderDetails() {
	super();
	// TODO Auto-generated constructor stub
}

}
