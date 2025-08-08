package com.big.stepdef;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.big.pageObjects.CommonObj;
import com.big.pageObjects.ContractCasePagePreparation_Actions;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.utils.Utilities;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class AssignUnderwriterToContractCase {
	Utilities ut = new Utilities();
	CommonObj co = new CommonObj();
	QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
	HomePage_Actions homeActionObj = new HomePage_Actions();
	ContractCasePagePreparation_Actions contractcasePreparationObj = new ContractCasePagePreparation_Actions();

	@When("User opens a contract case {string} from the Home tab")
	public void user_opens_a_contract_case_from_the_home_tab(String caseId) {
		homeActionObj.searchCaseNumber(caseId);
		homeActionObj.openContractCase(caseId);

	}

	@When("No Underwriter or UW Team is assigned")
	public void no_underwriter_or_uw_team_is_assigned() {

		System.out.println("Validate UnderWriter is Blank"+contractcasePreparationObj.isUnderwriterBlank());
		System.out.println("Validate UnderWriting Team is Blank"+contractcasePreparationObj.isUnderwritingTeamBlank());

		Assertions.assertTrue(contractcasePreparationObj.isUnderwriterBlank(), "Underwriter label should be blank or absent");
		Assertions.assertTrue(contractcasePreparationObj.isUnderwritingTeamBlank(), "Underwriting Team label should be blank or absent");


	}

	@When("User clicks on the ASSIGN UNDERWRITER action")
	public void user_clicks_on_the_action() {
		contractcasePreparationObj.assignUnderWriter();
	}

	@When("User selects Underwriting Team and Underwriter for {string}")
	public void user_selects_underwriting_data(String testCaseID) throws InterruptedException {

		String[] data = ut.getTestData("TestData.xlsx", "AssignUnderWriter", testCaseID);

		String team = data[0];

		String underwriter = data[1];

		contractcasePreparationObj.selectUnderwritingDetails(team, underwriter);
	}

	@Then("the {string} stage should turn green")
	public void the_stage_should_turn_green(String stageName) throws InterruptedException {


		Assertions.assertTrue(contractcasePreparationObj.isStageCompleted(stageName),
				"Expected stage '" + stageName + "' to be green, but it is not.");
	}

	@Then("available actions should include:")
	public void available_actions_should_include(List<String> expectedButtons) throws InterruptedException {
		Thread.sleep(5000);
		boolean result = contractcasePreparationObj.areActionButtonsPresent(expectedButtons);
		Assert.assertTrue("One or more expected action buttons are missing", result);
	}


	@Then("the UW Team and Underwriter labels should display assigned values")
	public void the_uw_team_and_underwriter_labels_should_display_assigned_values() {

		boolean isUWTeamBlank = contractcasePreparationObj.isUnderwritingTeamBlank();
		boolean isUnderwriterBlank = contractcasePreparationObj.isUnderwriterBlank();

		if (isUWTeamBlank || isUnderwriterBlank) {
			throw new AssertionError("❌ One or both values are blank: " +
					"\nUnderwriting Team blank? " + isUWTeamBlank +
					"\nUnderwriter blank? " + isUnderwriterBlank);
		}

		System.out.println("Both UW Team and Underwriter labels are populated.");
	}

}


