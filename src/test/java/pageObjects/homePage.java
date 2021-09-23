package pageObjects;

import org.openqa.selenium.By;

import commonFunctions.CommonUIFunctions;
import dataProviders.ConfigFileReader;
import junit.framework.Assert;
import runner.TestRunner;

public class homePage {

	//channel
	String channelButton = "//p[contains(text(),'Channels')]";
	String channelSearchTextBox = "//input[@id='nav-channels-search']";
	String firstRowChannelSearch = "//mark[contains(text(),'Interview Channel')]";
	String interviewChannelHeader = "//h1[contains(text(),'Interview Channel')]";
	//page
	String pagesButton = "//p[contains(text(),'Pages')]";
	String pagesSearchTextBox = "//input[@id='nav-pages-search']";
	String firstRowPageSearch = "//mark[contains(text(),'This Page Group')]";
	String thisPageGroupPageLink = "//a[@name='This Page Group']";
	//common
	String SearchBarHeader = "//body/navigation[1]/div[1]/div[2]/div[1]/div[1]/p[1]";
	
	//Click on channel button to open channel search drawer
	public void clickChannelButton() {
		TestRunner.driver.findElement(By.xpath(channelButton)).click();
		CommonUIFunctions.waitWithXpath(SearchBarHeader);
	}
	
	//Click channel search text box and enter "Interview Channel" text
	public void clickChannelSearchTextBoxAndEnterSearchText() {
		TestRunner.driver.findElement(By.xpath(channelSearchTextBox)).click();
		TestRunner.driver.findElement(By.xpath(channelSearchTextBox)).sendKeys(ConfigFileReader.getChannelSearchTerm());
	}
	
	//Click on first row after search channel
	public void clickFirstRowChannelSearchAfterSearch() {
		CommonUIFunctions.waitWithXpath(firstRowChannelSearch);
		TestRunner.driver.findElement(By.xpath(firstRowChannelSearch)).click();
		CommonUIFunctions.waitWithXpath(interviewChannelHeader);
	}
	
	//Click on pages button to open channel search drawer
		public void clickPagesButton() {
			TestRunner.driver.findElement(By.xpath(pagesButton)).click();
			CommonUIFunctions.waitWithXpath(SearchBarHeader);
		}
		
	//Click page search text box and enter "This Page Group" text
	public void clickPagesSearchTextBoxAndEnterSearchText() {
		TestRunner.driver.findElement(By.xpath(pagesSearchTextBox)).click();
		TestRunner.driver.findElement(By.xpath(pagesSearchTextBox)).sendKeys(ConfigFileReader.getPageSearchTerm());
		}
	
	//Click on first row after search page
	public void clickFirstRowPagesSearchAfterSearch() {
		CommonUIFunctions.waitWithXpath(firstRowPageSearch);
		TestRunner.driver.findElement(By.xpath(firstRowPageSearch)).click();
		}
	
	//Click on first row after search page
		public void verifyPageGroup() {
			CommonUIFunctions.waitWithXpath(thisPageGroupPageLink);
		}
}
