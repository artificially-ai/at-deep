package com.ekholabs.atdeep.test.model;

import java.util.Date;

import com.ekholabs.atdeep.annotation.DeepProperty;

/**
 * @author Wilder Rodrigues (wilder.rodrigues@myekho.com)
 * @version 1.0
 * @since 1.0
 */
public class DeepTO {
	
	@DeepProperty(propertyName = "TEXT_TEST")
	private String text;
	
	@DeepProperty
	private Long numberLong;
	
	@DeepProperty
	private Integer numberInt;
	
	@DeepProperty
	private Boolean b;
	
	@DeepProperty(isComplexType = true, reverseType = DeepTypeEntity.class)
	private DeepTypeTO myType;
	
	@DeepProperty
	private Date date;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getNumberLong() {
		return numberLong;
	}

	public void setNumberLong(Long numberLong) {
		this.numberLong = numberLong;
	}

	public Integer getNumberInt() {
		return numberInt;
	}

	public void setNumberInt(Integer numberInt) {
		this.numberInt = numberInt;
	}

	public Boolean getB() {
		return b;
	}

	public void setB(Boolean b) {
		this.b = b;
	}

	public DeepTypeTO getMyType() {
		return myType;
	}

	public void setMyType(DeepTypeTO myType) {
		this.myType = myType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}