Feature: Testing response contains correct currencies

  Scenario: As a user I want to check virgin games bingo request and verify correct currencies
    When User sends a GET request to list endpoint
    Then User must get back a valid status code 200
    Then User verify the currency as GBP