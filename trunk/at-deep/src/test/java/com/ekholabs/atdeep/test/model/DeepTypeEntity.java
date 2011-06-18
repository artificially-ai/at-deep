package com.ekholabs.atdeep.test.model;

/**
 * @author Wilder Rodrigues (wilder.rodrigues@myekho.com)
 * @version 1.0
 * @since 1.0
 */
public class DeepTypeEntity {
	
	private String myType;
	
	private DeepSubTypeEntity subType;
	
	private EnumType enumType;

	public String getMyType() {
		return myType;
	}

	public void setMyType(String myType) {
		this.myType = myType;
	}

	public DeepSubTypeEntity getSubType() {
		return subType;
	}

	public void setSubType(DeepSubTypeEntity subType) {
		this.subType = subType;
	}

	public EnumType getEnumType() {
		return enumType;
	}

	public void setEnumType(EnumType enumType) {
		this.enumType = enumType;
	}
}