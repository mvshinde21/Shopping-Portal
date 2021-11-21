package com.project.testcases;

import org.dom4j.DocumentException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.MyCartAddressPage;

public class MyCartAddressTest extends Common {
	
	MyCartAddressPage myCartObj;
	
	
//to update the billing address details of the user 
  @Test (priority=1)
  public void billingAddUpdation() throws InterruptedException 
  {
	  
	  myCartObj.AddToCart();
	  myCartObj.findBillAddress().sendKeys("Saket Colony");  
	  myCartObj.findBillState().sendKeys("Madhya Pradesh");
	  myCartObj.findBillCity().sendKeys("JBP");
	  myCartObj.findBillPincode().sendKeys("00000");
	  myCartObj.findBillUpdate().click();
		
	 		try {	
	 			//Thread.sleep(6000);
	 			Alert alert1 = driver.switchTo().alert();
	 			alert1.accept();
	 		}
	 		catch(Exception e)
	 		{
	 			MyCartAddressPage.log.info("FailedBilling");
	 		}
  }
//to update the shipping address details of the user
@Test (priority=2)

public void shippingAddUpdation() throws InterruptedException
{
	  myCartObj.clearBillingDetails(); //clearing the billing details filled previously for proper execution of test.
	  //Thread.sleep(5000);
	  myCartObj.findShipAddress().sendKeys("Saket Colony");
	  myCartObj.findShipState().sendKeys("Madhya Pradesh");
	  myCartObj.findShipCity().sendKeys("JBP");
	  myCartObj.findShipPincode().sendKeys("00000");
	  
	  myCartObj.findShipUpdate().click();
		
	  try { 
	 			//Thread.sleep(6000);
	 		   Alert alert2 = driver.switchTo().alert();
	 		   alert2.accept();
	 	   }
	  catch(Exception e)
	 	   {
	 	   		MyCartAddressPage.log.info("FailedBilling");
	 	   }
}
	         	   
//instantiate the browser and login  

  @BeforeClass
  public void setUp() throws DocumentException, InterruptedException 
  {
	  myCartObj = new MyCartAddressPage();
	  myCartObj.getsite();
	  myCartObj.login1();
	//  Thread.sleep(3000);
	 
  }
  
//For closing the browser
  
  @AfterClass
  public void tearDown() 
  {
	  myCartObj.closeBrowser();
	    
  }

}
