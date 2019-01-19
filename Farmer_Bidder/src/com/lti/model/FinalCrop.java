package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;
@Component
@Entity
public class FinalCrop implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( unique=true)
	private int finalCropId;
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
	private long baseAmount;
	@Column
	private String phCertificate;
	@Column 
	private int farmerId;
	@Column
	@ColumnDefault("0")
	private long newBid;
	@Column
	@ColumnDefault("0")
	private long bidAmount;
	@Column
	@ColumnDefault("0")
	private int bidderid;

	

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
	public long getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(long baseAmount) {
		this.baseAmount = baseAmount;
	}
	public String getPhCertificate() {
		return phCertificate;
	}
	public void setPhCertificate(String phCertificate) {
		this.phCertificate = phCertificate;
	}
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	
	public FinalCrop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getNewBid() {
		return newBid;
	}
	public void setNewBid(long newBid) {
		this.newBid = newBid;
	}
	public long getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(long bidAmount) {
		this.bidAmount = bidAmount;
	}
	public int getBidderid() {
		return bidderid;
	}
	public void setBidderid(int bidderid) {
		this.bidderid = bidderid;
	}
	@Override
	public String toString() {
		return "FinalCrop [finalCropId=" + finalCropId + ", cropId=" + cropId + ", cropType=" + cropType + ", cropName="
				+ cropName + ", fertilizerType=" + fertilizerType + ", quantity=" + quantity + ", baseAmount="
				+ baseAmount + ", phCertificate=" + phCertificate + ", farmerId=" + farmerId + ", newBid=" + newBid
				+ ", bidAmount=" + bidAmount + ", bidderid=" + bidderid + "]";
	}
	public FinalCrop(int cropId, String cropType, String cropName, String fertilizerType, int quantity, long baseAmount,
			String phCertificate, int farmerId, long newBid, long bidAmount, int bidderid) {
		super();
		this.cropId = cropId;
		this.cropType = cropType;
		this.cropName = cropName;
		this.fertilizerType = fertilizerType;
		this.quantity = quantity;
		this.baseAmount = baseAmount;
		this.phCertificate = phCertificate;
		this.farmerId = farmerId;
		this.newBid = newBid;
		this.bidAmount = bidAmount;
		this.bidderid = bidderid;
	}

	
	

}
