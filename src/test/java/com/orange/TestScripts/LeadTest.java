package com.orange.TestScripts;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.orange.base.ExcelReading;
import com.orange.base.Keywords;

public class LeadTest {
	
	@Test
	public void LoginTest() {
		ExcelReading read = new ExcelReading();
		Keywords key = new Keywords();
		
		
		ArrayList testData = read.testData("C:\\Users\\C5216839\\Desktop\\SeleNium Auto Proj 1\\LeadTestSuite.xlsx", 0);
		System.out.println(testData);
		
		for (int i = 0 ; i < testData.size(); i++) {
			if (testData.get(i).equals("openBrowser")) {
				key.openBrowser();
			}
			
			if (testData.get(i).equals("URL")) {
				String URLData = (String) testData.get(i+1);	
				key.URL(URLData);
			}
			
			if (testData.get(i).equals("input")) {
				String userName = (String) testData.get(i+1);	
				String objectName = (String) testData.get(i+2);
				key.input(userName,objectName);
			}
			
			if (testData.get(i).equals("click")) {
				
				String objectName = (String) testData.get(i+2);
				try {
					key.click(objectName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (testData.get(i).equals("closeBrowser")) {
					key.closeBrowser();
			}
			
			if (testData.get(i).equals("clickLead")) {
				System.out.println("check");
				String objectName = (String) testData.get(i+2);
				System.out.println(objectName);
				try {
					key.clickLead(objectName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	   
	}

	
	private void syso() {
		syso();
	}
	
	syso check();
}
