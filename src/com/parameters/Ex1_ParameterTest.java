package com.parameters;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Ex1_ParameterTest {

	WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void setup(String browser) {
		// Parameterize browsers chrome/firefox
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\rajar\\Eclipse Workspace\\TestngPractice\\Resource\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\rajar\\Eclipse Workspace\\TestngPractice\\Resource\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("Invalid browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	@Parameters({ "url", "username" }) // Call the parameters from 'testng.xml'

	public void yahooLoginTest(String url, String username) throws InterruptedException {

		driver.get(url);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		Thread.sleep(5000);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}