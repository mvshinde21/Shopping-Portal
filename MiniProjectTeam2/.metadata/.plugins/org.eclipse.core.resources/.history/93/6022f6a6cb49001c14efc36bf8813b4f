package com.project.testcases;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.SearchPage;


public class SearchPageTest extends Common
{
	SearchPage SearchObj;
	public Logger log = Logger.getLogger(SearchPage.class.getName());
	
	@Test(priority=1)
	public void SearchValidTest()
	{
		WebElement searchBar = SearchObj.SearchFunctionality();
		searchBar.sendKeys("The Wimpy Kid Do -It- Yourself Book");
		searchBar.sendKeys(Keys.ENTER);
		WebElement Product = SearchObj.ProductName();
		Product.isDisplayed();
		Product.click();
		log.info("Search with Valid Detaials is Diaplayed.");
	}
	
	@Test(priority=2)
	public void SearchPartialTest()
	{
		WebElement searchBar = SearchObj.SearchFunctionality();	
		searchBar.sendKeys("Iph");
		searchBar.sendKeys(Keys.ENTER);
		WebElement Product = SearchObj.ProductName();
		Product.isDisplayed();
		Product.click();
	}

	@Test(priority=3)
	public void SearchInvalidTest()
	{
		WebElement searchBar = SearchObj.SearchFunctionality();
		searchBar.sendKeys("laptop");
		searchBar.sendKeys(Keys.ENTER);
		WebElement noProduct = SearchObj.ProductNotFound();
		String product = noProduct.getText();
		if(product.equals(SearchPage.expectedProduct))
			log.info("Search with Invalid data Passed");
	}
	
	  @BeforeClass
	  public void before() throws DocumentException 
	  {
		  SearchObj = new SearchPage();
		  SearchObj.getsite();
		  SearchObj.login();
	  }

	  
	  @AfterClass
	  public void after() 
	  {
		  SearchObj.closeBrowser();
	  }

}
