package gluecode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.homePage;
import pageObjects.thisPageGroup;

public class Scenario3 {
	
	homePage homePage = new homePage();
	thisPageGroup thisPageGroup = new thisPageGroup();

	@Given("^I Open pages menu$")
	public void i_Open_pages_menu() throws Throwable {
		homePage.clickPagesButton();
	}

	@When("^I Search for page group - This Page Group$")
	public void i_Search_for_page_group_This_Page_Group() throws Throwable {
		homePage.clickPagesSearchTextBoxAndEnterSearchText();
		homePage.clickFirstRowPagesSearchAfterSearch();
	}

	@Then("^I land on This Page Group page$")
	public void i_land_on_This_Page_Group_page() throws Throwable {
		homePage.verifyPageGroup();
	}

	@Then("^I click on edit menu$")
	public void i_click_on_edit_menu() throws Throwable {
		thisPageGroup.clickEditPageIcon();
	}

	@And("^I click on Manage Pages link$")
	public void i_click_on_Manage_Pages_link() throws Throwable {
		thisPageGroup.clickManagePages();
	}

	@And("^On Manage Pages I click on First page universal dropdown and select create subpage$")
	public void on_Manage_Pages_I_click_on_First_page_universal_dropdown_and_select_create_subpage() throws Throwable {
		thisPageGroup.clickUniversalDropdownForFirstPage();
	}

	@When("^I add page title and click on create$")
	public void i_add_page_title_and_click_on_create() throws Throwable {
		thisPageGroup.addPageDetailsAndCreatePage();
	}

	@Then("^A new sub page is created under First Page$")
	public void a_new_sub_page_is_created_under_First_Page() throws Throwable {
		thisPageGroup.confimNewPageCreate();
	}			
}
