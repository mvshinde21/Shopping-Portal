package com.project.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;

import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.TrackOrderPage;
public class TrackOrderTest extends Common {
	
	
	TrackOrderPage trackObj;

	
//This will track the order by entering orderid and emailid of the user who has ordered a product.
	
  @Test (priority=3)
  public void trackingOrder() throws InterruptedException, DocumentException 
  {
	 
	  trackObj.login();
	  trackObj.findtrackOrder().click();
	  trackObj.findorderid().sendKeys("13");
	  trackObj.findEmail().sendKeys("nirmal@yahoo.com");
	  trackObj.findTrackButton2().click();
	  trackObj.findTrackButton3().click();
	  trackObj.tracking();

  }
  
  
  // This will check that if someone enters wrong email id then user cannot track the order.
  
  @Test (priority=1) 
  public void invalidEmail() throws InterruptedException
  {
	  trackObj.findtrackOrder().click();
	 // Thread.sleep(5000);
	  trackObj.findorderid().sendKeys("7");
	  trackObj.findEmail().sendKeys("aishm@yahoo.com"); // This email id does not exist in the database.
	  trackObj.findTrackButton2().click();
	  trackObj.actualResult = trackObj.finderrorMsg().isDisplayed();
	  trackObj.expectedResult = true;
	  assertEquals(trackObj.expectedResult,trackObj.actualResult);
  }
  
  //This will check that whether a logged out user is redirected to login page 
  //or not if the user tries to track an order.
  
  @Test (priority=2)
  public void loggedoutUser() throws InterruptedException
  {
	  trackObj.findlogOutButton().click();
	  trackObj.findtrackOrder().click();
	 // Thread.sleep(5000);
	  trackObj.getUrl();
	  
	  if((trackObj.actualUrl).equals(trackObj.expectedUrl))
	  {
		  TrackOrderPage.log.info("TestCaseFailed");
	  }
	  else
	  {
		  TrackOrderPage.log.info("Passed");
	  }
  }
  
//instantiate the browser and login  
  
  @BeforeClass
  public void setUp() throws DocumentException {
	  trackObj = new TrackOrderPage();
	  trackObj.getsite();
	  trackObj.login();
  }
  
//close the browser
  
  @AfterClass
  public void tearDown() 
  {
	  trackObj.closeBrowser();
  }

}
