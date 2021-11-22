package com.project.testcases;

import com.project.pages.FashionPage;
import com.project.base.Common;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FashionTest extends Common
{
	FashionPage FashionObj;
	public Logger log = Logger.getLogger(FashionPage.class.getName());
	
	@Test(priority=1, description = "To access the Fashion Category")
	public void fashionCatAccess()
	{
		WebElement fashion = FashionObj.fashionCatAccess();
		fashion.click();
		log.info("Fashion category is accessible.");
	}
	
	@Test(priority=2, description = "To access the Footwear Fashion's Sub-category")
	public void fashionFootwearAccess()
	{
		WebElement fashionFootwear = FashionObj.fashionFootwearAccess();
		fashionFootwear.click();
		log.info("Footwear subcategory of Fashion is accessible.");
	}

	@Test(priority=3, description = "To check Product Rating of any Product is visible")
	public void checkProductRating()
	{
		WebElement productRating = FashionObj.checkProductRating();
		log.info(productRating.isDisplayed());
		log.info("Product Rating is Visible.");
	}
	
	@Test(priority=4, description = "To check MRP of any Product is visible")
	public void checkMrp()
	{
		WebElement productMrp = FashionObj.checkMrp();
		productMrp.isDisplayed();
		log.info("Product MRP is Visible.");
	}
	
	  @BeforeClass
	  public void setUp() throws DocumentException 
	  {
		  FashionObj = new FashionPage();
		  FashionObj.getsite();
		  FashionObj.login();
	  }

	  
	  @AfterClass
	  public void tearDown() 
	  {
		  FashionObj.closeBrowser();
	  }
}
