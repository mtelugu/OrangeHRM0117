package com.orangehrm.tests;

import java.io.IOException;


import org.testng.annotations.Test;
import com.orangehrm.globaltest.BaseTest;
import com.orangehrm.pages.AdminPage;


public class AdminTest extends  BaseTest {

	@Test(priority=1)
	public void VerifyLoginWithValidCredentials() throws IOException {
		browser();
		openApplication();
		AdminPage adminpage = new AdminPage(driver);
		adminpage.login("Admin","admin123");		
	}
	@Test(priority=2)
	public void  adminpage() {
	adminPage();
	AdminPage adminpage = new AdminPage(driver);
	adminpage.EnteringValues("arjuntelugu","ESS","Arjun telugu","Enabled");
	for(int i=0;i<adminpage.table.size();i++) {
		String values = adminpage.table.get(i).getText();
		if(values.equalsIgnoreCase("mtelugu")) {
			System.out.println("The username is valid and search button is working");
		}
	}
	}
	@Test(enabled=false)
	public void reset_field() {
		AdminPage adminpage = new AdminPage(driver);
		String name1 = adminpage.reset();
		if(name1.equalsIgnoreCase("")) {
			System.out.println("reset is functioing properly");
			
	}
		}
		@Test(priority=3)
		public void addEmployee() throws InterruptedException {
			AdminPage adminpage = new AdminPage(driver);
			adminpage.addemployee("Admin", "Arjun telugu", "arjun0007", "Enabled", "8686230814", "8686230814");
			Thread.sleep(2000);
			for(int i = 0; i < adminpage.table2.size();i++) {
				String  value=adminpage.table2.get(i).getText();
				if(value.equalsIgnoreCase("arjun0007"))
					System.out.println("Employe addedd succesfully");
				
			}
			Thread.sleep(2000);
			
		}
		@Test(priority=4)
		public void deleteEmp() {
			AdminPage adminpage=new AdminPage(driver);
			adminpage.deleteEmployee(driver,"arjun0007");
				
		}
		
}
