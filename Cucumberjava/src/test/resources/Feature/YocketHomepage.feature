#Author: Shubham N
#Date: 17 April 2022
#Description: Validate college finder module

Feature: Feature to test yocket homepage

  Scenario: To validate yocket college finder page
    Given browser is open
    And user is google search page
    When user enters yocket.com as search text
    And hits enter
    Then user is navigated on google search results
    And user selects University College Finder
    
Feature: To check if user proceeds further selecting Masters from University College Finder page
	
	Scenario: Validate user selects masters
		Given user is on College University Finder page
		And user clicks on Masters button
		Then user is nvaigated to Dream education page
		
		
