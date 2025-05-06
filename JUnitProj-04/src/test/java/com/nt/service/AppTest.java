package com.nt.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {

	private static Pallendrome pd;

	@BeforeAll
	public static void setUp() {
		pd = new Pallendrome();
	}

	@BeforeEach
	public void beforeTest() {
		System.out.println("AppTest.beforeTest()");
	}

	@Test
	@DisplayName("Test With Valid Inputs")
	public void testPallendromeWithValidInputs() {
		assertTrue(pd.isPallendrome("madam"));
	}

	@Test
	@DisplayName("Test With Invalid Inputs")
	public void testPallendromeWithInvalidInputs() {
		assertFalse(pd.isPallendrome("madam1")); // changed assertTrue -> assertFalse
	}

	@Test
	@DisplayName("Test With no Inputs")
	public void testPallendromeWithNoInputs() {
		assertThrows(IllegalArgumentException.class, () -> {
			pd.isPallendrome("");
		});
	}

	@AfterEach
	public void afterTest() {
		System.out.println("AppTest.afterTest()");
	}

	@AfterAll
	public static void setDown() {
		pd = null;
	}
}
