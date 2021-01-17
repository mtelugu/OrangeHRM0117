package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class AdminPage {
		
	WebDriver driver;


	@FindBy(id = "txtUsername")
	WebElement txt_Username;
	
	@FindBy(id = "txtPassword")
	WebElement txt_Password;
	
	@FindBy(id = "btnLogin")
	WebElement btn_Login;
	
	@FindBy(id = "searchSystemUser_userName")
	WebElement username;
	
	@FindBy(id = "searchSystemUser_userType")
	WebElement selectclass;
	
	@FindBy(id = "searchSystemUser_employeeName_empName")
	WebElement employeename;
	
	@FindBy(id = "searchSystemUser_status")
	WebElement status_sel;
	
	@FindBy(id ="searchBtn")
	WebElement search_button;
	
	@FindBy(xpath = "//table[@id='resultTable']//tr//td[2]")
	public List <WebElement> table;
	
	@FindBy(id = "resetBtn")
	WebElement resetBtn;
	
	@FindBy(name ="btnAdd")
	WebElement btnAdd;
	
	@FindBy(id = "systemUser_userType")
	WebElement systemUser_userType;
	
	@FindBy(id ="systemUser_employeeName_empName")
	WebElement systemUser_employeeName_empName;
	
	@FindBy(id="systemUser_userName")
	WebElement systemUser_userName;
	
	@FindBy(id = "systemUser_status")
	WebElement systemUser_status;
	
	@FindBy(id="systemUser_password")
	WebElement systemUser_password;
	
	
	@FindBy(id = "systemUser_confirmPassword")
	WebElement systemUser_confirmPassword;
	
	@FindBy(id="btnSave")
	WebElement btnSave;
	
	
	public @FindBy(xpath ="//table[@id='resultTable']//tr//td[2]") List <WebElement> table2;
	
		
	public AdminPage(WebDriver driver) {
	PageFactory.initElements(driver,  this);
}

	public void login(String login, String password) {
	txt_Username.sendKeys(login);
	txt_Password.sendKeys(password);
	btn_Login.click();	
}

	public void EnteringValues(String Username,String userrole,String Empname,String status_val) {
	username.sendKeys(Username);
	Select option = new Select(selectclass);
	option.selectByVisibleText(userrole);
	employeename.sendKeys(Empname);
	Select status = new Select (status_sel);
	status.selectByVisibleText(status_val);
	search_button.click();
}
public String reset() {
	resetBtn.click();
	String name = username.getText();
	return name;
}
public void addemployee(String role,String Employ_name,String User_name,String status,String sys_pass,String sys_pass1) {
	btnAdd.click();
	Select User_role = new Select (systemUser_userType);
	User_role.selectByVisibleText(role);
	systemUser_employeeName_empName.sendKeys(Employ_name);
	systemUser_userName.sendKeys(User_name);
	Select Username_status = new Select (systemUser_status);
	Username_status.selectByVisibleText(status);
	systemUser_password.sendKeys(sys_pass);
	systemUser_confirmPassword.sendKeys(sys_pass1);
	btnSave.click();
	
}
public void deleteEmployee(WebDriver driver,String Expected) {
	driver.findElement(By.xpath("//a[text()='"+Expected+"']//ancestor::tr/td[1]//input[@type='checkbox']")).click();
	driver.findElement(By.id("btnDelete")).click();
	driver.findElement(By.id("dialogDeleteBtn")).click();
}




}