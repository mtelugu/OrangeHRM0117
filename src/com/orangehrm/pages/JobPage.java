package com.orangehrm.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class JobPage {
WebDriver driver;

@FindBy(id = "txtUsername")
WebElement txt_Username;

@FindBy(id = "txtPassword")
WebElement txt_Password;

@FindBy(id = "btnLogin")
WebElement btn_Login;

@FindBy(id="menu_admin_viewAdminModule")
WebElement admin_module;

@FindBy(id="menu_admin_Job")
WebElement menu_admin_Job;

@FindBy(id="menu_admin_viewJobTitleList")
WebElement menu_admin_viewJobTitleList;

@FindBy(id="btnAdd")
WebElement btnAdd;

@FindBy(id="jobTitle_jobTitle")
WebElement jobTitle_jobTitle;


@FindBy(id="jobTitle_jobDescription")
WebElement jobTitle_jobDescription;

@FindBy(id="jobTitle_jobSpec")
WebElement jobTitle_jobSpec;

@FindBy (id="jobTitle_note")
WebElement jobTitle_note;

@FindBy(id="btnSave")
WebElement btnSave;

public @FindBy(xpath ="//table[@id='resultTable']//tr//td[2]") 
List <WebElement> table;

@FindBy(id="btnDelete")
WebElement btnDelete;

@FindBy(id="dialogDeleteBtn")
WebElement dialogDeleteBtn;

@FindBy(id="menu_admin_viewPayGrades")
WebElement menu_admin_viewPayGrades;


@FindBy(id="payGrade_name")
WebElement payGrade_name;

@FindBy(id="btnAddCurrency")
WebElement btnAddCurrency;

@FindBy(id="payGradeCurrency_currencyName")
WebElement payGradeCurrency_currencyName;

@FindBy(id="payGradeCurrency_minSalary")
WebElement payGradeCurrency_minSalary;

@FindBy(id="payGradeCurrency_maxSalary")
WebElement payGradeCurrency_maxSalary;

@FindBy(id="btnSaveCurrency")
WebElement btnSaveCurrency;

@FindBy(id="menu_admin_workShift")
WebElement menu_admin_workShift;

@FindBy(id="workShift_workHours_from")
WebElement workShift_workHours_from;

@FindBy(id="workShift_workHours_to")
WebElement workShift_workHours_to;

@FindBy(id="workShift_availableEmp")
WebElement workShift_availableEmp;

@FindBy(id="btnAssignEmployee")
WebElement btnAssignEmployee;

@FindBy(id="workShift_name")
WebElement workShift_name;
public @FindBy(xpath ="//table[@id='tblCurrencies']//tr//td[2]")
List <WebElement> table2;


public JobPage(WebDriver driver) {
	PageFactory.initElements(driver,  this);
}

public void login(String login, String password) {
txt_Username.sendKeys(login);
txt_Password.sendKeys(password);
btn_Login.click();	
}

public void admin() {
	admin_module.click();
}
	

public void job() {
	menu_admin_Job.click();
	//menu_admin_viewJobTitleList.click();
	//btnAdd.click();
	//menu_admin_viewPayGrades.click();
}

public void addJobTitle(String JobTitle, String Job_Description,WebDriver driver,String note ) {
	jobTitle_jobTitle.sendKeys(JobTitle);	
	jobTitle_jobDescription.sendKeys(Job_Description);
	WebElement jobtitle =	driver.findElement(By.id("jobTitle_jobSpec"));
	jobtitle.sendKeys("E:\\Downloads\\LoginTest.class");
	jobTitle_note.sendKeys(note);
	btnSave.click();
}

	public void jobpagedelete(WebDriver driver,String expected) {
		WebElement delete_job= driver.findElement(By.xpath("//a[text()='"+expected+"']//ancestor::tr//input[@type='checkbox']"));
		delete_job.click();
		btnDelete.click();
		dialogDeleteBtn.click();
				
		}
	public void jobgrade(String name) {
		btnAdd.click();
		payGrade_name.sendKeys(name);
		btnSave.click();
		btnAddCurrency.click();
		
	}
	public void jobgrade1(String currancy,String i,String j) {
	payGradeCurrency_currencyName.sendKeys(currancy);
	payGradeCurrency_minSalary.sendKeys(i);
	payGradeCurrency_maxSalary.sendKeys(j);
	btnSaveCurrency.click();
	}
	
	public void currancy(WebDriver driver,String expected) {
		driver.findElement(By.xpath("//a[text()='"+expected+"']//ancestor::tr//input[@type='checkbox']")).click();
		driver.findElement(By.id("btnDeleteCurrency")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
	}
	
	public void AddWork(String name,String from,String to) {
		menu_admin_workShift.click();
		btnAdd.click();
		workShift_name.sendKeys(name);
		Select option  = new Select(workShift_workHours_from);
		option.selectByVisibleText(from);
		Select option_to = new Select(workShift_workHours_to);
		option_to.selectByVisibleText(to);
		Select multiple = new Select(workShift_availableEmp);
		multiple.selectByVisibleText("Charlie Carter");
		multiple.selectByIndex(1);
		multiple.selectByValue("28");
		btnAssignEmployee.click();
		btnSave.click();
	}
		}

