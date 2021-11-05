package com.app.pages;

import java.util.concurrent.TimeUnit;

import com.app.libs.common.StringUtils;
import com.app.libs.web.VRWebElement;
import com.app.libs.web.ui_utils;

public class LoginPage extends VRWebElement {
/////////////////////////// Locators ////////////////////////////////////
	public VRWebElement getUserNameField() {
		return new VRWebElement("xpath=//input[@name='email']");
	}
	
	public VRWebElement getPasswordField() {
		return new VRWebElement("xpath=//input[@name='password']");
	}
	
	public VRWebElement getLoginButton() {
		return new VRWebElement("xpath=//div[text()='Login']");
	}
	
	/////////////////////////// Methods ////////////////////////////////////
	
	
	//Click Login
	public void clickLogin() {
		ui_utils.click_element(getLoginButton(), "Login");
	}
	
	//Enter UserName
	public void enterUserName(String userName) {
		
		ui_utils.set_edit_field_value(getUserNameField(), "UserName", userName);
	}
	
	//Enter Password
	public void enterPasswod(String password) {
		
		ui_utils.set_edit_field_value(getPasswordField(), "Password", password);
	}
	
	//Login
	public void LoginToCRM(String userName,String password) {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!StringUtils.isNullOrEmpty(userName)) {
			enterUserName(userName);
			
		}
		if(!StringUtils.isNullOrEmpty(password)) {
			enterPasswod(password);
		}
		clickLogin();
	}
	
}
