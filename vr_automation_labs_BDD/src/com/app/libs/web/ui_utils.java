package com.app.libs.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.app.libs.common.Reporter;
import com.app.libs.common.StringUtils;
//import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class ui_utils extends test_base {
	
	//Set edit Field value
	public static void set_edit_field_value(VRWebElement elemnent, String elemname, String val){
		if(elemnent.verifyPresent()) {
			elemnent.sendKeys(val);
			//Reporter.update_Report_step(fwt, "Enter " + elemname + " field value", elemname + " field value should be entered as : " + val, elemname + " field value is entered as : " + val, "PASS");
			log.info(elemname + " field value entered as : " + val);
			//test.log(LogStatus.PASS, elemname + " field value entered as : " + val);
		}else {
			//Reporter.update_Report_step(fwt, "Enter " + elemname + " field value", elemname + " field value should be entered as : " + val, "Failed to locate " + elemname + " field", "FAIL");
			log.error("Failedto Locate the element : " + elemname);
			//test.log(LogStatus.FAIL , "Failedto Locate the element : " + elemname);
		}
		
	}
	
	//select dropdown field
	public static void select_drop_down_item(VRWebElement element, String elemName, String dropdownitem) {
		if(element.verifyPresent()) {
			element.sel_dropdown_item_by_visible_text(dropdownitem);
			//Reporter.update_Report_step(fwt, "Select the " + elemName + " dropdown item as : " + dropdownitem, elemName + " dropdown should be selected as : " + dropdownitem, elemName + " dropdown is selected successfully as : " + dropdownitem, "PASS");
			log.info(elemName + " dropdwon item selected as : " + dropdownitem );
			//test.log(LogStatus.PASS, " dropdwon item selected as : " + dropdownitem);
		}else {
			log.error("Failed to Locate element : " + elemName);
			//test.log(LogStatus.FAIL, "Failedto Locate the element : " + elemName);
			//Reporter.update_Report_step(fwt, "Select the " + elemName + " dropdown item as : " + dropdownitem , elemName + " dropdown should be selected as : " + dropdownitem, "Failed to Locate " + elemName + " dropdown", "FAIL");
		}
	}
	
	//select Check box
	public static void edit_check_box(VRWebElement element, String elemName, String onORoff) {
		
		if(element.verifyPresent()) {
			if(StringUtils.equals(onORoff, "ON")) {
				if(element.isSelected()) {
					//Reporter.update_Report_step(fwt, "Select the " + elemName + " checkbox", elemName + " checkbox should be selected.", elemName + " checkbox is selected successfully.", "PASS");
					log.info(elemName + " checkbox is already selected.");
					//test.log(LogStatus.PASS, elemName + " checkbox is already selected.");
				}else {
					element.click();
					log.info(elemName + " checkbox is selected.");
					//test.log(LogStatus.PASS, elemName + " checkbox is selected.");
					//Reporter.update_Report_step(fwt, "Select the " + elemName + " checkbox", elemName + " checkbox should be selected.", elemName + " checkbox is already selected.", "PASS");
				}
			}else if(StringUtils.equals(onORoff, "OFF")) {
				if(element.isSelected()) {
					element.click();
					//Reporter.update_Report_step(fwt, "Deselect the " + elemName + " checkbox", elemName + " checkbox should be deselected.", elemName + " checkbox is deselected successfully.", "PASS");
					log.info(elemName + " checkbox is unselected.");
					//test.log(LogStatus.PASS, elemName + " checkbox is unselected.");
					
				}else {
					//Reporter.update_Report_step(fwt, "Deselect the " + elemName + " checkbox", elemName + " checkbox should be deselected.", elemName + " checkbox is already deselected.", "PASS");
					log.info(elemName + " checkbox is already unselected.");
					//test.log(LogStatus.PASS, elemName + " checkbox is already unselected.");
				}
			}
		}else {
			log.error("Failed to locate the element : " + elemName);
			//test.log(LogStatus.FAIL, elemName + "Failed to locate the element : " + elemName);
			//Reporter.update_Report_step(fwt, "Select the " + elemName + " checkbox", elemName + " checkbox should be selected.", "Failed to Locate " + elemName + " checkbox.", "FAIL");
		}
		
	}
	
	//click element
	public static void click_element(VRWebElement element, String elemName){
		if(element.verifyPresent() && element.isEnabled()) {
			element.scrollToElement();
			element.click();
			//Reporter.update_Report_step(fwt, "Click on " + elemName, elemName + " should be clicked.", elemName + " clicked successfully.", "PASS");
			log.info("clicked on element : " + elemName);
			//test.log(LogStatus.PASS, "clicked on element : " + elemName);
		}else {
			log.error("Failed to locate the element : " + elemName);
			//test.log(LogStatus.FAIL, "Failed to locate the element : " + elemName);
			//Reporter.update_Report_step(fwt, "Click on " + elemName, elemName + " should be clicked.", "Failed to to Locate " + elemName , "FAIL");
		}
	}
	
	//Handle Alert
	public static boolean verifyAndHandleAlert(String expAlertMsg) {
		boolean result=false;
		String actAlertMsg="";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		actAlertMsg=alert.getText();
		if(!StringUtils.isNullOrEmpty(expAlertMsg)) {
			if(StringUtils.equals(expAlertMsg, actAlertMsg)) {
				//Reporter.update_Report_step(null, "verify Alert message", "Alert Message  should displayed as : " + expAlertMsg, "Alert Message is displayed as expected : " + expAlertMsg, "INFO");
				result = true;
			}else {
				//Reporter.update_Report_step(null, "verify Alert message", "Alert Message  should displayed as : " + expAlertMsg, "Alert Message is not displayed as expected : " + expAlertMsg, "WARN");
			}
		}
		
		alert.accept();
		Assert.assertEquals(result, true);
		return result;
		
		
	}
	
	//Verify Page title
	public static boolean  verifyPageTitle(String expTitle) {
		
		boolean result = false;
		String actTitle = driver.getTitle();
		result=StringUtils.equals(expTitle, actTitle);
		return result;
		
	}
	
}
