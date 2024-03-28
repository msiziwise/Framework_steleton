@Regression
Feature: Purchase Item

  Scenario Outline: As a user i want to purchase an item
    Given I am on the login page
    And I enter username <username>
    And I enter password <password>
    When I click login button
    Then Home Page is Displayed
    And I click item backpack add to cart button
    Then Verify that item is added to card
    And I click cart
    Then Verify that I am on Cart Page
    And I click checkout button
#    Then Verify that information page is displayed
    And I enter First Name <firstName>
    And I enter Last Name <lastName>
    And I enter Zipcode <zipcode>
    And click continue button
    Then Verify that CheckoutOverview is displayed
    And VerifyItemTotalPlusTaxIsEqualTotal
#    And i close the browser


    Examples:
      | username      | password     | firstName     | lastName | zipcode |
      | standard_user | secret_sauce | Nkosingiphile | Cele     | 2094    |
#      | locked_out_user         | secret_sauce |
#      | problem_user            | secret_sauce |
#      | performance_glitch_user | secret_sauce |