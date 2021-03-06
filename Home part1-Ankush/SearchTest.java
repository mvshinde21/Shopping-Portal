package testcases;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import homepages.SearchPage;
import utilities.Common;

public class SearchTest extends Common
{
	SearchPage SearchObj;  //creating instance of the SearchPage class
	public Logger log = Logger.getLogger(SearchPage.class.getName());
	
	@Test(priority=1)
	public void SearchValidTest()
	{
		WebElement searchBar = SearchObj.SearchFunctionality();  
		searchBar.sendKeys("The Wimpy Kid Do -It- Yourself Book"); 
		searchBar.sendKeys(Keys.ENTER);
		WebElement Product = SearchObj.ProductName(); 
		Product.isDisplayed();  //verify the product valid product is displayed 
		Product.click();  
		log.info("Search with Valid Details is Displayed.");
	}
	
	@Test(priority=2)
	public void SearchPartialTest()
	{
		WebElement searchBar = SearchObj.SearchFunctionality();	
		searchBar.sendKeys("Iph");  
		searchBar.sendKeys(Keys.ENTER);
		WebElement Product = SearchObj.ProductName(); 
		Product.isDisplayed();  //verify the product valid product is displayed 
		Product.click();
		log.info("Search with Partial Valid Details is Displayed.");
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
	  public void setUp() throws DocumentException 
	  {
		  SearchObj = new SearchPage();
		  SearchObj.getsite();
		  SearchObj.login();
	  }

	  
	  @AfterClass
	  public void tearDown() 
	  {
		  SearchObj.closeBrowser();
	  }

}
