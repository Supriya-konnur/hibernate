package com.xworkz.perfume.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="perfume")
@NamedQueries({
	@NamedQuery(name="getAllPerfume",query="select dto from PerfumeDTO dto"),
	@NamedQuery(name="getPerfumeByPerfumeId",query="select dto from PerfumeDTO dto where dto.perfumeId=:pid"),
	@NamedQuery(name="getCompanyNameByPerfumeName",query="select dto.perfumeCompany from PerfumeDTO  dto where dto.perfumeName=:pm"),
	@NamedQuery(name="getNameAndPriceByCompany",query="select dto.perfumeName, dto.perfumePrice from PerfumeDTO dto where dto.perfumeCompany=:pc"),
	@NamedQuery(name="getAllNameAndPriceByCompany",query="select dto.perfumeName, dto.perfumePrice from PerfumeDTO dto where dto.perfumeCompany=:cm"),
	@NamedQuery(name="updatePriceByName",query="update PerfumeDTO dto set dto.perfumePrice =:pc where dto.perfumeName=:nm"),
	@NamedQuery(name="updateCompanyByName",query="update PerfumeDTO dto set dto.perfumeCompany =:pc where dto.perfumeName=:nm"),
	@NamedQuery(name="deleteByName",query="delete from PerfumeDTO dto where dto.perfumeName=:nm"),
	@NamedQuery(name="deleteByPrice", query="delete from PerfumeDTO dto where dto.perfumePrice=:pc")
})


public class PerfumeDTO implements Serializable{

	@Id
	@Column(name="perfume_id")
	
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int perfumeId;
	
	@Column(name="perfume_name")
	private String perfumeName;
	

	@Column(name="perfume_price")
	private double perfumePrice;
	

	@Column(name="perfume_company")
	private String perfumeCompany;
	
	
	public PerfumeDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public int getPerfumeId() {
		return perfumeId;
	}



	public void setPerfumeId(int perfumeId) {
		this.perfumeId = perfumeId;
	}



	public String getPerfumeName() {
		return perfumeName;
	}



	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}



	public double getPerfumePrice() {
		return perfumePrice;
	}



	public void setPerfumePrice(double perfumePrice) {
		this.perfumePrice = perfumePrice;
	}



	public String getPerfumeCompany() {
		return perfumeCompany;
	}



	public void setPerfumeCompany(String perfumeCompany) {
		this.perfumeCompany = perfumeCompany;
	}



	@Override
	public String toString() {
		return "PerfumeDTO [perfumeId=" + perfumeId + ", perfumeName=" + perfumeName + ", perfumePrice=" + perfumePrice
				+ ", perfumeCompany=" + perfumeCompany + "]";
	}
	
}
 