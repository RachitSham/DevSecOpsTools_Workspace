package com.nt.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@DisplayName("Test Class Bank Service Class")
@TestMethodOrder(OrderAnnotation.class) // Enables @Order to work
public class TestBankService {

	private static BankService service;

	@BeforeAll
	public static void setUp() {
		service = new BankService();
	}

	@Test
	@DisplayName("Calculate Interest With Big Value")
	@Tag("uat")
	@Order(1)
	public void calculateSimpleInterestWithBigValue() {
		double expected = 2400000.0;
		double actual = service.calculateSimpleInterest(10000000.0, 2.0, 12.0);
		assertEquals(expected, actual, 1.0);
	}

	@Test
	@DisplayName("Calculate Interest With Small Value")
	@Tag("uat")
	@Order(2)
	public void calculateSimpleInterestWithSmallValue() {
		double expected = 24000.0;
		double actual = service.calculateSimpleInterest(100000.0, 2.0, 12.0);
		assertEquals(expected, actual, 0.5);
	}

	@Test
	@DisplayName("Calculate Interest With Invalid Value")
	@Tag("uat")
	@Order(3)
	public void calculateSimpleInterestWithInvalidValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculateSimpleInterest(0, 2.0, 12.0);
		});
	}

	@Test
	@DisplayName("Calculate Interest With Timer")
	@Tag("uat")
	@Order(4)
	public void calculateSimpleInterestWithTimer() {
		assertTimeout(Duration.ofMillis(3000), () -> {
			service.calculateSimpleInterest(100000.0, 2.0, 12.0);
		});
	}

	@Test
	@DisplayName("Show System Date On Weekdays")
	@Tag("uat")
	@Order(5)
	public void showSysDateOnWeekdays() {
		LocalDate ldt = LocalDate.of(2025, 5, 5); // Monday
		LocalDate result = service.showSysDate(ldt);
		assertNotNull(result);
	}

	@Test
	@DisplayName("Show System Date On Weekend")
	@Tag("uat")
	@Order(6)
	public void showSysDateOnWeekend() {
		LocalDate saturday = LocalDate.of(2025, 5, 3); // Saturday
		LocalDate result = service.showSysDate(saturday);
		assertNull(result);
	}

	@AfterAll
	public static void tearDown() {
		service = null;
	}
}
