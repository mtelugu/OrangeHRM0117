package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {

	
	WebDriver driver;


	@FindBy(id = "txtUsername")
	WebElement txt_Username;
	
	@FindBy(id = "txtPassword")
	WebElement txt_Password;
	
	@FindBy(id = "btnLogin")
	WebElement btn_Login;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement menu_admin_viewAdminModule;
	
	@FindBy(id="menu_admin_Organization")
	WebElement menu_admin_Organization;
	
	@FindBy(id="menu_admin_viewOrganizationGeneralInformation")
	WebElement menu_admin_viewOrganizationGeneralInformation;
	
	@FindBy(id="btnSaveGenInfo")
	WebElement btnSaveGenInfo;
	@FindBy(id="organization_street2")
	WebElement organization_street2;
	
	@FindBy(id="organization_phone")
	WebElement organization_phone;
	
	@FindBy(id="menu_admin_viewLocations")
	WebElement menu_admin_viewLocations;
	
	@FindBy(id="btnAdd")
	WebElement btnAdd;
	
	@FindBy(id="location_name")
	WebElement location_name;
	
	@FindBy(id="location_country")
	WebElement location_country;
	
	@FindBy(id="location_address")
	WebElement location_address;
	
	@FindBy(id="location_province")
	WebElement location_province;
	
	@FindBy(id="location_city")
	WebElement location_city;
	
	@FindBy(id="location_zipCode")
	WebElement location_zipCode;
	
	@FindBy(id="location_phone")
	WebElement location_phone;
	
	@FindBy(id="location_fax")
	WebElement location_fax;
	
	@FindBy(id="location_notes")
	WebElement location_notes;
	
	@FindBy(id="btnSave")
	WebElement btnSave;
	
	@FindBy(id="searchLocation_name")
	WebElement searchLocation_name;
	
	@FindBy(id="searchLocation_city")
	WebElement searchLocation_city;
	
	@FindBy(id="searchLocation_country")
	WebElement searchLocation_country;
	
	@FindBy(id="btnSearch")
	WebElement btnSearch;
	
	@FindBy(id="btnReset")
	WebElement btnReset;
	
	
	public @FindBy(xpath="//table[@id='resultTable']//ancestor::tr/td[2]")
	List <WebElement> table;
	
	public OrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver,  this);
}

	public void login(String login, String password) {
	txt_Username.sendKeys(login);
	txt_Password.sendKeys(password);
	btn_Login.click();	
}
	public void admin(String address,String phone) {
		menu_admin_viewAdminModule.click();
		menu_admin_Organization.click();
		menu_admin_viewOrganizationGeneralInformation.click();
		btnSaveGenInfo.click();
		organization_street2.sendKeys(address);
		organization_phone.sendKeys(phone);
		btnSaveGenInfo.click();
	}
	public void location() {
		menu_admin_viewAdminModule.click();
		menu_admin_Organization.click();
		menu_admin_viewLocations.click();
	}
	public void addlocation(String name,String country_name,String state,
			String city,String address,String zipcode,String phone,String fax,String notes) {
		btnAdd.click();
		location_name.sendKeys(name);
		Select country = new Select(location_country);
		country.selectByVisibleText(country_name);
		location_province.sendKeys(state);
		location_city.sendKeys(city);
		location_address.sendKeys(address);
		location_zipCode.sendKeys(zipcode);
		location_phone.sendKeys(phone);
		location_fax.sendKeys(fax);
		location_notes.sendKeys(notes);
		btnSave.click();
	}
	public void search_button(String name,String city,String country_name) {
		searchLocation_name.sendKeys(name);
		searchLocation_city.sendKeys(city);
		Select search_country = new Select(searchLocation_country);
		search_country.selectByVisibleText(country_name);
		btnSearch.click();
	}
	public String reset_button(String name,String city,String country_name) {
		searchLocation_name.sendKeys(name);
		searchLocation_city.sendKeys(city);
		Select search_country = new Select(searchLocation_country);
		search_country.selectByVisibleText(country_name);
		btnReset.click();		
		String value = searchLocation_name.getText();
		return value;
	}
	
	
}





