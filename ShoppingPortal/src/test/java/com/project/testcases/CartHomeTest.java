package com.project.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

import com.project.base.Common;
import com.project.pages.CartHomePage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class CartHomeTest extends Common{
  
	CartHomePage CartHomeObj;
	public Logger log = Logger.getLogger(CartHomePage.class.getName());
 
	  @Test(priority=1, description = "Add a Book to Cart")
	  public void addToCart() {
	 	 
	 	    String alertMessage = CartHomeObj.addToCart();
	 		log.info(alertMessage);			
	 	  
	  }
	  
	 @Test(priority=2, description = "Cart total value display on Home Page")
	 public void myCartValue() {
		 
		    WebElement cartValue = CartHomeObj.myCartValue();
			log.info(("The cart value is displayed : "+ cartValue.isDisplayed()));			
			cartValue.click();
		  
	 }
	 
	 @Test(priority=3, description = "Drop Down List of Products in the Cart on Home Page")
	 public void dropDownDisplayed() {
		 
		 WebElement dropDown = CartHomeObj.dropDownDisplayed();
		 log.info("The Cart Drop Down List is displayed : "+ dropDown.isDisplayed());	
		  
	 }
	 
	 @Test(priority=4, description = "My Cart colour change on Mouse Hovering")
	 public void myCartColourChange() throws IOException, InterruptedException {
		 
		 	String oldC = CartHomeObj.myCartOldColour();	
			log.info("The colour before mouse hovering is : " + oldC);		
					
		 	String newC = CartHomeObj.myCartNewColour();
			log.info("The colour after mouse hovering is : " + newC);
		  
	 }
	  
	  @BeforeClass
	  public void setUp() throws DocumentException, InterruptedException 
	  {
		  CartHomeObj = new CartHomePage();	  
		  CartHomeObj.getsite();
		  CartHomeObj.login();
	  }
	  
	  @AfterClass
	  public void tearDown() 
	  {
		  CartHomeObj.closeBrowser();
		  log.info("Closing the Browser");
	  }

}
