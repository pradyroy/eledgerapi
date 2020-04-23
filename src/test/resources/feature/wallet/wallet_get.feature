Feature: Wallet Apis

  Scenario: Wallet POST API to create new wallet
    Given I want to hit wallet POST api     
    When I provide the walletTransaction object 
    Then Response code should return '200' status code
