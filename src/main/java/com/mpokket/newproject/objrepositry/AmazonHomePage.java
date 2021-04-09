package com.mpokket.newproject.objrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

	

	public AmazonHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@data-action-type='DISMISS']")
	private WebElement dismissButton;
	
	@FindAll({@FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']"),@FindBy(xpath = "//div[@id='nav-cart-count-container']")})
	private WebElement cartbtn;

	public WebElement getCartbtn() {
		return cartbtn;
	}

	public WebElement getDismissButton() {
		return dismissButton;
	}

	public void searchtext()
	{
		
		searchBox.sendKeys("ss");
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	
	
	
}
