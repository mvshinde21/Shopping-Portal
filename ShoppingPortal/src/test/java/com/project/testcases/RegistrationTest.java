package com.project.testcases;
import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.RegistrationPage;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;

public class RegistrationTest extends Common{

  RegistrationPage regObj;
  public Logger log = Logger.getLogger(RegistrationPage.class.getName());
  
  @Test(priority=1, description="New Registration")
  public void registration() throws DocumentException {
	  
	  regObj.registrationDataCredentials("newRegistration");
	  regObj.registration(regObj.userName,regObj.newEmailId,regObj.userPassword,regObj.contactNumber,regObj.confirmUserPassword);
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
  
  @Test(priority=1,description ="Registration of already register user")
  public void reRegistration() throws DocumentException
  {
	  regObj.registrationDataCredentials("reRegistration");
	  regObj.registration(regObj.userName,regObj.newEmailId,regObj.userPassword,regObj.contactNumber,regObj.confirmUserPassword);
	  
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
