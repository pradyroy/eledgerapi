Feature: Test All Relation User APIs

	@get_list_of_customer_users
  Scenario: User wants list of customer relational users
    Given User perform GET API for list of relation users
    When User provides the required lenderId 'Mah9414315028'
    Then User should have status code 200 and message 'success'
    
	@get_list_of_customers_users_not_exist
  Scenario: User wants list of customer relational users with lenderId not exist
    Given User perform GET API for list of customer relation users with id not exist
    When User provides the required lenderId that not exist 'Mah943150'
    Then User should see response with status code 404
    
	@get_list_of_report_users
  Scenario: User wants list of reports relational users
    Given User perform GET API for list of reports relation users
    When User provides the required lenderId 'Mah9414315028' for transaction API
    Then Response should have status code 200 with  message 'success'

    
	@get_list_of_reports_users_not_exist
  Scenario: User wants list of reports relational users with lenderId not exist
    Given User perform GET API for list of reports relation users with id not exist
    When User provides the required lenderId 'Mah9414350' that not exist for transaction api
    Then User should see message 'List not found for the given lender-ID'
    