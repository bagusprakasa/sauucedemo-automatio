Feature: Logout Page Website Saucedemo

  @Regression @Positive
  Scenario: User logout from dashboard
    Given user already login to dashboard
    When user tap burger menu button
    And user tap logout button
    Then user is on login page