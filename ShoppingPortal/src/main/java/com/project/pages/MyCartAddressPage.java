package com.project.pages;

import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.base.Common;

public class MyCartAddressPage extends Common
{
	public WebElement shipAdd;
    public WebElement shipState;
    public WebElement shipCity;
    public WebElement shipPincode;
    public WebElement billAdd;
    public WebElement billState;
    public WebElement billCity;
    public WebElement billPincode;
    public WebElement shipUpdate;
    public WebElement billUpdate;
    public WebElement booksButton;
	public WebElement addToCartButton;
	public String billAdddata;
	public String billStatedata;
	public String billCitydata;
	public String billPincodedata;
	public String shipAdddata;
	public String shipStatedata;
	public String shipCitydata;
	public String shipPincodedata;
    
    public static Logger log = Logger.getLogger(MyCartAddressPage.class.getName());
    
    //For locating text area to enter shipping address and returning the web element.
    public WebElement findShipAddress()
    {
    	shipAdd = driver.findElement(By.name("shippingaddress"));
    	return (shipAdd);
    }
    
  //For locating text area to enter shipping state and returning the web element.
    public WebElement findShipState()
    {
    	shipState = driver.findElement(By.name("shippingstate"));
    	return (shipState);
    }
    
  //For locating text area to enter shipping city and returning the web element.
    public WebElement findShipCity()
    {
    	shipCity = driver.findElement(By.name("shippingcity"));
    	return (shipCity);
    }
    
  //For locating text area to enter shipping pincode and returning the web element.
    public WebElement findShipPincode()
    {
    	shipPincode = driver.findElement(By.name("shippingpincode"));
    	return (shipPincode);
    }
   
  //For locating text area to enter billing address and returning the web element.
    public WebElement findBillAddress()
    {
    	js.executeScript("arguments[0].scrollIntoView();",findBillUpdate()); 
    	billAdd = driver.findElement(By.name("billingaddress"));
    	return (billAdd);
    }
    
  //For locating text area to enter billing state and returning the web element.
    public WebElement findBillState()
    {
    	billState = driver.findElement(By.name("bilingstate"));
    	return (billState);
    }
 
    //For locating text area to enter billing city and returning the web element.
    public WebElement findBillCity()
    {
    	billCity = driver.findElement(By.name("billingcity"));
    	return (billCity);
    }
    
    //For locating text area to enter billing pincode and returning the web element.
    public WebElement findBillPincode()
    {
    	billPincode = driver.findElement(By.name("billingpincode"));
    	return (billPincode);
    }
    
    //For locating shipping address update button and returning the web element. 
    public WebElement findShipUpdate()
    {
    	shipUpdate = driver.findElement(By.name("shipupdate"));
    	return (shipUpdate);
    }
    
    //For locating billing address update button and returning the web element. 
    public WebElement findBillUpdate()
    {
    	billUpdate = driver.findElement(By.name("update"));
    	return (billUpdate);
    }
    
    //For clearing all details filled in billing address section after clicking on update button. 
    //So, that shipping address test can be checked properly.
    public void clearBillingDetails()
    {
    	findBillPincode().clear();  	
    	findBillCity().clear();   	
    	findBillState().clear();    	
    	findBillAddress().clear();
    	
    }
    
    // For adding The Wimpy Kid Book to cart
    public void  AddToCart() 
	{
    	booksButton = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
		booksButton.click();
		
		addToCartButton = driver.findElement(By.linkText("Add to cart"));	
		js.executeScript("arguments[0].scrollIntoView();",addToCartButton); 
		addToCartButton.click();
		
		Alert alert1 = driver.switchTo().alert();	
		alert1.accept();
		
		
	}
    
    public void addressReading() throws DocumentException
    {
    	File inputFile = new File(System.getProperty("user.dir") +"\\files\\properties.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		billAdddata = document.selectSingleNode("//address/billAdd").getText().toString();
		billStatedata= document.selectSingleNode("//address/billState").getText().toString();
		billCitydata = document.selectSingleNode("//address/billCity").getText().toString();
		billPincodedata= document.selectSingleNode("//address/billPincode").getText().toString();
		shipAdddata = document.selectSingleNode("//address/shipAdd").getText().toString();
		shipStatedata= document.selectSingleNode("//address/shipState").getText().toString();
		shipCitydata = document.selectSingleNode("//address/shipCity").getText().toString();
		shipPincodedata= document.selectSingleNode("//address/shipPincode").getText().toString();
		
    }
    
}