package gluecode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.interviewChannelPage;

public class Scenario2 {
	
	interviewChannelPage interviewChannelPage = new interviewChannelPage();
	
	@When("^I click on write a post text box$")
	public void i_click_on_write_a_post_text_box() throws Throwable {
		interviewChannelPage.clickEnterTextBox();
	}

	@And("^I enter text for the post$")
	public void i_enter_text_for_the_post() throws Throwable {
		interviewChannelPage.enterTextForPost();
	}

	@When("^I click on Post Option text and select share as announcement$")
	public void i_click_on_Post_Option_text_and_select_share_as_announcement() throws Throwable {
		interviewChannelPage.clickPostOptionButton();
	}

	@And("^Enter announcment expiry as September (\\d+)st (\\d+)$")
	public void enter_announcment_expiry_as_September_st(int arg1, int arg2) throws Throwable {
		interviewChannelPage.enterAnnouncementExpiry();
	}

	@When("^I click on Share button and confirm the pop-up$")
	public void i_click_on_Share_button_and_confirm_the_pop_up() throws Throwable {
		interviewChannelPage.clickShareAndConfirm();
	}
	
	@Then("^The post is published with the expiry date$")
	public void the_post_is_published_with_the_expiry_date() throws Throwable {
		interviewChannelPage.getAnnouncementId();
		interviewChannelPage.selectPost();
		interviewChannelPage.openPost();
	}

	@Then("^add a comment to the post$")
	public void add_a_comment_to_the_post() throws Throwable {
		interviewChannelPage.addEmojiComment();
	}

	@Then("^I verify post and comment and delete the post$")
	public void i_verify_post_and_comment_and_delete_the_post() throws Throwable {
		interviewChannelPage.verifyEmojiComment();
		interviewChannelPage.verifyAddedPost();
		interviewChannelPage.deletePost();
	}
}
