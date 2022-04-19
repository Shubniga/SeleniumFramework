#Author: Shubham N
#Date: 18 April 2022
#Description: Validate college finder module

Feature: Feature to test yocket college finder module

  Scenario: To validate yocket college finder module
    Given User is google search page
    And User enters yocket.com as search text hits enter
    Then user is navigated on google search results
    And user selects University College Finder
    Then User selects Masters option
    And User fills step1 details and moves ahead
    Then User is navigated to step2
    And User fills step2 details and moves ahead
    Then User is navigated to step3 and moves ahead
    And User fills step3 details and moves ahead
    Then User is navigated to Step4
    And User fills step4 details and finds list of universities