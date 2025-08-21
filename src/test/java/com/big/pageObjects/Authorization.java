package com.big.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;


public class Authorization extends TestReusables {
	
	
	Utilities ut = new Utilities();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	CommonObj co = new CommonObj();

	public Authorization() {
		super();
	}
	
	@FindBy (xpath = "(//span[text() = 'Send Authorization Email'])[1]") 
	WebElement sendAuth ;
	
	@FindBy(xpath = "//span [text() = 'Authorization Email']")
	WebElement authTitle;
	
	@FindBy (xpath = "//span [@class = 'MultipleDropdownWidget---value_display']")
	WebElement authRecipient;
	
	@FindBy(xpath = "//label[@class = 'CheckboxGroup---choice_label']")
	WebElement authAcknowledgeCheckbox;
	
	@FindBy(xpath = "//button[@class = 'Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement sendAuthEmailbutton;
	
	@FindBy(xpath = "//ul[@role = 'listbox']/li")
	List<WebElement> allRecipients;
	
	@FindBy(xpath = "//span[text() = 'Please complete In Depth Analysis.']")
	WebElement hoverSendAuthEmail;
	
	@FindBy(xpath = "//textarea [@class = 'ParagraphWidget---textarea ParagraphWidget---align_start ParagraphWidget---height_medium ParagraphWidget---inModalDialogLayout']")
	WebElement wordingProposalTextArea;
	
	@FindBy(xpath = "//h1[@class = 'TitleText---page_header']")
	WebElement titletext;
	
	@FindBy(xpath = "//a[@class = 'LinkedItem---standalone_richtext_link elements---global_a']")
	List<WebElement> communicationRecods;
	
	public void sendauth(){
		click(sendAuth, "Send Authorization Email");
	}
	
	public void verifyAuthEmailTitle(){
		String actAuthTitle = authTitle.getText();
		System.out.println(actAuthTitle);				
		String expAuthTitle = "Authorization Email";
		assertTwoTexts(expAuthTitle, actAuthTitle);
		}
		
	public void clickRecipientDropdown() {
		click(authRecipient, "Recipient DropDown");
	}	
	
	public void selectRecipient(String recipientEmail) {
		for (WebElement RecipientEmail : allRecipients) {
			 System.out.println(RecipientEmail);
	            if (RecipientEmail.getText().equalsIgnoreCase(recipientEmail)) {
	            	System.out.println("RecipientEmail: "+ RecipientEmail.getText());
	            	click(RecipientEmail, "RecipientEmail"); 
	                break;  
	            }
		}
	}
	
	public void authacknowledgeCheckBox() {
		
		/// Assertion
		if(authAcknowledgeCheckbox.isSelected()) {		
			System.out.println("Acknowledge Checkbox is Checked");
		}
		else {
		System.out.println("Acknowledge checkbox is unchecked");
		}
	}
	
	public void wordingProposalText(String wordingText) {
		click(authAcknowledgeCheckbox, "Acknowledge CheckBox");
		System.out.println("Acknowledge Checkbox is checked");
		wordingProposalTextArea.clear();
		wordingProposalTextArea.sendKeys(wordingText);
		click(currencytext, "Currency text");
	}
	
	public void visiblityAndClicksendAuthEmailButton() {
		if( sendAuthEmailbutton.isEnabled()) {
			click(sendAuthEmailbutton, "Send Authorization Email");
			System.out.println("Clicked on Send Authorization Email Button");
		}
		else {
			String hoverText = hoverSendAuthEmail.getText();
			System.out.println(hoverText);
		}
	}
	
	public void clickOnCummination(String string) throws InterruptedException{
		Thread.sleep(5000);		
		if(titletext.isDisplayed()) {
			click(titletext, "Title text");
			co.user_navigate_to_casemenu(string);
			System.out.println("Title Text Element is displayed and clicked");
			}
				else {
			    System.out.println("Title Text Element is not enabled and cannot be clicked.");
			    Thread.sleep(5000);
			    co.user_navigate_to_casemenu(string);
			}
	}
	
	public void ValidateEmailSendInCommunication(String authemail) {
		for (WebElement authEmail : communicationRecods) {
	            if (authEmail.getText().contains(authemail)) {
	            	System.out.println("Authorization Email is sent");
	            	break;
	            }
	            else {
	            	System.out.println("Authorization Email is not send");
	            }
		}	
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "(//span[text() = 'Update Signed Lines'])[1]")
	WebElement updatesignedlinebutton;
	
	@FindBy(xpath = "//strong[text() = 'Signed Lines and Signing Page']")
	WebElement signedLinesandSigningPage;
	
	@FindBy(xpath = "//span[text() = 'Update Signed Lines - Property Cat XoL']")
	WebElement actUpdateLinetitle;
	
	@FindBy(xpath = "(//input [@class = 'TextInput---text TextInput---align_start TextInput---inEditableGridLayout'])[1]")
	WebElement layer1signedvalue;

	@FindBy(xpath = "(//input [@class ='TextInput---text TextInput---align_start TextInput---inEditableGridLayout'])[2]")
	WebElement layer2signedvalue;
	
	@FindBy(xpath = "(//strong [text() = 'Currency:'])[2]")
	WebElement currencytext;
	
	@FindBy(xpath = "//span[text()= 'Submit']")
	WebElement signedSubmitbutton;
	
	@FindBy(xpath = "(//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---center elements---global_p'])[7]")
	WebElement explayer1;
	
	@FindBy(xpath = "(//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---center elements---global_p'])[14]")
	WebElement explayer2;
	
	public void clickUpdateSingedLineButton() {
		
		click(updatesignedlinebutton, "Clicked on Update Singed Line");
	}
	
	public void verifyUpdateLinePopupTitle(){
		
		String actupdateLinetitle = actUpdateLinetitle.getText();
		System.out.println(actupdateLinetitle);				
		String expupdateLinetitle = "Update Signed Lines - Property Cat XoL";
		assertTwoTexts(expupdateLinetitle, actupdateLinetitle);
		}
	
	public void insertSignedlinesvalues(String layer1, String layer2 ) {
		
		layer2signedvalue.clear();
		System.out.println("Enter Values in Layer1" + layer2);
		layer2signedvalue.sendKeys(layer2);
		click(currencytext, "currency text");
		driver.switchTo().defaultContent();
		
		layer1signedvalue.clear();
		layer1signedvalue.sendKeys(layer1);
		System.out.println("Enter Values in Layer1" + layer1);
		driver.switchTo().activeElement();
	}
	
	public void signedSubmit() {
		click(signedSubmitbutton, "Signed Submit button");
	}
	
	public void clickonSingedLineandSingingPage() throws Throwable {
		Thread.sleep(5000);
		click(signedLinesandSigningPage, "Signed Lines and Signing Page");
	}

	public void verifySingnedLinesValues(String receivedactlayer1, String receivedactlayer2) {
		String explayer1value = explayer1.getText();
		String explayer2value = explayer2.getText();
		System.out.println(receivedactlayer1);
		System.out.println(receivedactlayer2);
		assertTwoTexts(explayer1value, receivedactlayer1);
		assertTwoTexts(explayer2value, receivedactlayer2);
	}
}	
	
