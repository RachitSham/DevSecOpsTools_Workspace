package com.nt.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Test Class Bank Service Class")
//@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class) // best [decides the test method order based on the method names]
//@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.MethodName.class)
//@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.MethodName.class)
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.Random.class) // default

public class TestBankService {

	private static BankService service;

	@BeforeAll
	public static void setUp() {
		service = new BankService();
	}

	@Test
	@DisplayName("Calculate Interest With big Value")
	@Tag("uat")
	@Order(-1)
	public void calculateWithSimpleInterestWithBigValue() {
		double excepted = 2400000;
		double actual = service.calculateSimpleInterest(10000000.0, 2.0, 12.0);
		assertEquals(excepted, actual, 1.0);
	}

	@Test
	@DisplayName("Calculate Interest With Small Value")
	@Tag("uat")
	@Order(10)
	public void calculateWithSimpleInterestWithSmallValue() {
		double excepted = 24000;
		double actual = service.calculateSimpleInterest(100000.0, 2.0, 12.0);
		assertEquals(excepted, actual, 0.5);

	}

	@Test
	@DisplayName("Calculate Interest With Invalid Value")
	@Tag("uat")
	@Order(7)
	public void calculateWithSimpleInterestWithInvalidValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculateSimpleInterest(0, 2.0, 12.0);
		});

	}

	@Test
	@DisplayName("Calculate Interest With Timer")
	@Tag("uat")
	@Order(-20)
	public void calculateWithSimpleInterestWithTimer() {
		assertTimeout(Duration.ofMillis(3000), () -> {
			service.calculateSimpleInterest(100000.0, 2.0, 12);
		});
	}

	@Test
	@DisplayName("Show System Date On Week Days")
	@Tag("uat")
	public void testShowSysDateOnWeekDays() {
		LocalDate ldt = LocalDate.now();
		LocalDate ldt1 = service.showSysDate(ldt);
		assertNotNull(ldt1);
	}

	@Test
	@DisplayName("Show System date On Weekend Days")
	@Tag("uat")
	public void testShowSysDateOnWeeknedDays() {
		LocalDate ldt = LocalDate.now();
		ldt = ldt.plusDays(6);
		LocalDate ldt1 = service.showSysDate(ldt);
		assertNull(ldt1);
	}

	@AfterAll
	public static void setDown() {
		service = null;

	}
}
