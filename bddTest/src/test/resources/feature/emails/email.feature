Feature: Test All User Email APIs

  @reset_password
  Scenario: POST API to send Reset Password Mail
    Given User want to send Password Recovery Mail
    When User provide name 'Arpit'  and email 'arpitgoyal437@gmail.com'
    Then User verify the Response 201

  @add_new_customer
  Scenario: POST API to send New Customer Addition Mail
    Given User want to send New Customer Addition Mail
    When User provide the details 'Rohan'  and 'arpitgoyal437@gmail.com'
    Then User should receive the Response 201
  
  @signup
  Scenario: POST API to send Welcome Mail on Signup
    Given User want to send Welcome Mail on Signup
    When User provide the name and email address 'Mithlesh'  and 'arpitgoyal437@gmail.com'
    Then User should receive the message 'Eledger SignUp Mail has been sent.'