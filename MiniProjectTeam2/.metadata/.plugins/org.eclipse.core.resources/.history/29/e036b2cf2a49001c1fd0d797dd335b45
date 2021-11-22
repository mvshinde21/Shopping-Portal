package com.project.testcases;

import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.BooksPage;
import com.project.pages.HomePage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class HomePageTest extends Common{
  
  HomePage HomeObj;
  String expWebTitle="Shopping Portal Home Page";
  String expBrandTitle = "OUR BRANDS";
  String fbTitle = "Facebook";
  String fbColor = "#abd07e";
  String liColor = "#abd07e";
  String liTitle = "LinkedIn";

  public Logger log = Logger.getLogger(BooksPage.class.getName());
  
 @Test(priority=1)
 public void pageTitle() {
	 
	 String actualTitle = HomeObj.getPageTitle();
	 
	    if(actualTitle.equals(expWebTitle))
	    	log.info("Page Title Matched");
		else
			log.info("Page Title not Matched");
//		assertEquals(actualTitle, expWebTitle);	
	  
 }
 
 @Test(priority=2)
 public void brandTitleCheck() {
	 
	 String brandTitle = HomeObj.brandTitleCheck();
	 
	    if(brandTitle.equals(expBrandTitle))
	    	log.info("Brand Title Matched");
		else
			log.info("Brand Title not Matched");
	  
 }
 
 @Test(priority=3)
 public void smartPhoneScroll() throws InterruptedException {
	 
	    WebElement smartphoneLeft = HomeObj.smartPhoneScroll();
	    
		if(smartphoneLeft.isEnabled() )
			log.info("Smartphone Left Scroll : Pass");
		else
			log.info("Smartphone Left Scroll : Fail");
	  
 }
 
 @Test(priority=4)
 public void laptopScroll() {
	 
	    WebElement laptopRight = HomeObj.laptopScroll();
	    
		if(laptopRight.isEnabled())
			log.info("Laptop Right Scroll : Pass");
		else
			log.info("Laptop Right Scroll : Fail");
	  
 }
 
 @Test(priority=5)
 public void facebookDirect() {
	 
	 HomeObj.facebookDirect(fbTitle, fbColor);
	  
 }
 
 @Test(priority=6)
 public void linkedinDirect() {
	 
//	 HomeObj.linkedinDirect("Shopping Portal Home Page", "#abd07e");
	 HomeObj.linkedinDirect(liTitle, liColor);
	  
 }
  
  @BeforeClass
  public void beforeClass() throws DocumentException 
  {
	  HomeObj = new HomePage();	  
	  HomeObj.getsite();
	  HomeObj.login();
  }

  
  @AfterClass
  public void afterClass() 
  {
	  HomeObj.closeBrowser();
	  log.info("Closing the Browser");
  }
//
}
