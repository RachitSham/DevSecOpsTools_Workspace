package com.nt.service;

import java.time.LocalDate;

public class BankService {

	public double calculateSimpleInterest(double pamt, double rate, double time) {
		System.out.println("BankService.calculateSimpleInterest()");
		if (pamt <= 0 || rate <= 0 || time <= 0) {
			throw new IllegalArgumentException("Invalid Inputs");
		}
		try {
			Thread.sleep(2000);
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pamt * rate * time / 100.0;
	}

	public LocalDate showSysDate(LocalDate ldt) {
		// get week day number
		int weekNo = ldt.getDayOfWeek().getValue();
		System.out.println("WeekDay Number:" + weekNo);
		if (weekNo == 6 || weekNo == 7)
			return null;
		else
			return ldt;
	}
}
