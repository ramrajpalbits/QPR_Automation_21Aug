
@AssignUnderwriter
Feature: Assign Underwriter and Underwriter Team

#    Then the "<completedStage>" stage should turn green  -- Generic method to validate status of Stage / Phase
  Background:
  	Given User login to Appian application as "CaseManager"
   Then User navigates to Home category

  Scenario Outline: Assign Underwriter and UW Team
  	When User opens a contract case "133573" from the Home tab
    And No Underwriter or UW Team is assigned 
    When User clicks on the ASSIGN UNDERWRITER action 
    And User selects Underwriting Team and Underwriter for "TC_001"
    Then the "<completedStage>" stage should turn green 
    And available actions should include:
      | UPFRONT ANALYSIS     |
      | ACTUARIAL ASSIGNMENT |
      | LEGAL ASSIGNMENT     |
      | REFUSE PROGRAM       |
    And the UW Team and Underwriter labels should display assigned values
 Examples:
      | completedStage              | nextStage           |
      | Program Filing / Preparation | Upfront Analysis     |
 #    | Upfront Analysis             | In-depth Analysis    |
 #    | In-depth Analysis            | Negotiation & Quotation |
 #    | Negotiation & Quotation      | |
 #    | Authorization / Refusal      |  |
      

    # search case id , summary webelements , stages webelements

    




