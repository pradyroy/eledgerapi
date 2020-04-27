Feature: Test All Wallet Apis
	
	@post	
  Scenario: Wallet POST API to create new wallet
    Given I want to hit wallet POST api     
    When I provide the walletTransaction object 
    Then Response code should return 201 status code

	@tag1
  Scenario: Wallet GET API using lenderId
    Given I want to hit wallet GET API     
    When I provide the lenderId 'm12' 
    Then Response should return 200 status code
  
  @tag2
  Scenario: Wallet GET API using lenderId that not exist
    Given I want to call wallet GET API with lenderId     
    When I provide value of lenderId 'm13' 
    Then Api should return 404 status code
    
  @tag3
  Scenario: Wallet GET API using lenderId and borrowId
    Given I want to call wallet GET API with lenderId and borrowId    
    When I provide value of lenderId 'm12' and borrowId 'dd81ed0b-c28b-4203-acba-6bdf53ef5187' 
    Then Api should contain balance 500