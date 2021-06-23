package com.xworkz.state_project.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="state")
public class StateDTO implements Serializable{

	@Id
	@Column(name="state_id")
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	
	private int state_id;
	
	@Column(name="state_name")
	private String state_name;
	
	@Column(name="language")
	private String language;
	
	@Column(name="capital_name")
	private String capital_name;
	
	@Column(name="no_of_district")
	private int no_of_district;
	
	
	public StateDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getState_id() {
		return state_id;
	}


	public void setState_id(int state_id) {
		this.state_id = state_id;
	}


	public String getState_name() {
		return state_name;
	}


	public void setState_name(String state_name) {
		this.state_name = state_name;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getCapital_name() {
		return capital_name;
	}


	public void setCapital_name(String capital_name) {
		this.capital_name = capital_name;
	}


	public int getNo_of_district() {
		return no_of_district;
	}


	public void setNo_of_district(int no_of_district) {
		this.no_of_district = no_of_district;
	}


	@Override
	public String toString() {
		return "StateDTO [state_id=" + state_id + ", state_name=" + state_name + ", language=" + language
				+ ", capital_name=" + capital_name + ", no_of_district=" + no_of_district + "]";
	}
	
	
}
