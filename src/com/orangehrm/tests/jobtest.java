package com.orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.orangehrm.globaltest.BaseTest;
import com.orangehrm.pages.JobPage;

public class jobtest extends BaseTest {

	@Test(priority=1)
	public void VerifyLoginWithValidCredentials() throws IOException{
		browser();
		openApplication();
		JobPage jobpage = new JobPage(driver);
		jobpage.login("Admin","admin123");	
		jobpage.admin();
		jobpage.job();
	}
	@Test(enabled=false)
	public void addingjob() {
		JobPage jobpage = new JobPage(driver);
		jobpage.addJobTitle("Associate manager", "This is an new source of job",driver,"Note is updated");
		for (int i=0;i<jobpage.table.size();i++) {
			WebElement values = jobpage.table.get(i);
			String value1 = values.getText();
			if(value1.equalsIgnoreCase("Associate Manager")) {
				System.out.println("Job title has been added");
			}
			
		}
	}
	@Test(enabled=false)
	public void deletejob() {
		JobPage jobpage = new JobPage(driver);
		jobpage.jobpagedelete(driver, "Associate manager");
	}
	
	@Test(enabled=false)
	public void paygrades() {
		JobPage jobpage = new JobPage(driver);
		jobpage.jobgrade("Arjun");
		jobpage.jobgrade1("USD - United States Dollar", "20000", "30000");
		
	}
	@Test(enabled=false)
	public void assignedCurrancy() {
		JobPage jobpage = new JobPage(driver);
		for(int i=0;i<jobpage.table2.size();i++) {
			String currancy  = jobpage.table2.get(i).getText();
			if(currancy.equalsIgnoreCase("United States Dollar")) {
				System.out.println("Currancy has been added");
			}
		}
	}
	@Test(enabled=false)
	public void deletecurrancy() {
		JobPage jobpage = new JobPage(driver);
		jobpage.currancy(driver,"United States Dollar");
		
	}
	@Test(priority=2)
	public void addWorkShift() {
		JobPage jobpage = new JobPage(driver);
		jobpage.AddWork("Morning","08:45", "18:30");
	}
}
