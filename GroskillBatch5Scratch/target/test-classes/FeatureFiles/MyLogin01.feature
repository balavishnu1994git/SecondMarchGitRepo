
Feature: Login Functionality for Demon Guru99

  Scenario Outline: Validate Login Functionality
    Given User open the Browser URL
    And user enter the username as "<uname>"
    And user enter the password as "<password>"
    When user click on login button
    Then Validate that user navigate to the home page of the application

    Examples: 
      | uname      | password |
      | mngr655016 | AsUvyna  |
