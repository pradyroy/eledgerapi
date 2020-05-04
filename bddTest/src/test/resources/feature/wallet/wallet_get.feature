Feature: Test All Wallet Apis

  @wallet_post
  Scenario: Wallet POST API to create new wallet
    Given User wants to create a wallet
    When User provide the walletTransaction object
    Then Response code should return 201 status code

  @wallet_get_list
  Scenario: Wallet GET API to get list of wallets
    Given User wants to get list of wallets
    When User provide url for list 'wallets'
    Then Status code should be 200

  @wallet_get_lenderId
  Scenario: Wallet GET API using lenderId
    Given User wants to get wallet by using lenderId
    When User provide the lenderId 'm12'
    Then Response should return 200 status code

  @wallet_get_lenderId_not_eixst
  Scenario: Wallet GET API using lenderId that not exist
    Given User wants to get wallet by using lenderId that not exist
    When User provide value of lenderId 'm14'
    Then Api should return 404 status code

  @wallet_get_lenderId_borrowId
  Scenario: Wallet GET API using lenderId and borrowId
    Given User wants to get wallet by using lenderId and borrowerId
    When User provide value of lenderId 'm12' and borrowId '62335cfe-8fe0-4371-a338-5f69b370fa96'
    Then Api should contain balance 500

  @wallet_get_walletId
  Scenario: Wallet GET API using walletId
    Given User wants to get wallet by using walletId
    When User provide the walletId '111'
    Then Response should match lenderId 'm1'

  @wallet_delete_walletId
  Scenario: Delete Wallet using walletId
    Given User performs a POST Operations
    And User wants to delete created wallet by using walletId
    When User provide the walletId for DELETE API
    Then Response should return data 'OK'

  @wallet_get_walletId_not_existed
  Scenario: Wallet GET API using walletId that not exist
    Given User wants to get wallet by using walletId that not exist
    When User provide the not existed walletId '367'
    Then Response should match status code 404

  @wallet_delete_walletId_not_exist
  Scenario: Delete Wallet using walletId that not exist
    Given User wants to delete wallet by using walletId that not exist
    When User provide the not existed walletId '233' for DELETE API
    Then Response should return responseCode 'NOT_FOUND'
