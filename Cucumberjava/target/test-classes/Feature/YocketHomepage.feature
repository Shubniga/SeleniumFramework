#Author: Shubham N
#Date: 18 April 2022
#Description: Validate college finder module

Feature: Feature to test yocket college finder module

  Scenario: To validate yocket college finder module
    Given Oepn Yocket website
    And Select College Finder option
    And Select Masters on Unviversity College finder webpage
    Then User fills Step1 details and moves ahead
    And User fills step2 details and clicks next button
    #And User fills step3 details and proceeds further
    #And User fills step4 details and finds list of universities