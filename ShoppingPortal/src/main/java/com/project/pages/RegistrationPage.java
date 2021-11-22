package com.project.pages;
import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.base.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationPage extends Common{
	//Initialization of required WebElements
	WebElement fullNameTextBox;
	WebElement  emailTextBox;
    WebElement contactTextBox;
    WebElement passwordTextBox;
    WebElement confirmPasswordTextBox;
    WebElement signUpButton;
    public String userName;
    public String newEmailId;
    public String contactNumber;
    public String userPassword;
    public String confirmUserPassword;
    
    // Registration of user 
   public void registration(String name,String email,String password,String contact,String confirmPassword) {
	   
	  JavascriptExecutor js =(JavascriptExecutor) driver;	  
	  WebElement login = driver.findElement(By.xpath("//ul//li[4]/a"));
	  login.click();
	  js.executeScript("window.scrollBy(0, 400)");
	  driver.manage().window().maximize();
	  fullNameTextBox = driver.findElement(By.id("fullname"));
	  fullNameTextBox.sendKeys(name);
	  
      
      emailTextBox = driver.findElement(By.id("email"));
      emailTextBox.sendKeys(email);
      
      
      contactTextBox= driver.findElement(By.id("contactno"));
      contactTextBox.sendKeys(contact);
      
      
      passwordTextBox = driver.findElement(By.id("password"));
      passwordTextBox.sendKeys(password);
      
      
      confirmPasswordTextBox = driver.findElement(By.id("confirmpassword"));
      confirmPasswordTextBox.sendKeys(confirmPassword);
      
   }
   //Method is use to initialize the values for register 
   public void registrationDataCredentials(String s1) throws DocumentException
	{
		String name=("//"+s1+"/name");
		String  email=("//"+s1+"/email");
		String contact=("//"+s1+"/contact");
		String  password=("//"+s1+"/password");
		String  confirmPassword=("//"+s1+"/confirmPassword");
		File inputFile = new File(System.getProperty("user.dir") +"\\files\\properties.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		userName= document.selectSingleNode(name).getText().toString();
		newEmailId = document.selectSingleNode(email).getText().toString();
		contactNumber = document.selectSingleNode(contact).getText().toString();
		userPassword = document.selectSingleNode(password).getText().toString();
		confirmUserPassword = document.selectSingleNode(confirmPassword).getText().toString();
	}
   //Method use to return submit button WebElement 
  public WebElement submitButtun()
  {
	  signUpButton = driver.findElement(By.id("submit"));
	  return signUpButton;
  }
  
}
