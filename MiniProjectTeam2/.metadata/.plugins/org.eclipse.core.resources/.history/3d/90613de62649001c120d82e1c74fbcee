package com.project.testcases;

import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.BooksPage;
import com.project.pages.CartHomePage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class CartHomePageTest extends Common{
  
  CartHomePage CartHomeObj;
  public Logger log = Logger.getLogger(BooksPage.class.getName());
 
  @Test(priority=1)
  public void addToCart() {
 	 
 	    String alertMessage = CartHomeObj.addToCart();
 		log.info(alertMessage);			
 	  
  }
  
 @Test(priority=2)
 public void myCartValue() {
	 
	    WebElement cartValue = CartHomeObj.myCartValue();
		log.info(("The cart value is displayed : "+ cartValue.isDisplayed()));			
		cartValue.click();
	  
 }
 
 @Test(priority=3)
 public void dropDownDisplayed() {
	 
	 WebElement dropDown = CartHomeObj.dropDownDisplayed();
	 log.info("The Cart Drop Down List is displayed : "+ dropDown.isDisplayed());	
	  
 }
 
 @Test(priority=4)
 public void myCartColourChange() {
	 
	 	String oldC = CartHomeObj.myCartOldColour();
	
		log.info("The colour before mouse hovering is : " + oldC);		
		assertEquals(oldC, "rgba(168, 168, 168, 1)");
				
	 	String newC = CartHomeObj.myCartNewColour();
		log.info("The colour after mouse hovering is : " + newC);
		assertEquals(newC, "rgba(169, 182, 154, 1)");
	  
 }
  
  @BeforeClass
  public void beforeClass() throws DocumentException 
  {
	  CartHomeObj = new CartHomePage();	  
	  CartHomeObj.getsite();
	  CartHomeObj.login();
  }
  
  @AfterClass
  public void afterClass() 
  {
	  CartHomeObj.closeBrowser();
	  log.info("Closing the Browser");
  }
//
}
