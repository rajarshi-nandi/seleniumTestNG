package com.test.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	int rowNum = 0;
	int colNum = 0;
	String sheetName = null;

	public Object[][] readData(String filePath) throws Exception {

		Object[][] obj = null; // Create 2D object array to store content of excel sheet
		
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		// Total row count
		rowNum = sheet.getLastRowNum();
		System.out.println("\nTotal number of row:\t" +(rowNum+1));

		// Total Column count
		colNum = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Total number of col:\t" + colNum+"\n");

		// Create dynamic 2D array of Object with same row and column length as datasheet
		obj = new Object[rowNum][colNum];

		/* **
		 * Read from excel file and store inside the array
		 * In destination array i.e. (obj) we should store data from [0][0]
		 * We should copy from the second row of excel sheet (i.e [1][0]) due to header
		 * **		 
		 */
		
		for (int i = 1; i <=rowNum; i++) {
			for(int j = 0; j <colNum; j++ ) {
				obj[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		//Close the workbook
		wb.close();
		
		//Return 2D array of object
		return obj;
	}
}