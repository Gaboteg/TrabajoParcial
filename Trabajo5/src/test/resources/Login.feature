Feature: Login Sauce Demo
  Background: User login into Sauce Demo page
    Given Im in sauce demo web page

  Scenario: Login into Sauce Demo page with valid credentials
    Given I set the user name field with "standard_user"
    And I set the password field with "secret_sauce"
    When I click on login button
    Then The home page should be displayed

