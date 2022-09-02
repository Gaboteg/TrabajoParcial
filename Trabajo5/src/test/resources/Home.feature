Feature: Login Sauce Demo
  Background: User login into Sauce Demo page
    Given Im in sauce demo web page

  Scenario: Homepage load an cart icon text increase with products
    Given I set the user name field with "standard_user"
    And I set the password field with "secret_sauce"
    When I click on login button
    Then The home page should be displayed

    Given I add the backpack product to the cart
    And I check the number "1" is displayed at the top of the cart


  Scenario: Filter low to high
    Given I set the user name field with "standard_user"
    And I set the password field with "secret_sauce"
    When I click on login button
    Then The home page should be displayed

    When I set the filter in "Price (low to high)"
    Then I check if the prices are correctly sorted


