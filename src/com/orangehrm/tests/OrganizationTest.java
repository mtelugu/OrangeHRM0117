package com.orangehrm.tests;
import java.io.IOException;

import org.testng.annotations.Test;
import com.orangehrm.globaltest.BaseTest;
import com.orangehrm.pages.OrganizationPage;

public class OrganizationTest  extends BaseTest{

	@Test(priority=1)
	public void VerifyLoginWithValidCredentials() throws IOException {
		browser();
		openApplication();
		OrganizationPage adminpage = new OrganizationPage(driver);
		adminpage.login("Admin","admin123");		
	}
	@Test(enabled=false)
	public void GeneralInfo() {
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.admin("544 Texas", "858444");
		
	}
	@Test(enabled=false)
	public void addLocation() {
		
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.location();
		organizationPage.addlocation("Arjun", "Canada", "Telangana", "hyderabad", "hno-19-30 girinagar", "500037", "8686230814", "095466", "nothing");
	}
	@Test(enabled=false)
	public void search_location() {
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.location();
		organizationPage.search_button("Arjun", "Hyderabad", "Canada");		
	}
	@Test(priority=2)
	public void reset_location() {
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.location();
		String value = organizationPage.reset_button("Arjun", "Hyderabad", "Canada");
		if(value.equalsIgnoreCase("")) {
			System.out.println("Values have been reset");
		}
	}
	@Test(enabled=false)
	public void search_validation() {
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.location();
		for(int i=0;i<organizationPage.table.size();i++) {
			String value = organizationPage.table.get(i).getText();
			if(value.equalsIgnoreCase("Arjun")) {
				System.out.println("Locations hasbeen added successfully");
			}
			
		}
	}
}

