package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	

	public String readdatafromexcel(String sheetname,int rowno,int cellno) throws Throwable
	{
		
	FileInputStream fis=new FileInputStream("C:\\Users\\PAVANI\\Desktop\\exceldata.xlsx");
	return WorkbookFactory.create(fis).getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
	
	}
	public int readnumericdata(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\PAVANI\\Desktop\\exceldata.xlsx");
		 int val =(int)WorkbookFactory.create(fis).getSheet(sheetname).getRow(rowno).getCell(cellno).getNumericCellValue();
		return val;
	}
	public int getLastRow(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\PAVANI\\Desktop\\exceldata.xlsx");
		int val2=(int)WorkbookFactory.create(fis).getSheet(sheetname).getLastRowNum();
		return val2;
	}

}
