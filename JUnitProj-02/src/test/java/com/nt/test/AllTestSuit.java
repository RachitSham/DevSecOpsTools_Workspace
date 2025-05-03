package com.nt.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages("com.nt.test")
@SelectClasses({TestAirthmeticOperations.class, TestProductOperations.class})
@Suite
public class AllTestSuit {

}
