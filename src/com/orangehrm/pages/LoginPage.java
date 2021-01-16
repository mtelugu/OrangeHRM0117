package com.orangehrm.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	
	@FindBy(id = "txtUsername")
	WebElement txt_Username;
	
	@FindBy(id = "txtPassword")
	WebElement txt_Password;
	
	@FindBy(id = "btnLogin")
	WebElement btn_Login;
	
	@FindBy(id = "spanMessage")
	WebElement span_Message;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,  this);
	}	
	public void login(String login, String password) {
		txt_Username.sendKeys(login);
		txt_Password.sendKeys(password);
		btn_Login.click();	
	}
	public void verifyLoginError(String errMsg , String ValidationStep) {	
	String Actual = span_Message.getText();
	Assert.assertEquals(Actual, errMsg, ValidationStep);
	}
}

