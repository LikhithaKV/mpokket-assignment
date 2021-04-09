package com.mpokket.newproject.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mpokket.newproject.commonlib.BaseClass;
import com.mpokket.newproject.objrepositry.AmazonHomePage;
import com.mpokket.newproject.objrepositry.AmazonProductListPage;
import com.mpokket.newproject.objrepositry.Cartpage;
import com.mpokket.newproject.objrepositry.Productpage;

public class AmazonTestCasesTest extends BaseClass{

	
	
		
	@Test
	public void addProductToCartAndVerify() throws Throwable {
		AmazonHomePage hp=new AmazonHomePage(driver);
		wLib.waitforElement(hp.getSearchBox());
		hp.getSearchBox().click();
		hp.getSearchBox().sendKeys("samsung mobile phones");
		
		hp.getSearchButton().click();
		AmazonProductListPage ap=new AmazonProductListPage(driver);
		List<WebElement> products = ap.getProduct_list();
		products.get(0).click();
		Productpage pp=new Productpage(driver);
		 String expproducttitle = pp.getProducttitle().getText();
		 pp.getAddtocartbtn().click();
		 pp.getCartbtn().click();
//		 hp.getCartbtn().click();
		 Cartpage cp = new Cartpage(driver);
		 String actproducttitle=driver.findElement(By.xpath("//span[contains(text(),'"+expproducttitle+"')]")).getText();
		 //String actproducttitle = cp.getCartprdtitle().getText();
		 
	Assert.assertTrue(actproducttitle.contains(expproducttitle));
	}
	
//	@Test
	public void searchProductAndVerify() throws Throwable {
		AmazonHomePage hp=new AmazonHomePage(driver);
		
		String actProduct = "samsung mobile phones";
		wLib.waitforElement(hp.getSearchBox());
		hp.getSearchBox().click();
		hp.getSearchBox().sendKeys(actProduct);
		
		
		hp.getSearchButton().click();
		AmazonProductListPage ap=new AmazonProductListPage(driver);
		List<WebElement> products = ap.getProduct_list();
		for (int i = 0; i <products.size(); i++) {
			String producttext = products.get(i).getText();
			System.out.println();
			elib.setExcelData("Sheet1", i, 0, producttext);
		}
		
	}
}
