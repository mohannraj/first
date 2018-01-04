package com.projectName.LoginModule;

import org.testng.annotations.Test;

import com.projectName.libraries.ProjectSpecific;
import com.projectName.libraries.SuperTestNG;
import com.relevantcodes.extentreports.LogStatus;

public class AT_LoginLogout_Valid extends SuperTestNG
{
 @Test
 public void testAT_LoginLogout_Valid() throws InterruptedException
 {
	 //test.log(LogStatus.PASS, "3");
	ProjectSpecific.login("admin", "manager");
	ProjectSpecific.verifyTitle("actiTIME - Enter Time-Track");
	ProjectSpecific.logout();
	ProjectSpecific.explitywait(3000);
	ProjectSpecific.verifyTitle("actiTIME - Login");
 }
}
