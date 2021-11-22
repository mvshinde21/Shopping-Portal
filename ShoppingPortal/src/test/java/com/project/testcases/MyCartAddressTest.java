package com.project.testcases;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.project.base.Common;
import com.project.pages.MyCartAddressPage;

public class MyCartAddressTest extends Common {
	
	MyCartAddressPage myCartObj;
	
	
//to update the billing address details of the user 
  @Test (priority=1, description="For checking updation of billing address.")
  public void billingAddUpdation() 
  {
	  
	  myCartObj.AddToCart();	  
	  myCartObj.findBillAddress().sendKeys( myCartObj.billAdddata);  	  
	  myCartObj.findBillState().sendKeys( myCartObj.billStatedata);	  
	  myCartObj.findBillCity().sendKeys( myCartObj.billCitydata);	  
	  myCartObj.findBillPincode().sendKeys( myCartObj.billPincodedata);	  
	  myCartObj.findBillUpdate().click();
	  	
	 		try 
	 		{	
	 			Alert alert1 = driver.switchTo().alert();
	 			alert1.accept();
	 		}
	 		catch(Exception e)
	 		{
	 			MyCartAddressPage.log.info("FailedBilling");
	 		}
  }
//to update the shipping address details of the user
	@Test (priority=2,description="For checking updation of shipping address.")
	
	public void shippingAddUpdation()
	{
		  myCartObj.clearBillingDetails(); //clearing the billing details filled previously for proper execution of test.	  
		  myCartObj.findShipAddress().sendKeys(myCartObj.shipAdddata);	  
		  myCartObj.findShipState().sendKeys(myCartObj.shipStatedata);	  
		  myCartObj.findShipCity().sendKeys(myCartObj.shipCitydata);	  
		  myCartObj.findShipPincode().sendKeys(myCartObj.shipPincodedata);	  
		  myCartObj.findShipUpdate().click();
	  
		
	  try 
	  { 
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
  public void setUp() throws DocumentException{
	  myCartObj = new MyCartAddressPage();
	  myCartObj.getsite();
	  myCartObj.login1();
	  myCartObj.addressReading();
	
	 
  }
  
//For closing the browser
  
  @AfterClass
  public void tearDown() 
  {
	  myCartObj.closeBrowser();
	    
  }

}
