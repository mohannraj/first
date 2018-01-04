package com.projectName.libraries;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SuperTestNG 
{
  public static WebDriver driver;
 public ExtentReports report;
 public ExtentTest test;
  String xlPath = "./Exceldata/sample.xlsx";
  String sheetName = "Sheet1";
  String browserType;
  String URL;
  String filePath="./Report/Result.html";
 ///
  @BeforeSuite
  public void dd()
  {
	  report=new ExtentReports(filePath);
  }
  
  
  @BeforeMethod
  public void precondition()
   {
	  // test = report.startTest("precondition");
	 browserType = Generic.getExcelCellValue(xlPath, sheetName, 0, 1);
	 System.out.println("BrowserType :"+browserType);
   
	 if(browserType.equals("GC") )
	  {
		 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		 driver = new ChromeDriver(); 
	     Reporter.log("Opening Chrome browser",true);
	  }
	 else if(browserType.equals("IE") )
	  {
		 System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
		 driver = new InternetExplorerDriver();; 
	     Reporter.log("Opening Internet Explorer browser",true);
	  }
	 else
	  {
		 driver = new FirefoxDriver();
		 Reporter.log("Opening Firefox browser", true);
	  }
	 
	 //Write code to get timeout from Config.xlsx here
	 int timeOut = (int) Generic.getExcelNumericCellValue(xlPath, sheetName, 2, 1);
	 System.out.println(timeOut);
	 driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	 Reporter.log("timeOut:"+timeOut, true);
	 
	 driver.manage().window().maximize();
	
	 URL=Generic.getExcelCellValue(xlPath, sheetName, 1, 1);
	 driver.get(URL);
	 Reporter.log("Navigating to URL:"+URL, true);
   }
  //----------------------------------------------------------------------------------
  
  @AfterMethod
  public void postCondition()
   {
	  //report.endTest(test);
	
	
	  driver.quit();
	  Reporter.log("Closing the Browser", true);
   }   
  
  
  @AfterSuite
	public void end()
	{
		report.flush();
	}
 }

