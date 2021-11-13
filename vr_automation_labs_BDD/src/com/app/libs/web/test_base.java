 package com.app.libs.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.app.libs.common.Excelutils;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;



public class test_base {
	
	public static WebDriver driver;
	public static String workbookPath="";
	public static Logger log;
	public static Properties prop = null;
	public static Properties envProp = null;
	//public static ExtentReports report = new ExtentReports("./Results/TestResults.html");
	//public static ExtentTest test;
	public static String tcname;
	public static String currentDirectory = System.getProperty("user.dir");
	public static List<Map<String,String>> testData = null;
	
	
	
	public static String captureScreenShot() {
		
		LocalDateTime dt = LocalDateTime.now(); 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
		
		TakesScreenshot scrnShot = (TakesScreenshot) driver;
		File scrShot= scrnShot.getScreenshotAs(OutputType.FILE);
		String scrnFilename = currentDirectory + "\\img\\" + tcname.replaceAll("\\s", "")+ "_" + dt.format(format) + ".png";
		File destFile = new File(scrnFilename);
		try {
			FileUtils.copyFile(scrShot, destFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destFile.getAbsolutePath();
	}
	
	public List<Map<String,String>> readTestdata(String sheetName,String keyname) throws IOException {
		
		workbookPath= currentDirectory + "\\resources\\" + prop.getProperty("environment") + "\\TestData\\testdata.xls";
		//Start key
		int reqRownum=Excelutils.getRowNumberByKeyName(workbookPath, sheetName, keyname);
		//End Key
		keyname=keyname+"End";
		int endreqRownum=Excelutils.getRowNumberByKeyName(workbookPath, sheetName, keyname);
		
		List<String> columns = new ArrayList<String>();
		testData = new ArrayList<Map<String,String>>();
		File f= new File(workbookPath);
		FileInputStream iStream = new FileInputStream(f);
		HSSFWorkbook oWb = new HSSFWorkbook(iStream);
		HSSFSheet oSheet = oWb.getSheet(sheetName);
		Row header = oSheet.getRow(reqRownum);
		//Fetch Column names
		for(int h=1;h<header.getLastCellNum();h++) {
			columns.add(header.getCell(h).getStringCellValue().trim());
		}
		//Read data and store to Map
		for(int i=reqRownum+1;i<=endreqRownum;i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			Row r = oSheet.getRow(i);
			int noofcells = r.getLastCellNum();
			if(i!=endreqRownum) {
				for(int j=1;j<noofcells;j++) {
					try {
						map.put(columns.get(j-1), r.getCell(j).getStringCellValue());
					}catch(NullPointerException e) {
						map.put(columns.get(j-1), "");
					}
					
				}
			}else if(i==endreqRownum) {
				for(int j=1;j<noofcells-1;j++) {
					try {
						map.put(columns.get(j-1), r.getCell(j).getStringCellValue());
					}catch(NullPointerException e) {
						map.put(columns.get(j-1), "");
					}
					
				}
			}
			
			testData.add(map);
		}
		oWb.close();
		
		return testData;
	}
	
	
	
	
		
	
	
	
}
