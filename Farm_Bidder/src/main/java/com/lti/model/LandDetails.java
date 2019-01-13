package com.lti.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;
@Component
@Entity
public class LandDetails implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="land_sequence")
	@SequenceGenerator(name="land_sequence",sequenceName="land_sequence")
	@Column
	private int landId;
	@Column 
	private String landAddress;
	@Column
	private int area;
	@Column
private int landPincode;
	
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getPincode() {
		return landPincode;
	}
	public void setPincode(int landPincode) {
		this.landPincode = landPincode;
	}
	public int getLandId() {
		return landId;
	}
	public void setLandId(int landId) {
		this.landId = landId;
	}
	public String getLandAddress() {
		return landAddress;
	}
	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}
	
	
	public LandDetails(String landAddress, int area,int landPincode) {
		super();
		this.landAddress = landAddress;
		this.area = area;
		this.landPincode=landPincode;
	}
	public LandDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
