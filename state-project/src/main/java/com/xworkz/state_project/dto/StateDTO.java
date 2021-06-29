package com.xworkz.state_project.dto;

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
@Table(name="state")
@NamedQueries({
	@NamedQuery(name="getAllState", query="select dto from StateDTO dto"),
	@NamedQuery(name="updateNoOfDistrictByName", query="update StateDTO dto set dto.noOfDistrict =:dc where dto.stateName=:nm"),
	@NamedQuery(name="deleteByName", query="delete from StateDTO dto where dto.stateName=:nm"),
	
})
public class StateDTO implements Serializable{

	@Id
	@Column(name="state_id")
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	
	private int stateId;
	
	@Column(name="state_name")
	private String stateName;
	
	@Column(name="language")
	private String language;
	
	@Column(name="capital_name")
	private String capitalName;
	
	@Column(name="no_of_district")
	private int noOfDistrict;
	
	
	public StateDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getStateId() {
		return stateId;
	}


	public void setStateId(int stateId) {
		this.stateId = stateId;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getCapitalName() {
		return capitalName;
	}


	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}


	public int getNoOfDistrict() {
		return noOfDistrict;
	}


	public void setNoOfDistrict(int noOfDistrict) {
		this.noOfDistrict = noOfDistrict;
	}


	@Override
	public String toString() {
		return "StateDTO [stateId=" + stateId + ", stateName=" + stateName + ", language=" + language + ", capitalName="
				+ capitalName + ", noOfDistrict=" + noOfDistrict + "]";
	}


	

	
	


		
}
