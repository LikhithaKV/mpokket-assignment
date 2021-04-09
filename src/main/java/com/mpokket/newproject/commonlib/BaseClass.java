package com.mpokket.newproject.commonlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.mpokket.newproject.objrepositry.AmazonHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver staticDriver;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();

	public WebDriverUtiles wLib = new WebDriverUtiles();
	
	public WebDriver driver;

	

	
	@BeforeClass(groups = "smoke")
	public void configBC() throws Throwable {
		System.out.println("=============launch the browser================");
	

		
		String BROWSER = fLib.getPropertyKeyValue("browser");

		if (BROWSER.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();
			op.addArguments("-disable--notifications");
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
//		driver.get(URL);
		driver.manage().window().maximize();

	}

	
	  @BeforeMethod(groups = "smoke") 
	  public void configBM() throws Throwable {
		  String URL = fLib.getPropertyKeyValue("url");
		  driver.get(URL); 
		  
		  wLib.waitForHTMLDOM(driver);
		  AmazonHomePage hp=new AmazonHomePage(driver);
		  hp.getDismissButton().click();
	  }
	  
	  //@AfterMethod(groups = "smoke") public void configAM() {}
	 

	@AfterClass(groups = "smoke")
	public void configAC() {
		System.out.println("=============close the browser================");
	
		driver.close();

	}

	

}
