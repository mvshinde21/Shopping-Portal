package com.project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.project.base.Common;

public class MyCartItemRemovalPage extends Common
{

	public WebElement booksButton;
	public WebElement addToCartButton;
	public WebElement selectButton;
	public WebElement updateButton;
	public static Logger log = Logger.getLogger(MyCartItemRemovalPage.class.getName());
	
	
	// For locating the select button and returning it.
	public WebElement findSelectButton()
	
	{
		selectButton = driver.findElement(By.xpath("//input[@value='15']"));
		return (selectButton);
	}
	
	// For locating the "update shopping cart" button and returning it.
	public WebElement findUpdateButton()
	
	{
		updateButton = driver.findElement(By.xpath("//input[@value='Update shopping cart']"));
		return (updateButton);
	}
	
	 // For adding The Wimpy Kid Book to cart
	public void  addToCart()
	{
		booksButton = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
		booksButton.click();
		addToCartButton = driver.findElement(By.linkText("Add to cart"));	
		js.executeScript("arguments[0].scrollIntoView();",addToCartButton); 
		addToCartButton.click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	}
	
	//For finding alert and accepting it.
	public void findalert() throws InterruptedException
	{
		Alert alert = driver.switchTo().alert();
		//Thread.sleep(4000);
		alert.accept();
		//Thread.sleep(4000);
	}
	

}
