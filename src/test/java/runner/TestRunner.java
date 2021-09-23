package runner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.runtime.io.Helpers;
import dataProviders.*;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/features", glue = "gluecode", plugin = {
"com.cucumber.listener.ExtentCucumberFormatter:target/html/CustomExtentReport.html" })

public class TestRunner extends AbstractTestNGCucumberTests {

	public static WebDriver driver = null;

	@BeforeSuite(alwaysRun = true)
	public void initSetup() throws Exception {
		// Property file
		initPropertyData();

		// Browser
		initBrowser();
	}

	@AfterSuite(alwaysRun = true)
	public void closeBrowser() {
		 if (driver != null) {
		        driver.quit();
		        }
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Ajinkya Mhaskar - mhaskar16@gmail.com");
	}

	// Method for screen shot of failed methods
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName() + "_"
					+ new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(
					System.getProperty("user.dir") + "/target/screenshots/" + failureImageFileName);
			FileUtils.copyFile(imageFile, failureImageFile);
		}
	}

	// Method to generate extent report
	@AfterClass
	public static void setup() throws Exception {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", "Ajinkya Mhaskar");
		Reporter.setSystemInfo("Application Name", "Happeo - UI Test");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	}

	// Method to instantiate ConfigFileReader
	@SuppressWarnings("unused")
	public void initPropertyData() throws Exception {		
		ConfigFileReader ConfigFileReader = new ConfigFileReader();
	}

	public void initBrowser() throws Exception {
		// Local run
		if (ConfigFileReader.getBROWSER().equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			driver = new org.openqa.selenium.firefox.FirefoxDriver();
		} else if (ConfigFileReader.getBROWSER().equals("Chrome")) {
			//Create a map to store  preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();

			//add key and value to map as follow to switch off browser notification
			//Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);

			//Create an instance of ChromeOptions 
			ChromeOptions options = new ChromeOptions();

			// set ExperimentalOption - prefs 
			options.setExperimentalOption("prefs", prefs);
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver(options);
			
		}
		TestRunner.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		
	}
}
