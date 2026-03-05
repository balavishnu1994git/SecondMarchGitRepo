 @requiresLogin @createAccount
Feature: New Account Creation

  #Background: 
    #Given User open the Browser URL
    #And user enter the username as "mngr655016"
    #And user enter the password as "AsUvyna"
    #When user click on login button
    #Then Validate that user navigate to the home page of the application

  Scenario: Create new account with customer id
    Given user open the New Account page
    And user fetch the customer id from excel
    And user Enter customer id
    And select  account type
    And user enter deposit amount
    When user click on submit button
    Then Amount updated
