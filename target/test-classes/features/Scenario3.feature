#Author: mhaskar16@gmail.com
#Keywords Summary : Verify publish create new page functionality 

# -------------------------------------------------------------------------------------------------

Feature: Verify create new page functionality

#	Background: User is Logged In
#			
#			Given I am on login page
#			When I submit username and password
#			Then I should be logged in

	Scenario: To verify publish post functionality - Add expiry date

    	Given I Open pages menu
    	When I Search for page group - This Page Group
    	Then I land on This Page Group page
    	Then I click on edit menu
    	And  I click on Manage Pages link
    	And On Manage Pages I click on First page universal dropdown and select create subpage
    	When I add page title and click on create
    	Then A new sub page is created under First Page
			
# -------------------------------------------------------------------------------------------------