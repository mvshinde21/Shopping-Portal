package com.project.testcases;

import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.BooksPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.apache.log4j.Logger;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
public class BooksTest extends Common{
	
	BooksPage BooksObj;
	WebDriver driver;
	
	public Logger log = Logger.getLogger(BooksPage.class.getName());
	   
	 @Test(priority=1, description = "To access the Books Category")
	 public void booksCatAccess() {
		 
		 WebElement books = BooksObj.booksCatAccess();
		 books.click();
		 log.info("Books category is accessible.");
		  
	 }
	 
	 @Test(priority=2, description = "To access the Comic Books Sub-category")
	 public void booksComicsAccess() {

	 WebElement booksComic = BooksObj.booksComicsAccess();
	 booksComic.click();
	 log.info("Comics subcategory of Books is accessible.");
	 
	 }
	 
	 @Test(priority=3, description = "To add the Book to the Cart")
	 public void addBookToCart() {

	 WebElement bookCart = BooksObj.addBookToCart();
	 if(bookCart.isEnabled())
	  	{
		 bookCart.click();
		 log.info("Add to cart button is accessible.");
	  	}
	 
	 }
	 
	 @Test(priority=4, description = "To display and accept Simple Alert")
	 public void simpleAlert() {

	 String alertMessage = BooksObj.simpleAlert();
	 log.info(alertMessage);
	 
	 }
	 
	  @BeforeClass
	  public void setUp() throws DocumentException, InterruptedException
	  {		
		  BooksObj = new BooksPage();	  
		  BooksObj.getsite();
		  BooksObj.login();

	  }

	  
	  @AfterClass
	  public void tearDown() 
	  {
		  BooksObj.closeBrowser();
		  log.info("Closing the Browser");
	  }
	
	}
