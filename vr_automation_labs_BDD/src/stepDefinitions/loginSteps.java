package stepDefinitions;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.app.libs.common.CommonUtils;
import com.app.libs.web.test_base;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginSteps extends test_base{
	
	HomePage homepage;
	LoginPage loginpage;
	
	@Given("^Launch CRM Application$")
	public void launch_CRM_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		homepage = new HomePage();
		loginpage = new LoginPage();
	    homepage.launchCRM();
	}

	@When("^CRM Home page is Loaded$")
	public void crm_Home_page_is_Loaded() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    homepage.verifyHomePageTitle("#1 Free CRM customer relationship management software cloud");
	}

	@Then("^Enter \"(.*)\" and \"(.*)\" and click on Login$")
	public void enter_UserName_and_Password_and_click_on_Login(String username,String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    homepage.clickLogin();
	    loginpage.LoginToCRM(username, password);
	}
	
	@Given("^GetTestData$")
	public void gettestdata(DataTable dt) throws Throwable {
	    List<Map<String,String>> odata = dt.asMaps(String.class, String.class);
	    readTestdata(odata.get(0).get("SheetName").toString(), odata.get(0).get("Keyname").toString());
	}
	
	@Then("^Enter Username and Password and click on Login (\\d+)$")
	public void enter_Username_and_Password_and_click_on_Login(int ind) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 String username = testData.get(ind-1).get("UserName").toString();
		 String password = testData.get(ind-1).get("Password").toString();
		 
		 homepage.clickLogin();
		 loginpage.LoginToCRM(username, password);
	}
		
	
}
