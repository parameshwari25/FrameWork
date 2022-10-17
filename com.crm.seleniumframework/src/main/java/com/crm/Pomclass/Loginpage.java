package com.crm.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//initialization
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameTexfield;
	
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitbutton;
	
	//getter method

	public WebElement getUserNameTexfield() {
		return userNameTexfield;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	
	//business logics
	/**
	 * this method is used to login the applicaion
	 * @parameshwari
	 * 
	 */
	public void login(String username,String password)
	{
		userNameTexfield.sendKeys(username);
		 passwordTextField.sendKeys(password);
		 submitbutton.click();
	}
	
	
	

}
