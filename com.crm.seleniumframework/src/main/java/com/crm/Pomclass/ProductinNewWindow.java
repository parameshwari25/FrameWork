package com.crm.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductinNewWindow {
	
	public ProductinNewWindow(WebDriver driver)
	{
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//input[@name='search_text']")
private WebElement sendproductdata;
@FindBy(xpath="//input[@type='button']")
private WebElement clickbutton;

public WebElement getSendproductdata() {
	return sendproductdata;
}
public WebElement getClickbutton() {
	return clickbutton;
}

public void newWindowPageAction(String data) {
	sendproductdata.sendKeys(data);
	clickbutton.click();
}

}