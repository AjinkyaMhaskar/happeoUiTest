#Author: mhaskar16@gmail.com
#Keywords Summary : Verify publish post functionality expiring on the date of September 21st, 2021 

# -------------------------------------------------------------------------------------------------

Feature: Verify publish post functionality

#	Background: User is Logged In
#			
#			Given I am on login page
#			When I submit username and password
#			Then I should be logged in
	
	Scenario: To verify publish post functionality - Add expiry date

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
    	And add a comment to the post
    	Then  I verify post and comment and delete the post
 
# -------------------------------------------------------------------------------------------------