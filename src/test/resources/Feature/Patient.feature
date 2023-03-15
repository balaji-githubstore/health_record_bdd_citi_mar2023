@patient
Feature: Patient
  In order to manage patient records 
  As an admin
  I would like to add,edit,delete patients details

  @addpatient
  Scenario Outline: Add Valid Patient
    Given I have browser with openemr page
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select language as '<language>'
    And I click on login
    And I click on patient menu
    And I click on new-search menu
    And I fill the patient record who
      | firstname | lastname | gender   | dob   |
      | <fname>   | <lname>  | <gender> | <dob> |
    And I click on create new patient
    And I click on confirm create new patient
    And I store the alert text and handle it
    And I close happy birthday popup if available
    Then the alert message should contatin '<expected_alert_text>'
    And I should get the added patient name '<expected_patient_name>'

    Examples: 
      | username | password | language         | fname | lname | gender | dob        | expected_alert_text | expected_patient_name |
      | admin    | pass     | English (Indian) | bala  | dina  | Male   | 2023-03-15 | Tobacco             | Bala Dina             |
      | admin    | pass     | English (Indian) | john  | wick  | Male   | 2023-03-14 | Tobacco             | John Wick             |
