Feature: Cart

  @Regression @Positive1
  Scenario: User can add product to cart
    Given user success login to dashboard
    When user tap add to cart
    And user tap shopping cart button
    Then user is on your cart page
