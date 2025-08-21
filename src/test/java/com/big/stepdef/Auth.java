package com.big.stepdef;

import com.big.pageObjects.Authorization;
import com.big.pageObjects.CommonObj;
import com.big.pageObjects.ContractCasePagePreparation_Actions;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import io.cucumber.java.en.*;

public class Auth {

	Utilities ut = new Utilities();
	CommonObj co = new CommonObj();
	QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
	HomePage_Actions homeActionObj = new HomePage_Actions();
	ContractCasePagePreparation_Actions contractcasePreparationObj = new ContractCasePagePreparation_Actions();
	Authorization at = new Authorization();
	TestReusables tr = new TestReusables();
	
	@When("User navigate to {string} paragraphtabs")
	public void user_navigate_to_paragraphtabs1(String string){
		co.user_navigate_to_paragraphtabs(string);
		System.out.println("Navigates to Auth tab");
	}
	
	@Then("User click on the Send Auth Email action")
	public void clickSendAuth(){
		at.sendauth();
	}
		
	@And("User able to see Authorization Email text")
	public void AuthEmailTextCompare(){
		at.verifyAuthEmailTitle();
	}
	
	@When("User select the recipient from the drop down")
	public void selectRecipientAuthEmail() {
		at.clickRecipientDropdown();	
	}
	
	@And("User select the {string} recipient from the list")
	public void selectRecipientFromList(String string) {
		
		at.selectRecipient(string);
	}
	
	@Then("User check the Acknowledge checkbox button")
	public void authAckCheckBox() {
		at.authacknowledgeCheckBox();
	}
	
	@And("User enter Wording Proposal {string} text")
	public void workingProposal(String string) {
		at.wordingProposalText(string);
	}
	
	@And("User check and click on Send Authorization Email button")
	public void checkAndClickSendAuthEmailButton() {
		at.visiblityAndClicksendAuthEmailButton();
	}
	
	@Then("User navigate to communication {string} tab")
	public void navigateCommunicationTab(String string ) throws InterruptedException {
		at.clickOnCummination(string);
	}
	
	@And("User validate authorization email {string} is sent")
	public void validateAuthEmailSend(String string) {
		at.ValidateEmailSendInCommunication(string);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
	@Then("User click on Update Signed Line button under action")
	public void clickonUpdateSingedLine() {
		at.clickUpdateSingedLineButton();
	}
	
	@And("User able to see update singed line pop up")
	public void verifySignedLinePopupTitle() {
		at.verifyUpdateLinePopupTitle();
	}
	
	@Then("User enter values for signed line for layer1 {string} and layer2 {string}")
	public void insertValuesSignedLine(String layer1, String layer2) {
		at.insertSignedlinesvalues(layer1, layer2);
	}
	
	@And("User click on submit button")
	public void signedValuesSubmit() {
		at.signedSubmit();
	}
	
	@Then("User navigate to Signed Lines and Signing Page tab")
	public void signedLineAndSigningPageTab() throws Throwable {
		at.clickonSingedLineandSingingPage();
	}
	
	@And("User verify the layer1 {string} and layer 2 {string} values in Signed line field")
	public void verifySignedLinevalues(String layer1, String layer2) {
		at.verifySingnedLinesValues(layer1, layer2);
	}
}



