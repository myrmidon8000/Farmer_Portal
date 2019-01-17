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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( unique=true)
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
	public int getLandPincode() {
		return landPincode;
	}
	public void setLandPincode(int landPincode) {
		this.landPincode = landPincode;
	}
	@Override
	public String toString() {
		return "LandDetails [landId=" + landId + ", landAddress=" + landAddress + ", area=" + area + ", landPincode="
				+ landPincode + "]";
	}
	
	
}
