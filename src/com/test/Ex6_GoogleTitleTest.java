/**
 * Validation: Assert class is present which contains assert functions
 * Assertion is the most useful feature in testng
 * 
 * 
 * */

package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex6_GoogleTitleTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\Eclipse Workspace\\TestngPractice\\Resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com");

	}

	@Test
	public void googleTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google", "Title is not Matched"); // In case of failure this message will be printed
																		// else not
	}

	@Test(priority = 2, groups = "Logo")
	public void googleLogoTest() {
		boolean status = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
		System.out.println("Google logo displayed: " + status);
		Assert.assertTrue(status); // Add assertion
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}