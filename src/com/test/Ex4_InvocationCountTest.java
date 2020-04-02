/*
 * When there is a need to run same test case for multiple times
 * invocationCount -> How many times we want to execute test cases
 * 
 * 
 * */

package com.test;

import org.testng.annotations.Test;

public class Ex4_InvocationCountTest {

	@Test (invocationCount = 5) // 5 times sum() will be invoked
	public void sum() {
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println(c);
	}
	
}
