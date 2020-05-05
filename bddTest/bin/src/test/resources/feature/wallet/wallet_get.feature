Feature: Test All Wallet Apis
	
	@wallet_post	
  Scenario: Wallet POST API to create new wallet
    Given I want to hit wallet POST api     
    When I provide the walletTransaction object 
    Then Response code should return 201 status code
	
	@wallet_get_lenderId
  Scenario: Wallet GET API using lenderId
    Given I want to hit wallet GET API     
    When I provide the lenderId 'm12' 
    Then Response should return 200 status code
  
  @wallet_get_lenderId_not_eixst
  Scenario: Wallet GET API using lenderId that not exist
    Given I want to call wallet GET API with lenderId     
    When I provide value of lenderId 'm14' 
    Then Api should return 404 status code
    
  @wallet_get_lenderId_borrowId
  Scenario: Wallet GET API using lenderId and borrowId
    Given I want to call wallet GET API with lenderId and borrowId    
    When I provide value of lenderId 'm12' and borrowId '62335cfe-8fe0-4371-a338-5f69b370fa96' 
    Then Api should contain balance 500
    
	@wallet_get_walletId
  Scenario: Wallet GET API using walletId
    Given I want to hit wallet GET API     
    When I provide the walletId '223' 
    Then Response should match lenderId 'm12' 
    
	@wallet_delete_walletId
  Scenario: Delete Wallet using walletId
    Given I want to hit wallet DELETE API     
    When I provide the walletId '223' for DELETE API
    Then Response should return data 'true'
     
  @wallet_get_walletId_after_delete_wallet
  Scenario: Wallet GET API after deleting the wallet
    Given I want to hit wallet GET API after delete api     
    When I provide the deleted walletId '223' 
    Then Response should match status code '404'
    
  @wallet_delete_walletId_not_exist
  Scenario: Delete Wallet using walletId that not exist
    Given I want to hit wallet DELETE API with walletId not existed in database    
    When I provide the not existed walletId '233' for DELETE API
    Then Response should return responseCode 'NOT_FOUND'
   
	@wallet_get_list
  Scenario: Wallet GET API to get list of wallets
    Given I want to hit wallet list GET API     
    When I provide url for list 'wallets'
    Then Status code should be 200