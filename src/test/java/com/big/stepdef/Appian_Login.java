//package com.big.stepdef;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.big.pageObjects.AMS_Actions;
//import com.big.pageObjects.CommonObj;
//import com.big.utils.Utilities;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Appian_Login {
//	Utilities ut = new Utilities();
//	CommonObj co = new CommonObj();
//	AMS_Actions ac = new AMS_Actions();
//	
//	
//	@Given("User login to Appian application as {string}")
//	public void login(String role) throws InterruptedException {
//		co.appianlogin(ut.getCellValue("Credentials",role,"UserName"),
//	    ut.getCellValue("Credentials",role,"Password"));
//
//	}
//	
//	@Given("User navigate to the {string} category") 
//	 public void menuNavigation(String category) throws InterruptedException { 
//		 co.appianNavigationToMainMenu(category); 
//		 
//		 }
//	
//
//	 
//}
//
