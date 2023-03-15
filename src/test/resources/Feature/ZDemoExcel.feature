@excel
Feature: AddPatient

  @demo1
  Scenario: Demo1
    #Given I have browser with openemr page
    #When I enter username as 'admin'
    #And I enter password as 'pass'
    #And I select language as 'English (Indian)'
    #And I click on login
    And I fill the record
      | city   | country |
      | CHN    | INDIA   |
      | BERLIN | GERMANY |
    Then I should verify the saved records 
    
  @demo2
  Scenario: Demo2
    #Given I have browser with openemr page
    #When I enter username as 'john'
    #And I enter password as 'john1234'
    #And I select language as 'English (Indian)'
    #And I click on login
    And I fill the record from excel 'testdata/openemr_data.xlsx' and sheet 'Demo2Data'
    Then I should verify the saved records
	  And I should verify the data in db with username 'user01' and password 'pass123' and "SELECT count(*) FROM company where age>25"
    