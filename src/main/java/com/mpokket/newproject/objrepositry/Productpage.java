package com.mpokket.newproject.objrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {

	public Productpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement producttitle;
	
	
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement addtocartbtn;

	
	@FindBy(xpath = "//a[@id='nav-cart']")
	private WebElement cartbtn;
	
	

	public WebElement getCartbtn() {
		return cartbtn;
	}



	public WebElement getProducttitle() {
		return producttitle;
	}



	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}
	
	
	
}
