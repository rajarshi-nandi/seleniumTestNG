/**
 * Question: Without try catch block how to handle exception?
 * In TestNG use expectedExceptions 
 * 
 * */

package com.test;

import org.testng.annotations.Test;

public class Ex5_ExceptionTimeOutTest {

	@Test(timeOut = 3000) //5000ms --> 
	public void timeoutTest() throws InterruptedException {
		
		Thread.sleep(6000);
		
	}
	
	
	@Test(expectedExceptions = NumberFormatException.class)  // We are expecting number format exception here
	public void exceptionTest() {
		
		String s = "1001A";
		int a = Integer.parseInt(s); // NumberFormatException occurs
		System.out.println(a);
		
	}
}
