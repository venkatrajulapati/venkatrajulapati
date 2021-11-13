package stepDefinitions;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.app.libs.common.CommonUtils;
import com.app.libs.web.test_base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends test_base {
	
	@Before
	public static void initialize(Scenario scenario) {
		tcname = scenario.getName();
		//test = report.startTest(tcname);
		log= Logger.getLogger(tcname);
		
		log.info("Initiate Webdriver .......");
		
		try {
			prop = CommonUtils.get_propertyFileData("./config/application.properties");
			if(prop.getProperty("environment").equalsIgnoreCase("qa")) {
				envProp = CommonUtils.get_propertyFileData("./resources/qa/env.properties");
			   
			}else if(prop.getProperty("environment").equalsIgnoreCase("dev")) {
				envProp = CommonUtils.get_propertyFileData("./resources/dev/env.properties");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./server/chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.setPageLoadStrategy(PageLoadStrategy.NONE);
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("--ignore-urlfetcher-cert-requests");
			//options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//return driver;
	}
	
	@After
	public void cleanup() {
		driver.quit();
		//report.endTest(test);
		//report.flush();
	}

}
