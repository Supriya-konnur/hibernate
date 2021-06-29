package com.xworkz.it_company.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "it_company")
public class ItCompanyDTO {
	@Id
	@Column(name = "it_company_id")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int itCompanyId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="rating")
	private int rating;

	public int getItCompanyId() {
		return itCompanyId;
	}

	public void setItCompanyId(int itCompanyId) {
		this.itCompanyId = itCompanyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ItCompanyDTO [itCompanyId=" + itCompanyId + ", companyName=" + companyName + ", location=" + location
				+ ", rating=" + rating + "]";
	}
	
	
}
