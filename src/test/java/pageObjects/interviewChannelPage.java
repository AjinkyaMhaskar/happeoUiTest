package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import commonFunctions.CommonUIFunctions;
import dataProviders.ConfigFileReader;
import runner.TestRunner;

public class interviewChannelPage extends TestRunner {

	// post related xpath
	String writePost = ".//div[@class='fr-element fr-view']/p";
	//String postId_1 = "//div[@id='post-72310315']";
	String postTextToolBar = ".//div[@class='sc-cxZfpC jVOxFC']//div[@class='sc-fVHxE ZAWGf']/div/div/div[1]/div[2]";
	String postOptionButton = "//p[contains(text(),'Post options')]";
	String postText = "//p[contains(text(),'Test Post #test_post')]";
	
	//Share as announcement
	String shareAsAnnouncementSelectOption = "//p[contains(text(),'Share as announcement')]";
	String shareAsAnnouncementPopUpHeader = ".//h2[text()='Share as announcement']"; 
	String announcementExpiryDateTextBox = ".//div[text()='2 weeks']";
	String chooseDateDDMenu = "div[@class='dropdown__menu css-26l3qy-menu']/div[@class='dropdown__menu-list css-1rn5wsm']";
	String chooseCustomDateOptionFromDD = ".//div[@class='Modal__ModalWrapper-sc-1u0vesa-1 DMcBA']//div[@class='dropdown__control dropdown__control--is-focused dropdown__control--menu-is-open css-1pahdxg-control']//following::div[@class='dropdown__control dropdown__control--is-focused dropdown__control--menu-is-open css-1pahdxg-control']//following::div[text()='Choose custom date']";
	String dateInput = ".//div[@class='DayPickerInput']/div/input";
	String date = ".//div[text()='21']";
	String shareButton = ".//p[text()='Share']";
	String cancelButton = ".//p[text()='Cancel']";
		
	//String accountUserNameOnPost_1 = ".//div[@id='post-72310315']/div[1]/div/div[2]/div[1]/div/p";
	String interviewChannelHeader = "//h1[contains(text(),'Interview Channel')]";
	
	//emoji button in comment text-box
	//String emojiButton = ".//div[@class='sc-bLJvFH eTVKro']/div[1]/span[1]/button[@id='emojiTetherButton']";
	String emojiButton = "//body/div[@id='ngView']/channel[1]/div[1]/div[3]/channel-discussion[1]/div[1]/div[1]/div[1]/post[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]/button[1]/*[1]";
	
	//add comment on view post
	String addCommentTextBox = ".//span[text()='Write a comment...']";
	String addCommentButton = "//body/div[@id='ngView']/channel[1]/div[1]/div[3]/channel-discussion[1]/div[1]/div[1]/div[1]/post[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/button[2]/*[1]";
	
	//first emoji from frequently searched 
	//String firstEmojiFrequentlySearched = ".//div[@xpath='1']/section/div[2]/section[2]/ul[1]/li[1]";
	String firstEmojiFrequentlySearched = "//ul[@class='emoji-mart-category-list']/li[1]/button";
	
	String frequentlyUsedText = "//span[contains(text(),'Frequently Used')]";
	
	
	
	//Post related dynamic xpaths
	String getPostId;
	String postById;
	//3 dot button
	String viewPostWithId;
		
	//View post from un-ordered list ul
	String viewPostFromList;
	String accountUserNameOnPost;	
	String deletePostFromList;
	
	//verify post
	String itsAnnouncement = ".//p[text()='Announcement']";
	String expiryDate = ".//p[text()='Announcement']/following-sibling::p";

	
	//Click enter text test-box
		public void clickEnterTextBox() {
			CommonUIFunctions.waitWithXpath(interviewChannelHeader);
			CommonUIFunctions.implicitWait(5000);
			//CommonUIFunctions.moveToElementAndClickByXpath(writePost);
			try {
				CommonUIFunctions.moveToElementAndClickByXpath(writePost);
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				CommonUIFunctions.moveToElementAndClickByXpath(writePost);
			}
		}
	
	//enter text for post
		public void enterTextForPost() {
			driver.findElement(By.xpath(writePost)).sendKeys(ConfigFileReader.getChannelPostText());
		}	
		
	// click post option button
		public void clickPostOptionButton() {
			CommonUIFunctions.scrollDownOneinch();
			driver.findElement(By.xpath(postOptionButton)).click();
			CommonUIFunctions.scrollDownOneinch();
			CommonUIFunctions.scrollDownOneinch();
			driver.findElement(By.xpath(shareAsAnnouncementSelectOption)).click();
			CommonUIFunctions.waitWithXpath(shareAsAnnouncementPopUpHeader);
		}
	
	// enter announcement expiry
		public void enterAnnouncementExpiry(){
			CommonUIFunctions.implicitWait(5000);
			
			//Because java-script loaded the element one more time after we have referred
			try {
				CommonUIFunctions.waitWithXpath(announcementExpiryDateTextBox);
				CommonUIFunctions.moveToElementAndClickByXpath(announcementExpiryDateTextBox);
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				CommonUIFunctions.moveToElementAndClickByXpath(announcementExpiryDateTextBox);
			}
			
			CommonUIFunctions.pressDownKey();
			CommonUIFunctions.pressDownKey();
			CommonUIFunctions.pressDownKey();
			CommonUIFunctions.pressDownKey();
			CommonUIFunctions.pressEnterKey();	
			CommonUIFunctions.implicitWait(5000);
			
			CommonUIFunctions.moveToElementAndClickByXpath(dateInput);
			driver.findElement(By.xpath(dateInput)).click();
			
			CommonUIFunctions.scrollDownOneinch();
			CommonUIFunctions.scrollDownOneinch();
			
			CommonUIFunctions.waitWithXpath(cancelButton);
		}
		
