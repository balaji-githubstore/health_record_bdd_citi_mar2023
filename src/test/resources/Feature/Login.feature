@login
Feature: Login
  In order to manage the health records 
  As a user
  I want to access the OpenEMR portal

  @valid @high
  Scenario Outline: Valid Login
    Given I have browser with openemr page
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select language as '<language>'
    And I click on login
    Then I should get access to portal with title as 'OpenEMR'

    Examples: 
      | username   | password   | language         |
      | physician  | physician  | English (Indian) |
      | admin      | pass       | English (Indian) |
      | accountant | accountant | English (Indian) |

  @invalid
  Scenario: Invalid Login
    Given I have browser with openemr page
    When I enter username as 'john'
    And I enter password as 'john1234'
    And I select language as 'English (Indian)'
    And I click on login
    Then I should not get access portal with error as 'Invalid username or password'

    