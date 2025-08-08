package com.big.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class HomePage_Actions extends TestReusables {
	Utilities ut = new Utilities();

	public HomePage_Actions() {
		super();
	}


	@FindBy(xpath ="//a[@class='VirtualNavigationMenuTab_MERCURY_TOPBAR---nav_tab_clickable_container elements---global_a elements---inDarkBackground appian-context-ux-mouse-focus']//span[@class='VirtualNavigationMenuTab_MERCURY_TOPBAR---nav_label_text_wrapper'][normalize-space()='Home']")
	private  WebElement homeText;


	@FindBy(xpath = "//strong[normalize-space()='REINSURANCE']")
	private  WebElement reInsuranceText;

	@FindBy (xpath = "(//div[@class='PagingGridLayout---scrollable_content'])[1]//table//tbody//tr//td//div//p//a")
	private WebElement firstCaseNumber;

	@FindBy (xpath = "(//a[@aria-label=\"Next page\"])[1]")
	private WebElement nextUnassignedPagination;



	@FindBy(xpath ="//input[@class=\"TextInput---text TextInput---align_start TextInput---inSideBySideItem\"][1]")
	private  WebElement searchCaseForUnassignedPrograms;

	@FindBy(xpath="//button//span[text()=\"Search\"][1]")
	private WebElement searchButtonForCaseNumber;


	/** * Searches for a case number in the Unassigned Programs section.
	 * * @author Dhanesh Bhor
	 * @date August 6, 2025
	 */

	public void searchCaseNumber(String searchCaseID) {

		enterText(searchCaseForUnassignedPrograms, "caseNumber",searchCaseID);
		click(searchButtonForCaseNumber, searchCaseID); 
		System.out.println("Search Case Number");
	}





	public void verifyreInsuranceText() {
		verifyElement(reInsuranceText, "REINSURANCE");
		System.out.println("Verified text");
	}



	public void verifyHomeText() {

		verifyElementUntilLocated(homeText, "Home");
		System.out.println("Verified text");
	}

	/** * Opens a contract case from the Home tab using the provided case ID.
	 * 
	 * @author Dhanesh Bhor
	 * @date August 6, 2025
	 */

	public void openContractCase(String caseId) {
		WebElement caseNumber = driver.findElement(By.xpath("//a[text()='#" + caseId + "']"));
		click(caseNumber,"Contract Case");
	}



	/** * Selects the contract case number from the Home tab.
	 * * @author Dhanesh Bhor
	 * @date August 6, 2025
	 */

	public void SelectCaseNumber(String ID) throws InterruptedException {
		String caseNumberString =ut.getCellValue("CaseNumber",ID,"caseNumber");
		int caseNumber = Integer.parseInt(caseNumberString);
		System.out.println("using excel sheet "+caseNumber);
		WebElement caseID = driver.findElement(By.xpath("(//a[text()='"+caseNumber+"'])[1]"));
		clickUsingJS(caseID, "Case Number");
		Thread.sleep(4000);
		System.out.println("using excel sheet "+caseNumber);
	}




























}
