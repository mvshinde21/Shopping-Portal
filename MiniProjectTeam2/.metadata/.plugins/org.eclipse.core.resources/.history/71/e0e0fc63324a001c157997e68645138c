package com.project.testcases;

import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.BooksPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.apache.log4j.Logger;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
public class BooksPageTest extends Common{
	
	BooksPage BooksObj;	
	String emailId;
	String password;
	
	public Logger log = Logger.getLogger(BooksPage.class.getName());
	   
	 @Test(priority=1)
	 public void booksCatAccess() {
		 
		 WebElement books = BooksObj.booksCatAccess();
		 books.click();
		 log.info("Books category is accessible.");
		  
	 }
	 
	 @Test(priority=2)
	 public void booksComicsAccess() {

	 WebElement booksComic = BooksObj.booksComicsAccess();
	 booksComic.click();
	 log.info("Comics subcategory of Books is accessible.");
	 
	 }
	 
	 @Test(priority=3)
	 public void addBookTocart() {

	 WebElement bookCart = BooksObj.addBookTocart();
	 bookCart.click();
	 log.info("Add to cart is accessible.");
	 
	 }
	 
	 @Test(priority=4)
	 public void simpleAlert() {

	 String alertMessage = BooksObj.simpleAlert();
	 log.info(alertMessage);
	 
	 }
	  @BeforeClass
	  public void beforeClass() throws DocumentException
	  {
		  BooksObj = new BooksPage();	  
		  BooksObj.getsite();
		  BooksObj.login();

	  }

	  
	  @AfterClass
	  public void afterClass() 
	  {
		  BooksObj.closeBrowser();
		  log.info("Closing the Browser");
	  }
	
	}
