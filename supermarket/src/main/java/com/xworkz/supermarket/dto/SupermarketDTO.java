package com.xworkz.supermarket.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="supermarket")
public class SupermarketDTO implements Serializable{

	@Id
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	
	@Column(name="id")
	private int id;
	
	@Column(name="supermarket_name")
	private String supermarket_name;
	
	@Column(name="item_name")
	private String item_name;
	
	@Column(name="no_of_items")
	private int no_of_items;
	
	@Column(name="price")
	private double price;
	
	public SupermarketDTO() {
		System.out.println(this.getClass().getSimpleName()+"Created");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupermarket_name() {
		return supermarket_name;
	}

	public void setSupermarket_name(String supermarket_name) {
		this.supermarket_name = supermarket_name;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getNo_of_items() {
		return no_of_items;
	}

	public void setNo_of_items(int no_of_items) {
		this.no_of_items = no_of_items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SupermarketDTO [id=" + id + ", supermarket_name=" + supermarket_name + ", item_name=" + item_name
				+ ", no_of_items=" + no_of_items + ", price=" + price + "]";
	}

	
	
	
}
