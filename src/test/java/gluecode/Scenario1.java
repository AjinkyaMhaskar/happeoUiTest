package gluecode;

import org.testng.Assert;
import cucumber.api.java.en.*;
import dataProviders.ConfigFileReader;
import pageObjects.*;
import runner.TestRunner;

public class Scenario1{
	
	loginPage loginPage = new loginPage();
	homePage homePage = new homePage();
	interviewChannelPage interviewChannelPage = new interviewChannelPage();
	
	@Given("^I am on login page$")
	public void i_am_on_login_page() throws Throwable {
		TestRunner.driver.get(ConfigFileReader.getBaseURL());
		//Click on sign-in with google button
		loginPage.clickSignInWithGoogle();
	}

	@When("^I submit username and password$")
	public void i_submit_username_and_password() throws Throwable {
		//Enter user email
		loginPage.enterUserEmail();
		//Click on next button
		loginPage.clickNextButton();
		//Enter user password
		loginPage.enterUserPassword();
		//Click on next button
		loginPage.clickNextButton();
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
		loginPage.waitForHomePageToLoad();
		//Assert Home page title - "Home | Happeo Staging"
		Assert.assertEquals(ConfigFileReader.getHomePageTitle(),runner.TestRunner.driver.getTitle());
	}
	
	@Given("^I Open Channels menu$")
	public void i_Open_Channels_menu() throws Throwable {
		homePage.clickChannelButton();
	}

	@When("^I Search for channel - Interview Channel$")
	public void i_Search_for_channel_Interview_Channel() throws Throwable {
		homePage.clickChannelSearchTextBoxAndEnterSearchText();
	}

	@And("^Navigate to the channel by clicking on the search result$")
	public void navigate_to_the_channel_by_clicking_on_the_search_result() throws Throwable {
		//homePage.clickFirstRowChannelSearchAfterSearch();
		homePage.clickFirstRowChannelSearchAfterSearch();
	}

	@Then("^I land on channel - Interview Channel$")
	public void i_land_on_channel_Interview_Channel() throws Throwable {
		// assert user is on Interview Channel
		Assert.assertEquals(ConfigFileReader.getInterviewChannelPageTitle(),runner.TestRunner.driver.getTitle());
	}

	@When("^Open a random post - View post$")
	public void open_a_random_post_View_post() throws Throwable {
		//select the post from user "Interview Account-1"
		interviewChannelPage.selectPost();
		// Open Post
		interviewChannelPage.openPost();
	}

	@And("^Add a random reaction from the default reactions list$")
	public void add_a_random_reaction_from_the_default_reactions_list() throws Throwable {
		// Add emoji 
		interviewChannelPage.addEmojiComment();
	}

	@Then("^The reaction is visible in post comments$")
	public void the_reaction_is_visible_in_post_comments() throws Throwable {
		//verify comment 
		interviewChannelPage.verifyEmojiComment();
	}

}
