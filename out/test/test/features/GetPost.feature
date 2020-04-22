Feature: 
  Verify different GET operations using REST-assured

  Scenario: Verify one user of the request
    Given: I perform GET operation for "/walletId"
    And: I perform GET for the walletId "23"
    Then: I should see the user balance as "2000"

