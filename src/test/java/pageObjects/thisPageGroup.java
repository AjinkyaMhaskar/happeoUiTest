package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import commonFunctions.CommonUIFunctions;
import dataProviders.ConfigFileReader;
import runner.TestRunner;

public class thisPageGroup{
	
	//add new page
	String clickEditPageIcon = ".//div[@id='ngView']/page-view/div/ul/li[2]/a";
	String pageSettingTitle = ".//span[text()='Page settings']";
	String managePagesLink = ".//span[text()='Manage pages']";
	String managePagesTitle = ".//h2/span[text()='Manage pages']";
	String addPageButton = ".//span[text()='Add page']";
	String addNavigationItemPopUpWindowTitle = ".//span[text()='Add navigation item']";

	//find id for first page
	String firstPageText = ".//a[text()='First Page']";
	//String pageHerarchyFirstPageUniversalDropdownButton;
	String addSubPageMenuButton = ".//p[text()='Add subpage']";
	
	//create page
	// 3 dots beside first page
	String firstPageUniveralButton = ".//div[text()='First Page']/../universe-dropdown[1]";
	String pageNameTextBox = ".//input[@placeHolder='Page name']";
	String createPageButton = ".//span[text()='Create']";
	String createPageSettingTitle = ".//span[text()='Page settings']";
	//String pageDescriptionTextBox = ".//textarea[@placeholder='Enter page description']";
	String pageDescriptionTextBox = ".//span[text()='Description']/../../textarea";
	
	String savePage = ".//span[text()='Save']";
	String confirmPageSaved = ".//button[text()='OK']";
	String createdPageText;
	String pageTitleInPageHerarchy;
	
	//Verify & Delete page 
	//3 dots beside the page
	String pageUniversalDrowpownButton;
	String deletePage = ".//p[text()='Archive page']";
	String confirmDelete = ".//span[text()='Archive']";
	String exitPageButton = ".//button[text()='Exit edit']";
	String unPublishedButton = ".//span[text()='Unpublished']";
	String pageHeaderText;
	
	//Click edit page icon
	public void clickEditPageIcon() {
		try {
			CommonUIFunctions.moveToElementAndClickByXpath(clickEditPageIcon);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			CommonUIFunctions.moveToElementAndClickByXpath(clickEditPageIcon);
		}
		
		CommonUIFunctions.waitWithXpath(pageSettingTitle);
	}
	
	//Click manage pages link
	public void clickManagePages() {
		CommonUIFunctions.moveToElementAndClickByXpath(managePagesLink);
		CommonUIFunctions.waitWithXpath(managePagesTitle);
	}
	
	//find page id for the page from created page URL
	public String findPageId() {
		createdPageText = ".//a[@name='"+ConfigFileReader.getPageContent()+"']";
		String href = TestRunner.driver.findElement(By.xpath(createdPageText)).getAttribute("href");
		//System.out.println(href);
		String id = href.substring(31, 49);
		return id;
	}
	
	
	//On Manage Pages I click on First page universal dropdown and select create subpage
	public void clickUniversalDropdownForFirstPage() {
		
		//String pageHerarchyDivId = findPageId();
		//pageHerarchyFirstPageUniversalDropdownButton = ".//div[@id='"+pageHerarchyDivId+"']//div[text()='First Page']/../universe-dropdown[1]";
		
		
		CommonUIFunctions.moveToElementAndClickByXpath(firstPageUniveralButton);
		try {
			CommonUIFunctions.waitWithXpath(addSubPageMenuButton);
			CommonUIFunctions.moveToElementAndClickByXpath(addSubPageMenuButton);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			CommonUIFunctions.waitWithXpath(addSubPageMenuButton);
			CommonUIFunctions.moveToElementAndClickByXpath(addSubPageMenuButton);
		}
		CommonUIFunctions.waitWithXpath(addNavigationItemPopUpWindowTitle);
	}	
	
	//I add page details and click on create
	public void addPageDetailsAndCreatePage() {
		CommonUIFunctions.implicitWait(5000);
		CommonUIFunctions.moveToElementAndClickByXpath("//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/a[1]/translate[1]/span[1]");
		CommonUIFunctions.waitWithXpath(pageNameTextBox);
		//add page title
		CommonUIFunctions.moveToElementAndClickByXpath(pageNameTextBox);
		TestRunner.driver.findElement(By.xpath(pageNameTextBox)).sendKeys(ConfigFileReader.getPageContent());
		CommonUIFunctions.moveToElementAndClickByXpath(createPageButton);
		//driver.findElement(By.xpath(confirmPageSaved)).click();
		
		
		// add description
		
//		CommonUIFunctions.waitWithXpath(pageDescriptionTextBox);
//		CommonUIFunctions.moveToElementAndClickByXpath(pageDescriptionTextBox);
//		driver.findElement(By.xpath(pageDescriptionTextBox)).sendKeys(ConfigFileReader.getPageContent());
//		//save post
//		driver.findElement(By.xpath(savePage)).click();
//		//CommonUIFunctions.moveToElementAndClickByXpath(confirmPageSaved);
//		//click manage pages
//		CommonUIFunctions.moveToElementAndClickByXpath(managePagesLink);
//		CommonUIFunctions.waitWithXpath(managePagesTitle);
		
		
	}
	
	// confirm that a new page is created under First Page
	public void confimNewPageCreate() {
		
		pageHeaderText = ".//p[text()='"+ConfigFileReader.getPageContent()+"']";
		CommonUIFunctions.waitWithXpath(pageHeaderText);
		//System.out.println(TestRunner.driver.findElement(By.xpath(pageHeaderText)).getText());
		Assert.assertEquals(ConfigFileReader.getPageContent(), TestRunner.driver.findElement(By.xpath(pageHeaderText)).getText());		
	}
	
}
