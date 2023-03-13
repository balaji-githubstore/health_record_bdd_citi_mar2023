Feature: Login
  In order to manage the health records 
  As a user
  I want to access the OpenEMR portal

  Scenario: Valid Login
    Given I have browser with openemr page
    When I enter username as 'admin'
    And I enter password as 'pass'
    And I select language as 'English (Indian)'
    And I click on login
    Then I should get access to portal with title as 'OpenEMR'

  Scenario: Invalid Login
    Given I have browser with openemr page
    When I enter username as 'john'
    And I enter password as 'john123'
    And I select language as 'English (Indian)'
    And I click on login
    Then I should not get access portal with error as 'Invalid username or password'
