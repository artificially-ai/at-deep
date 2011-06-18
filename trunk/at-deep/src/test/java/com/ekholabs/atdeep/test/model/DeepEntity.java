package com.ekholabs.atdeep.test.model;

import java.util.Date;

/**
 * @author Wilder Rodrigues (wilder.rodrigues@myekho.com)
 * @version 1.0
 * @since 1.0
 */
public class DeepEntity {

	private String TEXT_TEST;
	private Long numberLong;
	private Integer numberInt;
	private Boolean b;
	private DeepTypeEntity myType;
	private Date date;

	public String getTEXT_TEST() {
		return TEXT_TEST;
	}

	public void setTEXT_TEST(String tEXTTEST) {
		TEXT_TEST = tEXTTEST;
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

	public DeepTypeEntity getMyType() {
		return myType;
	}

	public void setMyType(DeepTypeEntity myType) {
		this.myType = myType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}