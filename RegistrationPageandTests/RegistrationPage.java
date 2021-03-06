package com.project.pages;
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
   //Method use to return submit button WebElement 
  public WebElement submitButtun()
  {
	  signUpButton = driver.findElement(By.id("submit"));
	  return signUpButton;
  }
  
}
