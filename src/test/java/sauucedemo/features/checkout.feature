Feature: Checkout product

  @Regression @Positive
  Scenario: User can checkout and payment product
    Given user is on cart page
    When user tap checkout button
    And user input identity
    And user tap continue button
    And user tap finish button
    Then user is on checkout complete page

  @Regression @Negative
  Scenario: User can not checkout and payment product
    Given user is on cart page
    When user tap checkout button
    And user input identity without postal code

