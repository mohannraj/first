package com.projectName.LoginModule;

import org.testng.annotations.Test;

import com.projectName.libraries.Generic;
import com.projectName.libraries.ProjectSpecific;
import com.projectName.libraries.SuperTestNG;
import com.relevantcodes.extentreports.LogStatus;

public class AT_LoginLogout_Valid_Data_Driving_Test extends SuperTestNG
{

 @Test
 public void testAT_LoginLogout_Valid_Data_Driving_Test() throws InterruptedException
  {
	 //test.log(LogStatus.PASS, "2");
	 String xlPath = "./testdatas/AT_LoginLogout_Valid_Data_Driving_Test.xls";
	 String sheetName = "sheet1";
	 int rc = Generic.getExcelRowCount(xlPath, sheetName);
	 System.out.println("Rowcount: "+rc);
	 
	 for(int i=1; i<=rc; i++)
	 {
		 String un = Generic.getExcelCellValue(xlPath, sheetName, i, 0);
		 String pw = Generic.getExcelCellValue(xlPath, sheetName, i, 1);
		 String welcomePage = Generic.getExcelCellValue(xlPath, sheetName, i, 2);
		 String loginPage = Generic.getExcelCellValue(xlPath, sheetName, i, 3);
		 System.out.println("i: "+i);
		 ProjectSpecific.login(un, pw);
		 ProjectSpecific.verifyTitle(welcomePage);
		 ProjectSpecific.logout();
		 ProjectSpecific.verifyTitle(loginPage);
	 }
  }
}
