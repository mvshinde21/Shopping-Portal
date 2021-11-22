package com.project.testcases;

import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.BooksPage;
import com.project.pages.ElectronicsPage;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
public class ElectronicsPageTest extends Common{
	
	ElectronicsPage ElectronicsObj;
	public Logger log = Logger.getLogger(BooksPage.class.getName());
	  
	 @Test(priority=1)
	 public void elecCatAccess() {
		 
		 WebElement electronics = ElectronicsObj.elecCatAccess();
		 electronics.click();
		  
	 }
	 
	 @Test(priority=2)
	 public void elecMobilesAccess() {

		 WebElement elecMobiles = ElectronicsObj.elecMobilesAccess();
		 elecMobiles.click();
	 
	 }
	 
	 @Test(priority=3)
	 public void prodImagePresent() {

		 WebElement mobileImage = ElectronicsObj.prodImagePresent();
			if (mobileImage.isDisplayed())
	        {
	             log.info("Pass : Redmi Note 4 mobile image displayed.");
	        }
	        else
	        	log.info("Fail : Redmi note 4 image not displayed.");
	 
	 }
	 
	 @Test(priority=4)
	 public void addToWishlist() {

		 ElectronicsObj.addToWishlist();
			log.info("Product added to wishlist.");
	 
	 }
	  @BeforeClass
	  public void beforeClass() throws DocumentException 
	  {
		  ElectronicsObj = new ElectronicsPage();	  
		  ElectronicsObj.getsite();
		  ElectronicsObj.login();
	  }

	  
	  @AfterClass
	  public void afterClass() 
	  {
		  ElectronicsObj.closeBrowser();
		  log.info("Closing the Browser");
	  }
	//
	}
