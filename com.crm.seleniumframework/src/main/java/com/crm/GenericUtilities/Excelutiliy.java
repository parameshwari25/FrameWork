package com.crm.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutiliy {
	public String getDataFormatExcel(String sheetName,int RowNum,int cellNum) throws Throwable
	{
		FileInputStream cam = new FileInputStream("./campaign.xlsx");
		Workbook book1 = WorkbookFactory.create(cam);
		Sheet sh1 = book1.getSheet(sheetName);
		Row ro1 = sh1.getRow(RowNum);
		Cell cel1 = ro1.getCell(cellNum);
		String data=cel1.getStringCellValue();
		return data;
		
		
		/* DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetName).getRow(RowNum).getCell(cellNum));*/
	}
	

}
