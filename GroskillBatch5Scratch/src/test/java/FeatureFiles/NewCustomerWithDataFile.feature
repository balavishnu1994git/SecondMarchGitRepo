 @requiresLogin @createCustomer
Feature: Creation of new Customer

  #Background:
    #Given User open the Browser URL
    #And user enter the username as "mngr655016"
    #And user enter the password as "AsUvyna"
    #When user click on login button
    #Then Validate that user navigate to the home page of the application

  Scenario: Create new customer with all details using DataTable
    Given User is on the homepage of the application
    And User clicks on new customer link
    And User enters customer details
      | field      | value            |
      | cust_name  | vishnu           |
      | gender     | male             |
      | dob        | 1994-12-05       |
      | address    | Mgnagar          |
      | city       | Nagpure          |
      | state      | MH               |
      | pin        | 454545           |
      | mobile     | 9567785417       |
      | email      | vishnu68@g.com   |
      | password   | Vishnu@1234      |
    When click on submit button
    Then a new customer will be created Using Data Table
    And user captures the customer id
    
    