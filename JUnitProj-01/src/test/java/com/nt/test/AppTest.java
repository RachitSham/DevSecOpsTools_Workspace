package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nt.service.Airthmetic;

public class AppTest {

	@Test
	public void testWithPositive() {
		Airthmetic ar = new Airthmetic();
		float expected = 40.0f;
		float actual = ar.sum(30f, 10f);
		assertEquals(expected, actual, 0.0001f);
	}

	@Test
	public void testWithNegative() {
		Airthmetic ar = new Airthmetic();
		float expected = -40f;
		float actual = ar.sum(-30f, -10f);
		assertEquals(expected, actual, 0.0001f);
	}

	@Test
	public void testWithZero() {
		Airthmetic ar = new Airthmetic();
		float expected = 0.0f;
		float actual = ar.sum(0.0f, 0.0f);
		assertEquals(expected, actual, 0.0001f);
	}

	@Test
	// @Disabled [to make one test method not participating in the unit testing]
	public void testWithMixedValues() {
		Airthmetic ar = new Airthmetic();
		float expected = 30f; // ✅ Fixed expected value
		float actual = ar.sum(40f, -10f);
		assertEquals(expected, actual, 0.0001f);
	}
}
