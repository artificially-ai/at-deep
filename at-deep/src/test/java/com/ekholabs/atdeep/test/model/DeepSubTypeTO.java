package com.ekholabs.atdeep.test.model;

import com.ekholabs.atdeep.annotation.DeepProperty;


/**
 * @author Wilder Rodrigues (wilder.rodrigues@myekho.com)
 * @version 1.0
 * @since 1.0
 */
public class DeepSubTypeTO {
	
	@DeepProperty
	private String mySubType;

	public String getMySubType() {
		return mySubType;
	}

	public void setMySubType(String mySubType) {
		this.mySubType = mySubType;
	}
}