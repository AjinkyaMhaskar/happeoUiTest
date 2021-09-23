#Author: mhaskar16@gmail.com
#Keywords Summary : Verify channel post

# -------------------------------------------------------------------------------------------------

Feature: Verify channel post comment - post emoji

	Background: User is Logged In
			
			Given I am on login page
			When I submit username and password
			Then I should be logged in
			
		  Given I Open Channels menu
    	When I Search for channel - Interview Channel
    	And Navigate to the channel by clicking on the search result
    	Then I land on channel - Interview Channel
    	When I click on write a post text box
    	And I enter text for the post
    	When I click on Post Option text and select share as announcement
    	And Enter announcment expiry as September 21st 2021
    	When I click on Share button and confirm the pop-up	
    	Then The post is published with the expiry date	
	
  Scenario: To verify if emoji is posted correctly in channel post

    	And Add a random reaction from the default reactions list
    	Then The reaction is visible in post comments
			Then  I verify post and comment and delete the post
			
# -------------------------------------------------------------------------------------------------