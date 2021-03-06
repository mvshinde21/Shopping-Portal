package com.project.testcases;

import org.testng.annotations.Test;

import com.project.base.Common;

import com.project.pages.HomePage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class HomeTest extends Common {
  
  HomePage HomeObj;
  
  private String expWebTitle="Shopping Portal Home Page";
  private String expBrandTitle = "OUR BRANDS";
  String fbexpTitle="Facebook";
  String liexpTitle="LinkedIn";
  String fbColor = "#abd07e";
  String liColor = "#abd07e";

  public Logger log = Logger.getLogger(HomePage.class.getName());
  

 @Test(priority=1, description = "To verify Page Title")
 public void pageTitle() {
	 
	 String actualTitle = HomeObj.getPageTitle();
	 if(actualTitle.toString().contains("Shopping Portal")) {
		log.info("Page title contains \"Shopping Portal\"");
		 
	    if(actualTitle.equals(expWebTitle))
	    	log.info("Page Title Matched");
		else
			log.info("Page Title not Matched");
//		assertEquals(actualTitle, expWebTitle);	
	 }
 }
 
 @Test(priority=2, description = "To verify Brand Title")
 public void brandTitleCheck(){
	 
	 String brandTitle = HomeObj.brandTitleCheck();
	 
	    if(brandTitle.equals(expBrandTitle))
	    	log.info("Brand Title Matched");
		else
			log.info("Brand Title not Matched");
	  
 }
 
 @Test(priority=3, description = "Smartphone display left Scroll")
 public void smartPhoneScroll(){
	 
	    WebElement smartphoneLeft = HomeObj.smartPhoneScroll();
	    
		if(smartphoneLeft.isEnabled() )
			log.info("Smartphone Left Scroll : Pass");
		else
			log.info("Smartphone Left Scroll : Fail");
	  
 }
 
 @Test(priority=4, description = "Laptop display right Scroll")
 public void laptopScroll(){
	 
	    WebElement laptopRight = HomeObj.laptopScroll();
	    
		if(laptopRight.isEnabled())
			log.info("Laptop Right Scroll : Pass");
		else
			log.info("Laptop Right Scroll : Fail");
	  
 }
 
 @Test(priority=5, description = "Facebook social media visibility on Home")
 public void facebookDirect() throws IOException {
	 
	 WebElement brandFacebook = HomeObj.facebookDirect(fbColor);
	 if(brandFacebook.isDisplayed()) {
	 		log.info("Facebook icon is visible");
			brandFacebook.click();
			
			HomeObj.takeScreenshot();
	 		String fbactualTitle = HomeObj.getPgTitle();
	 		if(fbactualTitle.equals(fbexpTitle))
	 			log.info("Facebook Directed : Pass");
	 }
	  
 }
 
 @Test(priority=6, description = "LinkedIn social media visibility on Home")
 public void linkedinDirect(){
	 
	 WebElement brandLinkedin = HomeObj.linkedinDirect(liColor);
	 if(brandLinkedin.isDisplayed()) {
		brandLinkedin.click();
		log.info("Linkedin icon is visible.");
 		
		String liactualTitle = HomeObj.getPgTitle();
 		if(liactualTitle.equals(liexpTitle))
 			log.info("LinkedIn Directed : Pass");
	 }
 }
  
  @BeforeClass
  public void setUp() throws DocumentException
  {
	  HomeObj = new HomePage();	  
	  HomeObj.getsite();
	  HomeObj.login();
  }

  
  @AfterClass
  public void tearDown() 
  {
	  HomeObj.closeBrowser();
	  log.info("Closing the Browser");
  }
//
}
