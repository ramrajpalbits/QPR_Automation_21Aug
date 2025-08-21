@Appianauth
Feature: User navigates to Authorization/Refusal page
	
	#pre
	
	Background:
  		Given User login to Appian application as "Ram"
   		Then User navigates to Home category

@SendandVerifyAuthorizationEmail @withAcknowledgecheckandWordingProposal

Scenario Outline: User navigates to Authorization/Refusal section and clicked on Send Authorization Email
And User opens a contract case "133603" from the Home tab
When User navigate to "<Menutab>" paragraphtabs
Then User click on the Send Auth Email action
And User able to see Authorization Email text
When User select the recipient from the drop down
And User select the "<Recipient Email>" recipient from the list
Then User check the Acknowledge checkbox button
And User enter Wording Proposal "<Wording Proposal>" text
And User check and click on Send Authorization Email button
Then User navigate to communication "<casetab>" tab
And User validate authorization email "<Emailtype>" is sent 


Examples:
| Menutab  |Recipient Email| Wording Proposal|casetab| Emailtype |
| Authorization / Refusal | mrunal.ketkar@bitsinglass.com |This is test Wording Proposal|Communication| Authorization |

##

@updatesigned @bothvalues
Scenario Outline: User navigate to Authorization/refusal tab and update signed line
And User opens a contract case "133595" from the Home tab
When User navigate to "<Menutab>" paragraphtabs
Then User click on Update Signed Line button under action
And User able to see update singed line pop up
Then User enter values for signed line for layer1 "<Signed Layer1 Value>" and layer2 "<Signed Layer2 Value>"
And User click on submit button
Then User navigate to Signed Lines and Signing Page tab
And User verify the layer1 "<Signed Layer1 Value>" and layer 2 "<Signed Layer2 Value>" values in Signed line field

Examples:

| Menutab  |Signed Layer1 Value|Signed Layer2 Value|
| Authorization / Refusal |L1|L2|