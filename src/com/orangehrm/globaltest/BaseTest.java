package com.orangehrm.globaltest;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.utilities.PropertyUtil;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeSuite
	public void intialize() throws IOException {
		PropertyUtil.initializePropert();
	}
	
	public void browser() throws IOException {
		String browser = PropertyUtil.readProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", PropertyUtil.readProperty("chromeDriverpath"));
			driver= new ChromeDriver();	
		}
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", PropertyUtil.readProperty("FirefoxDriverpath"));
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyUtil.readProperty("implicittime")), TimeUnit.SECONDS);
		}
	
	
	public void openApplication() throws IOException {	
		driver.get(PropertyUtil.readProperty("url"));
	}
	
	public void adminPage() {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	}


