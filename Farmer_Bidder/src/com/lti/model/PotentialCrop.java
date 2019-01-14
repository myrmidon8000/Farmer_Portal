package com.lti.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;
@Component
@Entity
public class PotentialCrop implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="crop_sequence")
	@SequenceGenerator(name="crop_sequence",sequenceName="crop_sequence")
	@Column
	private int cropId;
	@Column
	private String cropType;
	@Column
	private String cropName;
	@Column
	private String fertilizerType;
	@Column
	private int quantity;
	@Column
	private String phCertificate;
	@Column
	private String requestStatus;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="farmerId")
	private Farmer farmer;
	
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getFertilizerType() {
		return fertilizerType;
	}
	public void setFertilizerType(String fertilizerType) {
		this.fertilizerType = fertilizerType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPhCertificate() {
		return phCertificate;
	}
	public void setPhCertificate(String phCertificate) {
		this.phCertificate = phCertificate;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	@Override
	public String toString() {
		return "PotentialCrop [cropId=" + cropId + ", cropType=" + cropType + ", cropName=" + cropName
				+ ", fertilizerType=" + fertilizerType + ", quantity=" + quantity + ", phCertificate=" + phCertificate
				+ ", requestStatus=" + requestStatus + ", farmer=" + farmer + "]";
	}

	

	public PotentialCrop(int cropId, String cropType, String cropName, String fertilizerType, int quantity,
			String phCertificate, String requestStatus, Farmer farmer) {
		super();
		this.cropId = cropId;
		this.cropType = cropType;
		this.cropName = cropName;
		this.fertilizerType = fertilizerType;
		this.quantity = quantity;
		this.phCertificate = phCertificate;
		this.requestStatus = requestStatus;
		this.farmer = farmer;
	}
	public PotentialCrop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	
	
	

}
