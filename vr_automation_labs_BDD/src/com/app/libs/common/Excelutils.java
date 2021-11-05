package com.app.libs.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Excelutils {
	//Read Excel data
	public static List<Map<String,String>> readExceldata(String workbookPath,String sheetName) throws IOException {
		List<String> columns = new ArrayList<String>();
		List<Map<String,String>> xlData = new ArrayList<Map<String,String>>();
		File f= new File(workbookPath);
		FileInputStream iStream = new FileInputStream(f);
		HSSFWorkbook oWb = new HSSFWorkbook(iStream);
		HSSFSheet oSheet = oWb.getSheet(sheetName);
		Row header = oSheet.getRow(0);
		//Fetch Column names
		Iterator<Cell> coliter = header.cellIterator();
		while (coliter.hasNext()){
			Cell c = coliter.next();
			columns.add(c.getStringCellValue());
		}
		//Read data and store to Map
		int noofrows = oSheet.getLastRowNum();
		for(int i=1;i<=noofrows;i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			Row r = oSheet.getRow(i);
			int noofcells = r.getLastCellNum();
			for(int j=0;j<noofcells;j++) {
				map.put(columns.get(j), r.getCell(j).getStringCellValue());
			}
			xlData.add(map);
		}
		oWb.close();
		return xlData;
	}
	
	public static int getRowNumberByKeyName(String workbookPath,String sheetName,String keyName) throws IOException {
		File f= new File(workbookPath);
		FileInputStream iStream = new FileInputStream(f);
		HSSFWorkbook oWb = new HSSFWorkbook(iStream);
		HSSFSheet oSheet = oWb.getSheet(sheetName);
		boolean found=false;
		int reqRow=0;
		int noofrows = oSheet.getLastRowNum();
		int cellCount = 0;
		String celltext="";
		for(int i=0;i<=noofrows;i++) {
			Row r = oSheet.getRow(i);
			try {
				cellCount=r.getLastCellNum();
				for(int j=0;j<cellCount;j++) {
					try {
						Cell c = r.getCell(j);
						celltext=c.getStringCellValue();
						if(StringUtils.equals(celltext.toLowerCase().trim(), keyName.trim().toLowerCase())) {
							reqRow=i;
							found=true;
							break;
						}
					}catch(Exception e) {
						continue;
					}
					
				}
			}catch(Exception e) {
				continue;
			}
			if(found) {
				break;
			}
		}
		oWb.close();
		return reqRow;
	}
	public static int getCellNumberByKeyName(String workbookPath,String sheetName,String keyName) throws IOException {
		File f= new File(workbookPath);
		FileInputStream iStream = new FileInputStream(f);
		HSSFWorkbook oWb = new HSSFWorkbook(iStream);
		HSSFSheet oSheet = oWb.getSheet(sheetName);
		boolean found=false;
		int reqCell=0;
		int noofrows = oSheet.getLastRowNum();
		int cellCount = 0;
		String celltext="";
		for(int i=0;i<=noofrows;i++) {
			Row r = oSheet.getRow(i);
			try {
				cellCount=r.getLastCellNum();
				for(int j=0;j<cellCount;j++) {
					try {
						Cell c = r.getCell(j);
						celltext=c.getStringCellValue();
						if(StringUtils.equals(celltext.toLowerCase().trim(), keyName.trim().toLowerCase())) {
							reqCell=j;
							found=true;
							break;
						}
					}catch(Exception e) {
						continue;
					}
					
				}
			}catch(Exception e) {
				continue;
			}
			
			if(found) {
				break;
			}
		}
		oWb.close();
		return reqCell;
	}
}
