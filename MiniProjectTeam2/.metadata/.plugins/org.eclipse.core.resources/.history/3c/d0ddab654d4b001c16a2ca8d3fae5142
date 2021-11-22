package com.project.testcases;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.project.base.Common;
import com.project.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;
	public class LoginPageTest{
	public Logger log = Logger.getLogger(LoginPage.class.getName());
	LoginPage loginObj;
	@Test(priority=1,description= "login with valid credentials")
	public void loginWithValidCredentials() throws DocumentException, InterruptedException {
		loginObj.LoginDataCredentials("valid");
		loginObj.logIn(loginObj.emailId,loginObj.password);	
		String s1=(loginObj.getTitle());
		if(s1!=loginObj.getTitle())
		{
		log.info("login successful");
		loginObj.logOut();
		}
		else
		log.info("Invalid Credentials");	
	}
	@Test(priority=2,description="login with invalid userid")
	public void loginWithInvalidUserid() throws DocumentException {
		loginObj.LoginDataCredentials("InvalidEmail");
		loginObj.logIn(loginObj.emailId,loginObj.password);	
		if(loginObj.errorMessage().isDisplayed())
		    log.info("Invalid UserId");
		else
		    loginObj.logOut();
		
		}
	@Test(priority=3,description="login with invalid password")
	public void loginWithInvalidPassword() throws DocumentException {
		loginObj.LoginDataCredentials("invalidPassword");
		loginObj.logIn(loginObj.emailId,loginObj.password);	
		if(loginObj.errorMessage().isDisplayed())
		    log.info("Invalid Password");
		else
		    loginObj.logOut();
	
	}
	@Test(priority=4,description="login with invalid password and Userid")
	public void loginWithInvalidUseridOrPassword() throws DocumentException {
		loginObj.LoginDataCredentials("InvalidEmailandPassword");
		loginObj.logIn(loginObj.emailId,loginObj.password);	
		if(loginObj.errorMessage().isDisplayed())
		    log.info("Invalid Userid or Password");
		else
		    loginObj.logOut();
		
		}
	@BeforeClass
	public void setUp() {
		loginObj = new LoginPage();
		loginObj.initializeBrowser();
		loginObj.driver.get(loginObj.baseUrl);

	}
	
	@AfterClass
	public void tearDown() {
		loginObj.closeBrowser();
	
	}	

}