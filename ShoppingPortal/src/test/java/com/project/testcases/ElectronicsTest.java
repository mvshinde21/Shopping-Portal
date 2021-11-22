package com.project.testcases;

import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.ElectronicsPage;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
public class ElectronicsTest extends Common{
	
	ElectronicsPage ElectronicsObj;
	public Logger log = Logger.getLogger(ElectronicsPage.class.getName());
	  
	 @Test(priority=1, description = "To access the Electronics Category")
	 public void elecCatAccess() {
		 
		 WebElement electronics = ElectronicsObj.elecCatAccess();
		 electronics.click();
		 log.info("Electronics category is accessible.");
		  
	 }
	 
	 @Test(priority=2, description = "To access the Mobiles Sub-Category")
	 public void elecMobilesAccess() {

		 WebElement elecMobiles = ElectronicsObj.elecMobilesAccess();
		 elecMobiles.click();
		 log.info("Mobiles Sub-category is accessible.");
	 
	 }
	 
	 @Test(priority=3, description = "Product Image is Visible")
	 public void prodImagePresent() {

		 WebElement mobileImage = ElectronicsObj.prodImagePresent();
			if (mobileImage.isDisplayed())
	        {
	             log.info("Pass : Redmi Note 4 mobile image displayed.");
	        }
	        else
	        	log.info("Fail : Redmi note 4 image not displayed.");
	 
	 }
	 
	 @Test(priority=4, description = "To add Mobile to Wishlist")
	 public void addToWishlist() {

		 WebElement mobileAdded = ElectronicsObj.addToWishlist();
		 	if(mobileAdded.isEnabled())
			 {
				mobileAdded.click();
				log.info("Product added to wishlist.");
			 }
	 
	 }
	  @BeforeClass
	  public void setUp() throws DocumentException 
	  {
		  ElectronicsObj = new ElectronicsPage();	  
		  ElectronicsObj.getsite();
		  ElectronicsObj.login();
	  }

	  
	  @AfterClass
	  public void tearDown() 
	  {
		  ElectronicsObj.closeBrowser();
		  log.info("Closing the Browser");
	  }
	//
	}
