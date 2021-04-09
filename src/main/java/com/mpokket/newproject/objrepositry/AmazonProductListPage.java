package com.mpokket.newproject.objrepositry;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductListPage {
	
	public WebDriver driver;

	public AmazonProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getProduct_list() {
		return product_list;
	}



	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> product_list;
	
	
	

}
