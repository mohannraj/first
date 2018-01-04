package com.projectName.libraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Generic {
	public static int getExcelRowCount(String xlPath, String sheetName)
	{
		int row_Count;
		try{	
		    FileInputStream fis = new FileInputStream(xlPath);
		    Workbook wb = WorkbookFactory.create(fis);
		    Sheet s = wb.getSheet(sheetName);
		    row_Count=s.getLastRowNum();
		   }
		  catch(Exception e)
           {
        	  row_Count=-1;
           }
	    return row_Count;
	}
	
  public static String getExcelCellValue(String xlPath, String sheetName, int rowNum, int colNum)
   {
	 String cellValue;
	 
	  try
	   {	
		  FileInputStream fis = new FileInputStream(xlPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet s = wb.getSheet(sheetName);
		  cellValue = s.getRow(rowNum).getCell(colNum).getStringCellValue();
	   }
	  catch(Exception e)
       {
     	   cellValue="";
       }
	    return cellValue;
   }
 
  public static int getExcelNumericCellValue(String xlPath, String sheetName, int rowNum, int colNum)
  {
	 int cellValue;
	 
	  try
	   {	
		  FileInputStream fis = new FileInputStream(xlPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet s = wb.getSheet(sheetName);
		  cellValue = (int) s.getRow(rowNum).getCell(colNum).getNumericCellValue();
	   }
	  catch(Exception e)
      {
    	   cellValue=0;
      }
	    return cellValue;
  }
  
}
	


