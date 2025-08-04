package com.big.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class QPRLogin_Actions extends TestReusables {
	Utilities ut = new Utilities();

	public QPRLogin_Actions() {
		super();
	}

	
	 @FindBy(xpath ="//a[@class='VirtualNavigationMenuTab_MERCURY_TOPBAR---nav_tab_clickable_container elements---global_a elements---inDarkBackground appian-context-ux-mouse-focus']//span[@class='VirtualNavigationMenuTab_MERCURY_TOPBAR---nav_label_text_wrapper'][normalize-space()='Home']")
	 private  WebElement homeText;


	@FindBy(xpath = "//strong[normalize-space()='REINSURANCE']")
	private  WebElement reInsuranceText;

	public void verifyreInsuranceText() {
		verifyElement(reInsuranceText, "REINSURANCE");
		System.out.println("Verified text");
	}

	public void verifyHomeText() {
		 
		verifyElementUntilLocated(homeText, "Home");
		System.out.println("Verified text");
	}

}
