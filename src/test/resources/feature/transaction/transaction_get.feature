Feature: Transaction GET Api

  Scenario: Get Transactions list
    Given I perform GET for transactions
    When I have url for 'transactions'
    Then Response status should be '200'

  Scenario: Get Transactions by lender Id
    Given I perform GET transaction by lender Id
    When I provide path 'lenderId' and lender Id 'm12'
    Then Response status is '200'

  Scenario: Get Transactions by lender Id and borrower Id
    Given I perform GET transaction by lender Id and borrower Id
    When I provide path 'lenderId' with 'm12' and 'borrowId' with '011b34aa-c0d6-4ede-99a2-ce1d6d7e196f'
    Then Response status code is '200'

  Scenario: Transaction List By lenderId and Date
    Given I want to test transaction GET Api
    When I provide lenderId 'm11' and Date '2020-04-22'
    Then I should see the response code '200'

  Scenario: Transaction List By lenderId, Start and End Date
    Given I want to test transaction GET Api by lenderId, Start and End Date
    When I provide lenderId 'm11' between Dates '2020-04-22' to '2020-04-26'
    Then I should have the response code '200'
