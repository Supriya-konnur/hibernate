package com.xworkz.laptop.dto;

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
@Table(name = "laptop")
@NamedQueries({
	@NamedQuery(name="getAllLoptop", query="select dto from LaptopDTO dto"),
	@NamedQuery(name="getLaptopByLaptopId", query="select dto from LaptopDTO dto where dto.laptopId=:pid"),
	@NamedQuery(name="getColorByLaptopName", query="select dto.laptopColor from LaptopDTO  dto where dto.laptopName=:pm"),
	@NamedQuery(name="getNameAndPriceByColor", query="select dto.laptopName, dto.laptopPrice from LaptopDTO dto where dto.laptopColor=:pc"),
	@NamedQuery(name="getAllNameAndPriceByColor", query="select dto.laptopName, dto.laptopPrice from LaptopDTO dto where dto.latopColor=:cm"),
	@NamedQuery(name="updatePriceByName", query="update LaptopDTO dto set dto.laptopPrice =:pc where dto.laptopName=:nm"),
	@NamedQuery(name="updateColorByName", query="update LaptopDTO dto set dto.laptopColor =:pc where dto.laptopName=:nm"),
	@NamedQuery(name="deleteByName", query="delete from LaptopDTO dto where dto.laptopName=:nm"),
	@NamedQuery(name="deleteByPrice" ,query="delete from LaptopDTO dto where dto.laptopPrice=:pc")
})

public class LaptopDTO implements Serializable {
	@Id
	@Column(name = "laptop_id")

	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int laptopId;

	@Column(name = "laptop_name")
	private String laptopName;

	@Column(name = "color")
	private String laptopColor;

	@Column(name = "price")
	private double laptopPrice;

	public LaptopDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getLaptopColor() {
		return laptopColor;
	}

	public void setLaptopColor(String laptopColor) {
		this.laptopColor = laptopColor;
	}

	public double getLaptopPrice() {
		return laptopPrice;
	}

	public void setLaptopPrice(double laptopPrice) {
		this.laptopPrice = laptopPrice;
	}

	@Override
	public String toString() {
		return "LaptopDTO [laptopId=" + laptopId + ", laptopName=" + laptopName + ", laptopColor=" + laptopColor
				+ ", laptopPrice=" + laptopPrice + "]";
	}

	
	
	

}
