package com.mpokket.newproject.objrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	

	public Cartpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='a-size-medium sc-product-title a-text-bold']")
	private WebElement cartprdtitle;
	public WebElement getCartprdtitle() {
		return cartprdtitle;
	}
	
	
	
}
