package com.projectName.libraries;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class ProjectSpecific extends SuperTestNG 
{
	public static void login(String UN, String PWD) throws InterruptedException
	 {
		driver.findElement(By.name("username")).sendKeys(UN);
        driver.findElement(By.name("pwd")).sendKeys(PWD);
        Thread.sleep(3000);
        driver.findElement(By.id("loginButton")).click(); 
	 }
	
	public static void goToCustomersPage()
	 {
	     driver.findElement(By.xpath("//div[contains(text(),'TASKS')]")).click();    	
	     //driver.findElement(By.linkText("Projects & Customers")).click();
	 }

    public static void createCustomer(String CustomerName) throws InterruptedException
     {
	      driver.findElement(By.xpath("//div[@class='plusIcon']")).click();
	      Thread.sleep(1000);
	      driver.findElement(By.xpath("//div[Contains(text(),'New Customer')]")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//input[@id='customerLightBox_nameField']")).sendKeys(CustomerName);
	      //driver.findElement(By.name("name")).sendKeys(CustomerName);
	      driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys("New customer details");
	    driver.findElement(By.xpath("//span[Contains(text(),'Create Customer')]")).click();
	      //driver.findElement(By.name("createCustomerSubmit")).click();
     }	
	
	public static void logout()
	 {
		   driver.findElement(By.id("logoutLink")).click();
	 }
	
	public static void verifyTitle(String eTitle)
	 {
		explitywait(3000);
		String aTitle = driver.getTitle();
		if(aTitle.equals(eTitle))
		 {
			Reporter.log("Pass:eTitle & aTitle are same\n"+eTitle,true);
		 }
		else
		{
			String msg="eTitle:"+eTitle+"\naTitle: "+aTitle;
			Reporter.log("Fail:eTitle & aTitle are not same\n"+msg,true);
		}
	 }
	
	public static void verifySuccessMsg(String eSmsg)
	{
		String aSmsg = driver.findElement(By.className("successmsg")).getText();
		if(eSmsg.equals(aSmsg))
		{
			Reporter.log("Pass:eSmsg & aSmsg are same\n"+eSmsg,true);
		}
		else
		{
			String msg = "eSmsg:"+eSmsg+"\n aSmsg"+aSmsg;
			Reporter.log("Fail:eSmsg & aSmsg are not same\n"+msg,true);
		}
	}
	
	public static void verifyErrMsg(String eEmsg)
	{
		String aEmsg = driver.findElement(By.className("errormsg")).getText();
		if(eEmsg.equals(aEmsg))
		{
			Reporter.log("Pass:eEmsg & aEmsg are same\n"+aEmsg,true);
		}
		else
		{
			String msg = "eEmsg:"+eEmsg+"\n aEmsg"+aEmsg;
			Reporter.log("Fail:eEmsg & aEmsg are not same\n"+msg,true);
		}
	}

	public static void explitywait(int timeOutInMS)
	{
		try
		 {
		   Thread.sleep(timeOutInMS);
		 }
		catch(InterruptedException e)  
		{}
	}

}

