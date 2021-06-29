package com.xworkz.fan.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

@Entity
@Table(name = "fan")

@NamedQueries({
	@NamedQuery(name="getAllFan", query="select dto from FanDTO dto"),
	@NamedQuery(name="getFanByFanId", query="select dto from FanDTO dto where dto.fanId=:pid"),
	@NamedQuery(name="getColorByFanName", query="select dto.fanColor from FanDTO  dto where dto.fanName=:pm"),
	@NamedQuery(name="getNameAndPriceByColor", query="select dto.fanName, dto.fanPrice from FanDTO dto where dto.fanColor=:pc"),
	@NamedQuery(name="getAllNameAndPriceByColor", query="select dto.fanName, dto.fanPrice from FanDTO dto where dto.fanColor=:cm"),
	@NamedQuery(name="updatePriceByName", query="update FanDTO dto set dto.fanPrice=:pc where dto.fanName=:nm"),
	@NamedQuery(name="updateColorByName", query="update FanDTO dto set dto.fanColor=:pc where dto.fanName=:nm"),
	@NamedQuery(name="deleteByName", query="delete from FanDTO dto where dto.fanName=:nm"),
	@NamedQuery(name="deleteByPrice", query="delete from FanDTO dto where dto.fanPrice=:pc")
	
})
public class FanDTO implements Serializable{
	@Id
	@Column(name="fan_id")
	
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int fanId;
	
	@Column(name="fan_id")
	private String fanName;
	
	@Column(name="color")
	private String fanColor;
	
	@Column(name="price")
	private double fanPrice;
	
	
	
}
