Feature: Falabella Page

  Scenario: buy products
    Given user enters falabella site
    And user select category
    When user select three products
    Then user sees the total value of his purchase
