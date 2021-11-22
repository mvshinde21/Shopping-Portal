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

public class SearchTest extends Common
{
	SearchPage SearchObj;  //creating instance of the SearchPage class
	public Logger log = Logger.getLogger(SearchPage.class.getName());
	
	@Test(priority=1, description = "To verify Product is visible with valid Search Data")
	public void SearchValidTest() 
	{
		WebElement searchBar = SearchObj.SearchFunctionality(); 		
		searchBar.sendKeys(SearchObj.validData); 	
		searchBar.sendKeys(Keys.ENTER);
		
		WebElement Product = SearchObj.ProductName();	
		Product.isDisplayed(); 
		//verify the product valid product is displayed 
		Product.click();  
		
		log.info("Search with Valid Details is Displayed.");
	}
	
	@Test(priority=2, description = "To verify Product is visible with partially valid Search Data")
	public void SearchPartialTest() 
	{
		WebElement searchBar = SearchObj.SearchFunctionality();	
		
		searchBar.sendKeys(SearchObj.parData); 	
		searchBar.sendKeys(Keys.ENTER);
		
		WebElement Product = SearchObj.ProductName(); 		
		Product.isDisplayed();  //verify the product valid product is displayed 		
		Product.click();		
		log.info("Search with Partial Valid Details is Displayed.");
	}

	@Test(priority=3, description = "To verify No Product Found is displayed with invalid Search Data")
	public void SearchInvalidTest() 
	{
		WebElement searchBar = SearchObj.SearchFunctionality();		
		searchBar.sendKeys(SearchObj.invalidData);		
		searchBar.sendKeys(Keys.ENTER);
		
		WebElement noProduct = SearchObj.ProductNotFound();		
		String product = noProduct.getText();		
		if(product.equals(SearchPage.expectedProduct))		
			log.info("Search with Invalid data Passed");
	}
	
	  @BeforeClass
	  public void setUp() throws DocumentException, InterruptedException 
	  {
		  SearchObj = new SearchPage();
		  SearchObj.getsite();
		  SearchObj.login();
		  SearchObj.searchData();
	  }

	  
	  @AfterClass
	  public void tearDown() 
	  {
		  SearchObj.closeBrowser();
	  }

}
