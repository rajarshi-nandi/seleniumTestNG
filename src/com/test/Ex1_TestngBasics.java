/*
 * In testng we dont need any main()
 * We will use annotation with @ sign
 * Each and every annotation should be associated with some method
 * @Before - prerequisities annotation
 * @After - post condition annotation
 * 
 * Sequence:
 * ---------------------
 * @BeforeMethod
 * @Test
 * @AfterMethod
 * @BeforeMethod
 * @Test
 * @AfterMethod
 * */

package com.test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class Ex1_TestngBasics {
	
	//All preconditions start with @Before
	
	@BeforeSuite
	public void setup() {
		System.out.println("@BeforeSuite -> Setup system property for chrome");		
	}
	
	@BeforeClass
	public void launchBrowser() {
		
		System.out.println("@BeforeClass -> Launch Chromebrowser");
	}
	
	@BeforeTest
	public void login() {
		System.out.println("@BeforeTest -> Login Method");
		
	}

	@BeforeMethod
	public void enterUrl() {
		System.out.println("@BeforeMethod -> Enter the URL");
		
	}
	
	//Actual Test case will start with @Test
	
	@Test //Testcase 1
	void googleTitleTest() {
		
		System.out.println("@Test -> Google title test");
	}
	
	@Test //Testcase 2
	public void searchTest() {
		System.out.println("@Test -> Test Search");
		
	}
	
	//All post conditions start with @After
	
	@AfterMethod
	public void logout() {
		
		System.out.println("@AfterMethod -> Logout from application");
	}
	
	
	@AfterTest
	public void deleteCookies() {
		System.out.println("@AfterTest -> Deleting all cookies");
		
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("@AfterClass -> Close browser");
		
	}
	
	@AfterSuite
	public void generateTestReport() {
		
		System.out.println("@AfterSuite -> Generate Test Report");
	}
	
}
