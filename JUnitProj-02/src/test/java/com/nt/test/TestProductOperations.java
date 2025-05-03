package com.nt.test;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.nt.service.AithmeticOperation;

public class TestProductOperations {
	private static AithmeticOperation po;

	@BeforeAll
	public static void setUp() {
		System.out.println("TestProductOperations.setUp()");
		po = new AithmeticOperation();
	}
	
	@BeforeEach
	public void setBeforeEach() {
		System.out.println("TestProductOperations.setBeforeEach()");
	}

	@Test
	public void testWithPositiveNumber() {
		int val1 = 30;
		int val2 = 10;
		int expected = 300;
		int actual = po.product(val1, val2);
		assertEquals(expected, actual);
	}

	@Test
	public void testWithNegativeValues() {
		int val1 =  30;
		int val2 = -10;
		int excepted = -300;
		int actual = po.product(val1, val2);
		assertEquals(excepted, actual);
	}

	@Test
	public void testWithZeroValues() {
		int val1 = 0;
		int val2 = 0;
		int excepted = 0;
		int actual = po.product(val1, val2);
		assertEquals(excepted, actual);
	}

	@Test
	public void testWithMixedValues() {
		int val1 = 30;
		int val2 = -10;
		int excepted = -300;
		int actual = po.product(val1, val2);
		assertEquals(excepted, actual);
	}

	@AfterEach
	public void setAfterWach() {
		System.out.println("TestProductOperations.setAfterWach()");
	}
	
	@AfterAll
	public static void setDown() {
		System.out.println("TestProductOperations.stepDown()");
		po = null;
	}
}
