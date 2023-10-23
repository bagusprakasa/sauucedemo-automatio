Feature: Login Page Website Saucedemo

  @Regression @Possitive
  Scenario: User login with valid username and password
    Given user launch the website saucedemo
    When user input valid username
    And user input valid password
    And user tap login button
    Then user is on dashboard page

  @Regression @Negative
  Scenario: User login with invalid username and password
    Given user launch the website saucedemo
    When user input valid username
    And user input invalid password
    And user tap login button
    Then user get error message