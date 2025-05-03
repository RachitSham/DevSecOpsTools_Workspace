package com.nt.test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nt.service.AithmeticOperation;

public class TestAirthmeticOperations {

	private static AithmeticOperation ar;

	@BeforeAll
	public static void setUp() {
		System.out.println("TestAirthmeticOperations.setUp()");
		ar = new AithmeticOperation();
	}

	@BeforeEach
	public void setBeforeEach() {
		System.out.println("TestAirthmeticOperations.setBeforeEach()");
	}

	@Test
	public void testSumWithPositive() {
		System.out.println("TestAirthmeticOperations.testSumWithPositive()");
		float val1 = 10;
		float val2 = 20;
		float expected = 30;
		float actual = ar.sum(val1, val2);
		assertEquals(expected, actual, 0.001f);
	}

	@Test
	public void testSumWithNegative() {
		System.out.println("TestAirthmeticOperations.testSumWithNegative()");
		float val1 = -10;
		float val2 = -20;
		float excepted = -30;
		float actual = ar.sum(val1, val2);
		assertEquals(excepted, actual, 0.001f);
	}

	@Test
	public void testSumWithZero() {
		System.out.println("TestAirthmeticOperations.testSumWithZero()");
		float val1 = 0;
		float val2 = 0;
		float expected = 0;
		float actual = ar.sum(val1, val2);
		assertEquals(expected, actual, 0.001f);
	}

	@Test
	public void testSumWithMultiValues() {
		System.out.println("TestAirthmeticOperations.testSumWithMultiValues()");
		float val1 = 10;
		float val2 = -20;
		float expected = -10;
		float actual = ar.sum(val1, val2);
		assertEquals(expected, actual, 0.001f);
	}

	@AfterEach
	public void setAfterEach() {
		System.out.println("TestAirthmeticOperations.setAfterEach()");
	}

	@AfterAll
	public static void testDown() {
		System.out.println("TestAirthmeticOperations.testDown()");
		ar = null;
	}
}
