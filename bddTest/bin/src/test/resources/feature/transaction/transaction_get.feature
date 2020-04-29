Feature: Test All Transaction Apis

  @transaction_get_list
  Scenario: Get Transactions list
    Given I perform GET for transactions
    When I have url for 'transactions'
    Then Response status should be '200'

  @transaction_get_lenderId
  Scenario: Get Transactions by lender Id
    Given I perform GET transaction by lender Id
    When I provide path 'lenderId' and lender Id 'm12'
    Then Response status is '200'

  @transaction_get_non_existing_lenderId
  Scenario: Get Transactions by non existing lender Id
    Given I perform GET transaction by non existing lender Id
    When I provide path 'lenderId' and non existing lender Id 'A123'
    Then Not Found status should match '404'

  @transaction_get_lenderId_borrowerId
  Scenario: Get Transactions by lender Id and borrower Id
    Given I perform GET transaction by lender Id and borrower Id
    When I provide path 'lenderId' with 'm12' and 'borrowId' with '9e354da0-4d33-4922-8b85-4d84c9c7b41f'
    Then Response status code is '200'

  @transaction_get_non_existing_lenderId_or_borrowerId
  Scenario: Get Transactions by non existing lender Id or borrowerId
    Given I perform GET transaction by non_existing lender Id or borrowerId
    When I provide path 'lenderId' with 'm12' and wrong 'borrowId' with 'm1231'
    Then Not Found status matches '404'

  @transaction_get_lenderId_date
  Scenario: Transaction List By lenderId and Date
    Given I want to test transaction GET Api
    When I provide lenderId 'm11' and Date '2020-04-22'
    Then I should see the response code '200'

  @transaction_get_lenderId_startDate_endDate
  Scenario: Transaction List By lenderId, Start and End Date
    Given I want to test transaction GET Api by lenderId, Start and End Date
    When I provide lenderId 'm11' between Dates '2020-04-22' to '2020-04-26'
    Then I should have the response code '200'
