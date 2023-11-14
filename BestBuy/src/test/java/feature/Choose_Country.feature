Feature: Choose a Country

  Background: 
    Given the user is on the BestBuy page

  Scenario: Choose a Country
    And the user clicks the country
    Then the user should be successfully step into HOMEPAGE
