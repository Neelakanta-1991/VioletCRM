package com.orange.base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public ArrayList testData(String FilePath, int SheetNum) {	
		
		ArrayList data = new ArrayList();
		
		try {
			FileInputStream fis = new FileInputStream(FilePath);
			XSSFWorkbook wbks = new XSSFWorkbook(fis);
			XSSFSheet sheet = wbks.getSheetAt(SheetNum);
			//index of 1st sheet = 0
			
			Iterator<Row> iterator = sheet.iterator();
			
			while(iterator.hasNext()) {
				Row row = iterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(cell.getCellType()==CellType.STRING) {
						data.add(cell.getStringCellValue());
					}
				}
			}		
			return data;
					
		}catch (Exception e) {
			System.out.println(e);
		}
	
		return null;
		
	}
}
