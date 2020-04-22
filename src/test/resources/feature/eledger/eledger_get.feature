# new feature
# Tags: optional

Feature: A Eledger api url
    
   Scenario: eledger api url test
    Given A Eledger api url
    When Eledger GET request api hit
    Then Response code should return '200' status code