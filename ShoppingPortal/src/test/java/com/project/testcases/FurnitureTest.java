package com.project.testcases;

import com.project.pages.FurniturePage;
import com.project.base.Common;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FurnitureTest extends Common
{
	FurniturePage FurnitureObj;
	public Logger log = Logger.getLogger(FurniturePage.class.getName());
	
	@Test(priority=1, description = "To access the Furniture Category")
	public void furnitureCatAccess()
	{
		WebElement furniture = FurnitureObj.furnitureCatAccess();
		furniture.click();
		
		log.info("Furniture category is accessible.");
	}
	
	@Test(priority=2, description = "To access the Beds Furniture's Sub-category")
	public void furnitureBedAccess()
	{
		WebElement furnitureBed = FurnitureObj.furnitureBedAccess();	
		furnitureBed.click();
		
		log.info("Beds subcategory of Furniture is accessible.");
	}

	@Test(priority=3, description = "To check Product Rating of any Product is visible")
	public void checkProductRating()
	{
		WebElement productRating = FurnitureObj.checkProductRating();
		log.info("Produt rating is displayed :" + productRating.isDisplayed());
	}
	
	@Test(priority=4, description = "To check Color change on MOuse Hover is visible")
	public void bedsCatMouseHover()
	{
		String s = FurnitureObj.bedsCatMouseHover();
		String c = Color.fromString(s).asHex();	
		log.info("Mouse Hovered over Furniture Bed and colour changed :" + s + " " + c);
	}
	
  @BeforeClass
  public void setUp() throws DocumentException
  {
		  FurnitureObj = new FurniturePage();
		  FurnitureObj.getsite();
		  FurnitureObj.login();
  }

  @AfterClass
  public void tearDown() {
	  
	  FurnitureObj.closeBrowser();
	  log.info("Closing the Browser");
  }

}
