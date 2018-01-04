package com.projectName.LoginModule;

import org.testng.annotations.Test;

import com.projectName.libraries.ProjectSpecific;
import com.projectName.libraries.SuperTestNG;
import com.relevantcodes.extentreports.LogStatus;

public class AT_Login_Invalid extends SuperTestNG
{
  @Test
  public void testAT_Login_Invalid() throws InterruptedException
  {
	//s test.log(LogStatus.PASS, "1");
	  ProjectSpecific.login("abc", "xyz");
	  String eMsg="Username or Password is invalid. Please try again.";
	  ProjectSpecific.explitywait(3000);
	  ProjectSpecific.verifyErrMsg(eMsg);
  }
}
