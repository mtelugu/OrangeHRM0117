package com.orangehrm.tests;
import org.testng.annotations.Test;
import com.orangehrm.globaltest.BaseTest;
import com.orangehrm.pages.LoginPage;


public class LoginTest extends BaseTest {
				
			@Test
			public void VerifyLoginWithValidCredentials() {
				LoginPage loginpage = new LoginPage(driver);
				loginpage.login("Admin","admin123");
				closeBrowser();
				
			}	
			@Test
			public void VerifyLoginWithInValidCredentials() {
				
				LoginPage loginpage = new LoginPage(driver);
				loginpage.login("Admin123","admin123");
				loginpage.verifyLoginError("Invalid credentials", "User have entered ivalid credentials");
				closeBrowser();
				
			}
			
			@Test
			public void VerifyLoginWithBlankUsername() {
				
				LoginPage loginpage = new LoginPage(driver);
				loginpage.login("","admin123");
				loginpage.verifyLoginError("Username cannot be empty", "User have entered ivalid credentials");
				closeBrowser();
				
			}
			@Test
			public void VerifyLoginWithBlankPassword() {
				
				LoginPage loginpage = new LoginPage(driver);
				loginpage.login("Admin123","");
				loginpage.verifyLoginError("Password cannot be empty", "User have entered ivalid credentials");
				closeBrowser();
				
			}
			
			}

