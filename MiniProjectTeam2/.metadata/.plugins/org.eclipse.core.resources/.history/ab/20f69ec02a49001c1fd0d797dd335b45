package com.project.testcases;

import com.project.pages.BooksPage;
import com.project.pages.FashionPage;
import com.project.base.Common;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FashionPageTest extends Common
{
	FashionPage FashionObj;
	public Logger log = Logger.getLogger(BooksPage.class.getName());
	
	@Test(priority=1)
	public void fashionCatAccess()
	{
		WebElement fashion = FashionObj.fashionCatAccess();
		fashion.click();
		log.info("Fashion category is accessible.");
	}
	
	@Test(priority=2)
	public void fashionFootwearAccess()
	{
		WebElement fashionFootwear = FashionObj.fashionFootwearAccess();
		fashionFootwear.click();
	}

	@Test(priority=3)
	public void checkProductRating()
	{
		WebElement productRating = FashionObj.checkProductRating();
		log.info(productRating.isDisplayed());
	}
	
	@Test(priority=4)
	public void checkMrp()
	{
		WebElement productMrp = FashionObj.checkMrp();
		productMrp.isDisplayed();
	}
	
	  @BeforeClass
	  public void before() throws DocumentException 
	  {
		  FashionObj = new FashionPage();
		  FashionObj.getsite();
		  FashionObj.login();
	  }

	  
	  @AfterClass
	  public void after() 
	  {
		  FashionObj.closeBrowser();
	  }
}
