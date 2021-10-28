package com.orange.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Keywords {

	private WebDriver dr;
	private FileInputStream fis;
	private Properties prop;

	private FileInputStream ObjRepPath;
	private Properties ObjRepprop;

	public void openBrowser() {
		try {

			// Loading Properties file for Browsers
			fis = new FileInputStream(
					"C:\\Users\\C5216839\\eclipse-workspace\\orangeCRM\\src\\main\\java\\com\\orange\\base\\config.properties");
			prop = new Properties();
			prop.load(fis);

			String browserName = prop.getProperty("browserName");

			// Loading properties File for Object Repository
			ObjRepPath = new FileInputStream(
					"C:\\Users\\C5216839\\eclipse-workspace\\orangeCRM\\src\\main\\java\\com\\orange\\base\\objectRepository.properties");
			ObjRepprop = new Properties();
			ObjRepprop.load(ObjRepPath);

			if (browserName.equals("Chrome")) {
				dr = new ChromeDriver();
			} else if (browserName.equals("Firefox")) {
				dr = new FirefoxDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void URL(String uRLData) {
		dr.get(uRLData);
	}

	public void input(String userName, String objectName) {
		dr.findElement(By.xpath(ObjRepprop.getProperty(objectName))).sendKeys(userName);
		
	}

	public void click(String objectName) throws Exception {
		Thread.sleep(3000);
		dr.findElement(By.xpath(ObjRepprop.getProperty(objectName))).click();
		Thread.sleep(5000);
		
	}

	public void closeBrowser() {
		dr.close();
	}
	
	public void clickLead(String objectName) throws Exception {
		Thread.sleep(3000);
		dr.findElement(By.linkText(ObjRepprop.getProperty(objectName))).click();
		Thread.sleep(5000);
		
	}

}
