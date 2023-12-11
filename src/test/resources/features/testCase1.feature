@automation
Feature: Register NEW User Feature Validation for  Automation Exercise WebSite

  Scenario: New User Registration
    When User verifies home page is visible before clicks on SightUp Login page
    And User validates User SignUp is visible then provides 'artur111' and 'artur111@gmail.com' and clicks SignUp
    And User verifies 'ENTER ACCOUNT INFORMATION' is visible
    And User fills 'Pass123' '1','11' ,'1993'
    And select Sign up for our newsletter and Receive special offers from our partners!
    And User fills all personal info  'artur1', 'arturTest1', 'IT-Company', '6622 ', 'West avenue', 'United States', 'IL', 'Chicago', '60601','773-999-8888'
    And User clicks Create Account button and verifies that 'ACCOUNT CREATED!'
    And User Click Continue button before Verify that Logged in as 'artur111' is visible
    And Click Delete Account button
    Then Verify that 'ACCOUNT DELETED!' is visible and click Continue button