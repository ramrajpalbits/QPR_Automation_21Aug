@qa
Feature: This feature file allow user to Search CaseNumber
  
  
Background:
		Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
  
 
@appianhome   
Scenario Outline: User navigates to Home tab 
    Given User selects the case "#133563" from the list
    And User navigate to "<CaseMenu>" CaseMenu tab
    When User navigate to "Program Filing / Preparation" paragraphtab
    And User selects "<PrograamType>" of case
 Examples:
 |CaseMenu|    PrograamType     |
 |Summary |    Construction Type|
 #|Documents|
 #|Communication|
 #|Notes|
      

    

    


