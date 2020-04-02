/**
 * @author Rajarshi Nandi
 * 
 * This program is used to login into demoWebshop tricentis site
 * This has the implementation of @DataProvider annotation from TestNG
 * DataProvider is used both from same and different class
 * 
 */

package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.ExcelReader;
import com.test.utility.ExternalDP;

public class Ex2_DataproviderTest {
	
	//Declare global variables
	String filePath = "C:\\Users\\rajar\\Eclipse Workspace\\TestngPractice\\Datasheets\\ExlDatasheet.xlsx";
	WebDriver driver; // Global Variable
	static int c;

	@DataProvider(name = "dp1") // Data provider in same class
	public Object[][] passData() {
		Object[][] obj = {	{ "rajarshi.nandi@accenture.com", "demo123" }, // Dataset 1
							{ "rajarshi.nandi@accenture.com", "demo123" }};// Dataset 2
		
		return obj;
	}
	
	//
	@DataProvider(name = "dp3")
	public Object[][] readDataFromExcl() throws Exception {
		ExcelReader reader = new ExcelReader();
		return reader.readData(filePath);
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Execution Start:\tSuccessful");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\Eclipse Workspace\\DesignDDFramework\\src\\test\\resources\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Launch Chrome Browser: \tSuccessful");
		driver.manage().window().maximize();
		System.out.println("Maximized Browser:\tSuccessful");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit Wait
		System.out.println("Set ImplicitWait:\tSuccessful");
		driver.get("http://demowebshop.tricentis.com/");
		System.out.println("Open demo web shop:\tSuccessful");
		c = 0; // set counter to zero
	}

	@Test(dataProvider = "dp1")
	public void validateTest1(String username, String password) throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click(); // Click on login
		System.out.println("Click Login link:\tSuccessful");
		driver.findElement(By.id("Email")).sendKeys(username); // Type username
		System.out.println("Entered Username:\t" + username);
		driver.findElement(By.id("Password")).sendKeys(password); // Type password
		System.out.println("Entered Password:\t" + password);
		driver.findElement(By.cssSelector("input.button-1.login-button")).click(); // Click on login button
		System.out.println("Click Login Button:\tSuccessful");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log out")).click(); // Click on logout button
		System.out.println("Click Logout link:\tSuccessful");
		Thread.sleep(3000);
	}
	
	@Test(dataProviderClass = ExternalDP.class, dataProvider = "dp2")
	public void validateTest2(String username, String password) throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click(); // Click on login
		System.out.println("Click Login link:\tSuccessful");
		driver.findElement(By.id("Email")).sendKeys(username); // Type username
		System.out.println("Entered Username:\t" + username);
		driver.findElement(By.id("Password")).sendKeys(password); // Type password
		System.out.println("Entered Password:\t" + password);
		driver.findElement(By.cssSelector("input.button-1.login-button")).click(); // Click on login button
		System.out.println("Click Login Button:\tSuccessful");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log out")).click(); // Click on logout button
		System.out.println("Click Logout link:\tSuccessful");
		Thread.sleep(3000);
	}
	
	@Test(dataProvider = "dp3")
	public void validateTest3(String username, String password) throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click(); // Click on login
		System.out.println("Click Login link:\tSuccessful");
		driver.findElement(By.id("Email")).sendKeys(username); // Type username
		System.out.println("Entered Username:\t" + username);
		driver.findElement(By.id("Password")).sendKeys(password); // Type password
		System.out.println("Entered Password:\t" + password);
		driver.findElement(By.cssSelector("input.button-1.login-button")).click(); // Click on login button
		System.out.println("Click Login Button:\tSuccessful");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log out")).click(); // Click on logout button
		System.out.println("Click Logout link:\tSuccessful");
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("Execution Completed:\tSuccessful");

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("****************************************\nStart Method:\tMethod " + counter()
				+ "\n----------------------------------------");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("----------------------------------------\nEnd Method:\tMethod " + c
				+ "\n****************************************");
	}

	public static int counter() {
		c++;
		return c;
	}

}