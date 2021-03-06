package com.project.testcases;
import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.RegistrationPage;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;

public class RegistrationPageTest extends Common{

  RegistrationPage regObj;
  public Logger log = Logger.getLogger(RegistrationPage.class.getName());
  
  @Test(priority=1, description="New Registration")
  public void registration() {
	  regObj.registration("Mauli","mauli@yahoo.com","1234","12345","1234");
	  if(regObj.submitButtun().isEnabled())
	  {
		  regObj.submitButtun().click();
		  regObj.driver.switchTo().alert().accept();
		  log.info("Registration Successful !!");  
	  }
	  else
	  {
		  log.info("Email is already Register ");
	  }	  
  }
  @Test(priority=2,description ="Registration of already register user")
  public void reRegistration()
  {
	  regObj.registration("Aishwarya","aishm222@yahoo.com","1234","12345","1234");
	  if(regObj.submitButtun().isEnabled())	  
	  {
		  regObj.submitButtun().click();
		  regObj.driver.switchTo().alert().accept();
		  log.info("Registration Successful !!");  
	  }
	  else {
		  log.info("Email is already Register ");
	  }
  } 
  @BeforeClass
  public void setUp() {
	  regObj=new RegistrationPage();
	  regObj.getsite();
	  
  }
  @AfterClass
  public void tearDown() {
	  regObj.closeBrowser();  
  }
}
