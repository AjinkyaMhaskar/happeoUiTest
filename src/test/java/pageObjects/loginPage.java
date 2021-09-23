package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import commonFunctions.CommonUIFunctions;
import dataProviders.ConfigFileReader;
import runner.TestRunner;

public class loginPage extends TestRunner {
	
	String signInWithGoogle = "//div[contains(text(),'Sign in with Google')]";
	String userEmail = "identifier";
	String userPassword = "password";
	String nextButton = "//span[contains(text(),'Next')]";
	
	
	public void enterUserEmail() {
		driver.findElement(By.name(userEmail)).sendKeys(ConfigFileReader.getUserEmail());
	}
	
	public void enterUserPassword() {
		driver.findElement(By.name(userPassword)).sendKeys(ConfigFileReader.getPassword());
	}
	
	public void clickSignInWithGoogle() {
		driver.findElement(By.xpath(signInWithGoogle)).click();
	}
	
	public void clickNextButton() {
		//Because java-script loaded the element one more time after we have referred
		try {
			driver.findElement(By.xpath(nextButton)).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			driver.findElement(By.xpath(nextButton)).click();
		}
	}
	
	public void waitForHomePageToLoad() {
		CommonUIFunctions.waitWithXpath("//body/navigation[1]/div[1]/div[1]/a[1]/img[1]");
	}
}
