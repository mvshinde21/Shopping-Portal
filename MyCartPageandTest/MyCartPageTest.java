package com.project.testcases;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.project.base.Common;
import com.project.pages.MyCartPage;

public class MyCartPageTest extends Common{
	
	MyCartPage MyCartObj;
	String expectedText = "Shopping Cart";
	String expectedTitle = "My Cart";
	
	public static Logger log = Logger.getLogger(MyCartPage.class.getName());
	
 @Test(priority = 1, description = "Add product to cart")
  public void AddToCart() {
		  
    MyCartObj.AddToCart();
 }
 
  @Test(priority = 2, description="Quantity update checking")
  public void quantityUpdate() {	  
	  
	  WebElement incount = MyCartObj.increasequantity();	  
	  if(incount.getAttribute("value").equals("2"));
		 {
			 log.info("Quantity is increased");
		 }
		 
	 WebElement decount = MyCartObj.decreasequantity();	 
	 if((decount.getAttribute("value")).equals("1"));
	 {
		 log.info("Quantity is decreased");
	 }	
  }
  
  @Test(priority = 3, description="Basic Fuctionality ckeck")
  public void textTitleButtonVerification(){
	  
		String actualTitle = MyCartObj.titlecheck();
	    assertEquals(expectedTitle,actualTitle);
		if (actualTitle.equals(expectedTitle))
			log.info("Title verified: " + actualTitle);
	    
		String actualText = MyCartObj.textcheck();
		assertEquals(expectedText, actualText);
		if (actualText.equals(expectedText))
			log.info("Text verified: " + actualText);
		
		String buttonTitle = MyCartObj.buttoncheck();
		if(buttonTitle.equals("Shopping Portal Home Page"));
			log.info("Button Verified.");
 	  
		}
  
  @Test(priority = 4, description="For checking description of product")
  public void descriptionCheck() {
	  WebElement description = MyCartObj.proddescription();	
	  
	  if(description.isDisplayed())
     			log.info("Product description display: Passed");
  }   
  
  @Test(priority = 5, description="To send and check the review of product")
  public void reviewCheck() {
	  
	  	WebElement submitButton = MyCartObj.prodreview();
	  	if(submitButton.isEnabled())
	  	{
	  		submitButton.click();
  			log.info("Review submitted successfully");
	  	}

  }
  @BeforeClass
  public void setUp() throws DocumentException, InterruptedException {
	  
	  MyCartObj =new MyCartPage(); 	  
	  MyCartObj.getsite();
	  MyCartObj.login();
  }

  @AfterClass
  public void tearDown() {
	  
	  MyCartObj.closeBrowser();
	  log.info("Closing the Browser");
  }

}
