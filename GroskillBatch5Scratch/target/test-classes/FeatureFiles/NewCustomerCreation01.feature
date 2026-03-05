
Feature: Creation of new Customer

  #Background: 
    #Given User open the Browser URL
    #And user enter the username as "mngr655016"
    #And user enter the password as "AsUvyna"
    #When user click on login button
    #Then Validate that user navigate to the home page of the application

  Scenario Outline: Create new customer with all details
    Given User is on the homepage of the application
    And User clicks on new customer link
    And User enter the customer name as "<cust_name>"
    And user select gender
    And User enter date of birth as "<dob>"
    And User enter adress as "<address>"
    And User enter city as "<city>"
    And User enter  state as "<state>"
    And User enter  pin as "<pin>"
    And User enter  mobile as "<mobile>"
    And User enter  email as "<email>"
    And User enter  password as "<password>"
    When click on submit button
    Then a new customer Will be created
    And user captures the customer id

    Examples: 
      | cust_name | dob        | address | city    | state | pin  | mobile     | email   | password |
      | vishnu    | 1994-12-05 | Mgnagar | Nagpure | MH    | 454545 | 9567785417 | vishnu68@g.com |Vishnu@1234 |

