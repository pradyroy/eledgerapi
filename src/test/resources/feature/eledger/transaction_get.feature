Feature: Transaction GET Api

  Scenario: Transaction List By lenderId and Date
  
    Given I want to test transaction GET Api
    When I provide lenderId 'm11' and Date '2020-04-22'
    Then I should see the response code '200'
