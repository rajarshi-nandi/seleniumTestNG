/*
 * The keyword 'priority' is used to execute the test cases in proper sequence
 * Without priority, the sequence will be in Alphabetical order by default
 * After the execution, refresh the project, test-output folder will be visible
 * By default basic TestNG report (html) will be generated
 * 
 * Grouping:
 * -----------------------------------
 * 
 * */

package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex2_GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\Eclipse Workspace\\TestngPractice\\Resource\\chromedriver.exe");
		driver = new ChromeDriver(); // Launch ChromeDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}

	@Test (priority = 1, groups = "Title")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	@Test (priority = 2, groups = "Logo")
	public void googleLogoTest() {
		boolean status = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
		System.out.println("Google logo displayed: " + status);

	}

	@Test (priority = 3, groups = "Link")
	public void gmailLinkTest() {
		boolean display = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println("Gmail link displayed: " + display);
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
