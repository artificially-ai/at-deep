package com.ekholabs.atdeep.test.model;

import com.ekholabs.atdeep.annotation.DeepProperty;


/**
 * @author Wilder Rodrigues (wilder.rodrigues@myekho.com)
 * @version 1.0
 * @since 1.0
 */
public class DeepTypeTO {
	
	@DeepProperty
	private String myType;
	
	@DeepProperty(isComplexType = true, reverseType = DeepSubTypeEntity.class)
	private DeepSubTypeTO subType;
	
	@DeepProperty
	private EnumType enumType;

	public String getMyType() {
		return myType;
	}

	public void setMyType(String myType) {
		this.myType = myType;
	}

	public DeepSubTypeTO getSubType() {
		return subType;
	}

	public void setSubType(DeepSubTypeTO subType) {
		this.subType = subType;
	}

	public EnumType getEnumType() {
		return enumType;
	}

	public void setEnumType(EnumType enumType) {
		this.enumType = enumType;
	}
}