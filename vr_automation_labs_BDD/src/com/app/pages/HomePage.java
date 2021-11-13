package com.app.pages;

import com.app.libs.web.VRWebElement;
import com.app.libs.web.ui_utils;
//import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class HomePage extends VRWebElement {
/////////////////////////// Locators ////////////////////////////////////
	public VRWebElement getLogInButton() {
		return new VRWebElement("xpath=//span[text()='Log In']");
	}
	
	public VRWebElement getSignUpButton() {
		return new VRWebElement("xpath=//span[text()=' sign up']");
	}
	
	/////////////////////////// Methods ////////////////////////////////////
	
	//Launch appliction
	public void launchCRM() {
		driver.get(envProp.getProperty("url"));
		//test.log(LogStatus.PASS, "CRM Application Launched Successfully.");
	}
	//Verify Home page is Title
	public void verifyHomePageTitle(String expTitle) {
		boolean result = ui_utils.verifyPageTitle(expTitle);
		if(result) {
			//test.log(LogStatus.PASS, "Page tile is as expected " + expTitle );
		}else {
			
			//test.log(LogStatus.FAIL, "Page tile is not as expected " + expTitle);
			//test.log(LogStatus.FAIL, "verify Page Title", test.addScreenCapture(captureScreenShot()));
		}
		Assert.assertEquals(true, result);
	}
	
	//Click Login
	public void clickLogin() {
		
		ui_utils.click_element(getLogInButton(), "Login");
	}
	
	//Click Signup
	public void clickSignup() {
		ui_utils.click_element(getSignUpButton(), "Signup");
	}
}
