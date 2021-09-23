## happeo - application UI Test  
## Selenium WebDriver, BDD(Cucumber), POM, Java
## Tools:
- Eclipse
- Maven
- TestNG
- Selenium WebDriver
- Cucumber
- POM
- Java

## Maven dependencies: 
- Selenium WebDriver
- Cucumber
- TestNG
- Extent report

#### Application URLs:
>https://staging.unvrs.io/

## Features
* Crisp & Clear maven folder structures
* Extensive methods in CucumberRunner class
* CucumberOptions with a detailed explanation of using "tags", "glue"
* Page object model implementation
* Clean function library for better debugging & maintenance 
* Screenshots on failure feature in **CucumberRunner** class
* TestNG Annotations/hooks like "BeforeSuite", "AfterClass", "AfterMethod" etc.
* Descriptive pom.xml and testng.xml
* Examples with multiple features and step definition files
* Method to read data from the configuration properties file
* Methods for running tests in Chrome browsers

## BDD Style Development:
- Test Runner Main Class - src\test\java\runner
- Feature file - src\test\java\features
- Step Defination - src\test\java\gluecode
- Page Objects - src\test\java\pageObjects
- Common Functions - src\test\java\commonFunctions
- Read Configuration File - src\test\java\dataProviders
- Failure Screen-shots - target\screenshots
- Extent report - target\html\CustomExtentReport.html

## To Get Started

#### Pre-requisites
1. Java installed in the system
2. Maven installed in the system

#### Run Scripts
* Fork this repo, keep the folder the structure intact

```
Navigate to "src\test\java\runner\TestRunner.java", Right-click and Run As "1 TestNG Test"
```
* The scripts should run successfully in **Chrome** browser as it is defined in the **config.properties** file.
* Target folder should be created with cucumber-html-report.
* **test-output** folder should be created with the default testng reports

#### Writing Features
```
Feature: Verify channel post comment - post emoji

	Background: User is Logged In
			
			Given I am on the login page
			When I submit username and password
			Then I should be logged in
			
		    Given I Open Channels menu
```


#### Writing Step Definitions

```
@Given("^I am on login page$")
	public void i_am_on_login_page() throws Throwable {
		TestRunner.driver.get(ConfigFileReader.getBaseURL());
		//Click on sign-in with google button
		loginPage.clickSignInWithGoogle();
	}
```


#### Cucumber Options

```
 @CucumberOptions(
      strict = true, 
      monochrome = true, 
      features = "src/test/java/features", 
      glue = "gluecode", 
      plugin = {
            "com.cucumber.listener.ExtentCucumberFormatter:target/html/CustomExtentReport.html" 
                }
      )
```


#### Screenshot Hooks/Annotations

```
 @AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName() + "_"
					+ new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(
					System.getProperty("user.dir") + "/target/screenshots/" + failureImageFileName);
			FileUtils.copyFile(imageFile, failureImageFile);
		}
	}
```
#### Problem Statement 
![Alt text](https://github.com/AjinkyaMhaskar/happeoUiTest/blob/main/images/problemStatement.PNG)


#### HTML Reports
Default cucumber HTML reports are generated which can be customized according to specific needs
##### Success Cucumber & TestNg Reports


![Alt text](https://github.com/AjinkyaMhaskar/happeoUiTest/blob/main/images/report1.PNG)
![Alt text](https://github.com/AjinkyaMhaskar/happeoUiTest/blob/main/images/report2.PNG)
![Alt text](https://github.com/AjinkyaMhaskar/happeoUiTest/blob/main/images/report3.PNG)