	//Click on share button and cofirm 
		public void clickShareAndConfirm() {
			CommonUIFunctions.moveToElementAndClickByXpath(date);
			driver.findElement(By.xpath(shareButton)).click();
			driver.findElement(By.xpath(shareButton)).click();
		}
	
	// refresh page after announcement created and get announcement id
		public void getAnnouncementId() {
			CommonUIFunctions.refreshPage();
			
			
			CommonUIFunctions.implicitWait(5000);
			CommonUIFunctions.acceptAlert();
			
			CommonUIFunctions.implicitWait(5000);
			CommonUIFunctions.scrollToElementByXpath(postText);
			String getPostId;			
			getPostId = driver.findElement(By.xpath(".//p[text()='Test Post #test_post']/../../../../..")).getAttribute("id");
			//System.out.println(getPostId);
			CommonUIFunctions.implicitWait(5000);
			postById = "//div[@id='"+getPostId+"']";
			//3 dot button
			viewPostWithId = ".//div[@id='"+getPostId+"']/div[1]/div/div[3]/div[2]/button/div/span/div";
				
			//View post from un-ordered list ul
			viewPostFromList = ".//div[@id='"+getPostId+"']/div/div/div[3]/div[2]/ul/li[4]";
			accountUserNameOnPost = ".//div[@id='"+getPostId+"']/div[1]/div/div[2]/div[1]/div/p";
			deletePostFromList = ".//div[@id='"+getPostId+"']/div/div/div[3]/div[2]/ul/li[8]";
		}
		
	//Select a random post
		public void selectPost() throws InterruptedException {
			CommonUIFunctions.scrollToElementByXpath(postById);
			CommonUIFunctions.moveToElementAndClickByXpath(accountUserNameOnPost);
			CommonUIFunctions.waitWithXpath(accountUserNameOnPost);
			CommonUIFunctions.scrollUpOneinch();
			CommonUIFunctions.waitWithXpath(viewPostWithId);
			driver.findElement(By.xpath(viewPostWithId)).click();
			//System.out.println("Select Post");
		}
		
	//Select a random post
		public void openPost() throws InterruptedException {
			CommonUIFunctions.waitWithXpath(viewPostFromList);
			driver.findElement(By.xpath(viewPostFromList)).click();
			CommonUIFunctions.waitWithXpath(interviewChannelHeader);
			//System.out.println("On Post page");
		}	
		
	//Add emoji comment to the post
		public void addEmojiComment() throws InterruptedException {
			
			driver.findElement(By.xpath(emojiButton)).click();
			CommonUIFunctions.waitWithXpath(frequentlyUsedText);
			driver.findElement(By.xpath(firstEmojiFrequentlySearched)).click();
			CommonUIFunctions.scrollDownOneinch();
			driver.findElement(By.xpath(addCommentButton)).click();
			
			//System.out.println("emoji added");
		}
		
	//Verify the emoji comment
		public void verifyEmojiComment() throws InterruptedException {
			
			//String commentAddedby = ".//div[@class='sc-ZUflv dsUMiB']/div/div[2]/div/div[@class='sc-eHgmQL gmKbQu']/p";
			String commentAddedby = "//body/div[@id='ngView']/channel[1]/div[1]/div[3]/channel-discussion[1]/div[1]/div[1]/div[1]/post[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]";
			//String commentAddedby = "//p[@class='src__TextZeta-sc-4zr4wi-6 sc-cAJUJo bJsKti' and text()='Interview Account-1']";
			CommonUIFunctions.moveToElementAndClickByXpath(commentAddedby);
			//System.out.println(driver.findElement(By.xpath(commentAddedby)).getText());
			Assert.assertEquals(ConfigFileReader.getCommentAddedBy(),driver.findElement(By.xpath(commentAddedby)).getText());
			
			//String emojiComment = ".//div[@class='sc-ZUflv dsUMiB']/div/div[2]/div/div[@class='sc-gYtlsd btjelD']/div/*[1]";
			String emojiComment = "//p[contains(text(),'👍')]";
			CommonUIFunctions.moveToElementAndClickByXpath(commentAddedby);
			//System.out.println(driver.findElement(By.xpath(emojiComment)).isDisplayed());
			Assert.assertEquals(true,driver.findElement(By.xpath(emojiComment)).isDisplayed());
		}
		
	// to verify added announcement from the view post page
		public void verifyAddedPost() {
			
			String expireText = driver.findElement(By.xpath(expiryDate)).getText();
			
			Assert.assertEquals(expireText.contains("Expired"), true);
			
			Assert.assertEquals(ConfigFileReader.getAnnouncement(),driver.findElement(By.xpath(itsAnnouncement)).getText());
			Assert.assertEquals(ConfigFileReader.getChannelPostText(),driver.findElement(By.xpath(postText)).getText());
		}
		
	// to delete post from the view post page
		public void deletePost() {
			CommonUIFunctions.waitWithXpath(viewPostWithId);
			driver.findElement(By.xpath(viewPostWithId)).click();
			
			CommonUIFunctions.scrollDownOneinch();
			
			CommonUIFunctions.waitWithXpath(deletePostFromList);
			CommonUIFunctions.moveToElementAndClickByXpath(deletePostFromList);
			driver.findElement(By.xpath(".//p[text()='Ok']")).click();
		}
}
