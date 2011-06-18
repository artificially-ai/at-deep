package com.ekholabs.atdeep.test;

import java.util.Date;

import com.ekholabs.atdeep.exception.DeepException;
import com.ekholabs.atdeep.test.model.DeepEntity;
import com.ekholabs.atdeep.test.model.DeepSubTypeTO;
import com.ekholabs.atdeep.test.model.DeepTO;
import com.ekholabs.atdeep.test.model.DeepTypeTO;
import com.ekholabs.atdeep.test.model.EnumType;
import com.ekholabs.atdeep.util.DeepCopy;

import junit.framework.TestCase;

/**
 * @author Wilder Rodrigues (wilder.rodrigues@myekho.com)
 * @version 1.0
 * @since 1.0
 */
public class DeepCopyTest extends TestCase {
	
	public void testCopyWrapperProperties() {
		//From this class
		DeepTO deepTO = new DeepTO();
		
		deepTO.setB(true);
		deepTO.setNumberInt(10);
		deepTO.setNumberLong(15l);
		deepTO.setText("Wilder");
		deepTO.setDate(new Date());
		
		DeepTypeTO deepTypeTO = new DeepTypeTO();
		deepTypeTO.setMyType("A TYPE!");
		deepTypeTO.setEnumType(EnumType.TYPE_A);
		
		deepTO.setMyType(deepTypeTO);
		
		DeepSubTypeTO subTypeTO = new DeepSubTypeTO();
		subTypeTO.setMySubType("A SUB TYPE");
		deepTypeTO.setSubType(subTypeTO);
		
		//To this class
		DeepEntity deepEntity = new DeepEntity();
		
		try {
			DeepCopy deepCopy = DeepCopy.getInstance();
			deepCopy.copyProperties(deepTO, deepEntity);
		} catch (DeepException e) {
			fail(e.getMessage());
		}
		
		assertTrue(deepTO.getText().equals(deepEntity.getTEXT_TEST()));
		assertTrue(deepTO.getB().equals(deepEntity.getB()));
		assertTrue(deepTO.getNumberInt().equals(deepEntity.getNumberInt()));
		assertTrue(deepTO.getNumberLong().equals(deepEntity.getNumberLong()));
		assertTrue(deepTO.getDate().toString().equals(deepEntity.getDate().toString()));
		assertTrue(deepTO.getMyType().getMyType().equals(deepEntity.getMyType().getMyType()));
		assertTrue(deepTO.getMyType().getSubType().getMySubType().equals(deepEntity.getMyType().getSubType().getMySubType()));
	}
	
	public void testCopyWrapperPropertiesNullType() {
		//From this class
		DeepTO deepTO = new DeepTO();
		
		deepTO.setB(true);
		deepTO.setNumberInt(10);
		deepTO.setNumberLong(15l);
		deepTO.setText("Wilder");
		deepTO.setDate(new Date());
		
		//Don't set complex type
		
		//To this class
		DeepEntity deepEntity = new DeepEntity();
		
		try {
			DeepCopy deepCopy = DeepCopy.getInstance();
			deepCopy.copyProperties(deepTO, deepEntity);
		} catch (DeepException e) {
			fail(e.getMessage());
		}
		
		assertTrue(deepTO.getText().equals(deepEntity.getTEXT_TEST()));
		assertTrue(deepTO.getB().equals(deepEntity.getB()));
		assertTrue(deepTO.getNumberInt().equals(deepEntity.getNumberInt()));
		assertTrue(deepTO.getNumberLong().equals(deepEntity.getNumberLong()));
		assertTrue(deepTO.getDate().toString().equals(deepEntity.getDate().toString()));
		assertTrue(deepTO.getMyType() == null);
	}
	
	public void testCopyWrapperPropertiesNullSubType() {
		//From this class
		DeepTO deepTO = new DeepTO();
		
		deepTO.setB(true);
		deepTO.setNumberInt(10);
		deepTO.setNumberLong(15l);
		deepTO.setText("Wilder");
		deepTO.setDate(new Date());
		
		DeepTypeTO deepTypeTO = new DeepTypeTO();
		deepTypeTO.setMyType("A TYPE!");
		deepTypeTO.setEnumType(EnumType.TYPE_A);
		
		deepTO.setMyType(deepTypeTO);
		
		//Don't set a sub type
		
		//To this class
		DeepEntity deepEntity = new DeepEntity();
		
		try {
			DeepCopy deepCopy = DeepCopy.getInstance();
			deepCopy.copyProperties(deepTO, deepEntity);
		} catch (DeepException e) {
			fail(e.getMessage());
		}
		
		assertTrue(deepTO.getText().equals(deepEntity.getTEXT_TEST()));
		assertTrue(deepTO.getB().equals(deepEntity.getB()));
		assertTrue(deepTO.getNumberInt().equals(deepEntity.getNumberInt()));
		assertTrue(deepTO.getNumberLong().equals(deepEntity.getNumberLong()));
		assertTrue(deepTO.getDate().toString().equals(deepEntity.getDate().toString()));
		assertTrue(deepTO.getMyType().getMyType().equals(deepEntity.getMyType().getMyType()));
		assertTrue(deepTO.getMyType().getSubType() == null);
	}
}