package com.project.testcases;

import org.testng.annotations.Test;

import com.project.base.Common;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import com.project.pages.BooksPage;
import com.project.pages.LoggedOutUser;

public class LoggedOutUserTest extends Common{
  
	LoggedOutUser LoggedOutObj;
	public Logger log = Logger.getLogger(BooksPage.class.getName());
	
  @Test
  public void clickTrackValidateUrl() throws InterruptedException 
  {	  
	  
	  LoggedOutObj.findtrack().click();
	  LoggedOutObj.getUrl();
	  assertEquals(LoggedOutObj.expectedUrl,LoggedOutObj.actualUrl);
		
  }
  @BeforeClass
  public void beforeClass() throws DocumentException 
  {
	  LoggedOutObj =new LoggedOutUser(); 
	  LoggedOutObj.getsite();
	  LoggedOutObj.login();
	  
  }

  @AfterClass
  public void afterClass() {
	  LoggedOutObj.closeBrowser();
	  log.info("Closing the Browser");
  }

}
