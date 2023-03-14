@patient
Feature: Patient
  In order to manage patient records 
  As an admin
  I would like to add,edit,delete patients details

	@addpatient
  Scenario: Add Valid Patient
    Given I have browser with openemr page
    When I enter username as 'admin'
    And I enter password as 'pass'
    And I select language as 'English (Indian)'
    And I click on login
    And I click on patient menu
    And I click on new-search menu
    And I fill the patient record
      | firstname | lastname | gender | dob        |
      | John      | Wick     | Male   | 2023-03-14 |
    And I click on create new patient
    And I click on confirm create new patient
    And I store the alert text and handle it
    And I close happy birthday popup if available
    Then the alert message should contatin 'Tobacco'
    And I should get the added patient name 'John Wick'
    
    
    
   
