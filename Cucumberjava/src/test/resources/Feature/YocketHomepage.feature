#Author: Shubham N
#Date: 17 April 2022
#Description: Test college finder module

Feature: Feature to test yocket homepage

  Scenario: Validate yocket college finder page
    Given browser is open
    And user is google search page
    When user enters yocket.com as search text
    And hits enter
    Then user is navigated on google search results
    And user selects University College Finder