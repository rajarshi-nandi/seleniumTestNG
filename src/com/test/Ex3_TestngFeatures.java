/*
 * Dependency of one method to another one is implemented by the keyword 'dependsOnMethods'
 * Dependent test is skipped (Skips: 1) if the main test is failed (Failures: 1)
 * Dependent tests are skipped (Skips: 3) if the main test is failed (Failures: 1)
 * 
 * */

package com.test;

import org.testng.annotations.Test;

public class Ex3_TestngFeatures {
	
	
	@Test
	public void loginTest() {
		System.out.println("Login successful");
		int i = 9/0;
	}
	
	@Test (dependsOnMethods = "loginTest") // homepageTest dependent on loginTest
	public void homePageTest() {
		System.out.println("Homepage test");
		
	}
	
	@Test (dependsOnMethods = "loginTest") // searchpage dependent on loginTest
	public void searchPageTest() {
		System.out.println("Searchpage test");
		
	}

	@Test (dependsOnMethods = "loginTest") // regpage dependent on loginTest
	public void regPageTest() {
		System.out.println("Regpage test");
		
	}

}
