package com.test.utility;

import org.testng.annotations.DataProvider;

public class ExternalDP {
	//Data provider present in different class
	@DataProvider(name = "dp2")  
	public Object[][] passData02(){
		
		Object[][] obj = {
				{"rajarshi.nandi@accenture.com","demo123"}, //Dataset 1
				{"rajarshi.nandi@accenture.com","demo123"}, //Dataset 2
				{"rajarshi.nandi@accenture.com","demo123"}	//Dataset 3
		};
		return obj;
	}
}