package com.project.testcases;

import com.project.pages.BooksPage;
import com.project.pages.FurniturePage;
import com.project.base.Common;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FurniturePageTest extends Common
{
	FurniturePage FurnitureObj;
	public Logger log = Logger.getLogger(BooksPage.class.getName());
	
	@Test(priority=1)
	public void FurnitureCatAccess()
	{
		WebElement furniture = FurnitureObj.furnitureCatAccess();
		furniture.click();
		log.info("Furniture category is accessible.");
	}
	
	@Test(priority=2)
	public void FurnitureFootwearAccess()
	{
		WebElement furnitureBed = FurnitureObj.furnitureBedAccess();	
		furnitureBed.click();
	}

	@Test(priority=3)
	public void checkProductRating()
	{
		WebElement productRating = FurnitureObj.checkProductRating();
		log.info("Produt rating is displayed :" + productRating.isDisplayed());
	}
	
	@Test(priority=4)
	public void bedsCatMouseHover()
	{
		String s = FurnitureObj.bedsCatMouseHover();
		String c = Color.fromString(s).asHex();	
		log.info("Mouse Hovered over Furniture Bed and colour changed :" + s + " " + c);
	}
	
  @BeforeClass
  public void beforeClass() throws DocumentException 
  {
		  FurnitureObj = new FurniturePage();
		  FurnitureObj.getsite();
		  FurnitureObj.login();
  }

  @AfterClass
  public void afterClass() {
	  
	  FurnitureObj.closeBrowser();
	  log.info("Closing the Browser");
  }

}
