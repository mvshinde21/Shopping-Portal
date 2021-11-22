package com.project.pages;
import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.project.base.*;

public class MyCartPage  extends Common{

	public String expectedTitle;
	public String actualTitle;
	public WebElement button ;
	public WebElement incount;
	public WebElement decount;
	public WebElement value;
	public WebElement value1;
	public WebElement addtocart;
	public WebElement description;
	public WebElement review;
	public WebElement booksButton;
	public WebElement addToCartButton;
	public String name;
	public String summary;
	public String Review;
	
	
	public void AddToCart()
	{
		// Function for adding element to cart
		booksButton = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
		booksButton.click();
		addToCartButton = driver.findElement(By.linkText("Add to cart"));
		js.executeScript("arguments[0].scrollIntoView();",addToCartButton);
		addToCartButton.click();
				
		//accept alert
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	
		
	}
	
	
	public String titlecheck() {
		// Returns actual title of page
	     actualTitle = driver.getTitle();
	     return(actualTitle);
		
	} 
	
	public String buttoncheck() {
		//Click on button
		button = driver.findElement(By.xpath("//a[ @class=\"btn btn-upper btn-primary outer-left-xs\"]"));
		button.click();
		
		
		String buttonTitle = driver.getTitle();
		//return the title of page
		return (buttonTitle);
	}
	
	public String textcheck() {
		//find and return text
		String actualText = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[2]")).getText();
		return(actualText);
		
	}
	
	public WebElement increasequantity() {
	
		// find and click on increase quantity
		  WebElement count = driver.findElement(By.className("ir"));
		  count.click();
		  
		  
		  // find and return updated value webelement
		  incount = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div/form/table/tbody/tr/td[4]/div/input"));
		  return(incount);
			 
		
	}
	
	public WebElement decreasequantity() {
		// find and click on decrease quantity 
		WebElement dcount = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div/form/table/tbody/tr[1]/td[4]/div/div/div[2]"));
		dcount.click();
		
		
		// find and return updated value webelement
		decount = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div/form/table/tbody/tr/td[4]/div/input"));
		return (decount);
		
	}
	
	public WebElement proddescription() {
		// go to my cart
		description = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/ul/li[4]/a"));
		description.click();
		
		
		// click on product
		description = driver.findElement(By.xpath("//h4/a[@href=\"product-details.php?pid=15\" ]"));
		description.click();
		
		
		//find description
		description = driver.findElement(By.id("description"));
		js.executeScript("arguments[0].scrollIntoView();", description);
		// return webelement
		return (description);
		
	}
	
	public WebElement prodreview() throws DocumentException, InterruptedException {
		// find and click on review
		File inputFile = new File(System.getProperty("user.dir") +"\\files\\properties.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		name = document.selectSingleNode("//ProdReview/name").getText().toString();
		summary = document.selectSingleNode("//ProdReview/summary").getText().toString();
		Review = document.selectSingleNode("//ProdReview/review").getText().toString();
		
		review = driver.findElement(By.xpath("//*[@id=\"product-tabs\"]/li[2]/a"));
		review.click();
		// Review filling
		driver.findElement(By.xpath("//input[@name=\"quality\" and @value=\"3\"]")).click();
	  	driver.findElement(By.xpath("//input[@name=\"price\" and @value=\"3\"]")).click();
	  	driver.findElement(By.xpath("//input[@name=\"value\" and @value=\"3\"]")).click();
	  	driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys(name);
	  	driver.findElement(By.id("exampleInputSummary")).sendKeys(summary);
	  	driver.findElement(By.id("exampleInputReview")).sendKeys(Review);
	  	
	  	
	  	// find and return submitButton webelement
	  	WebElement submitButton = driver.findElement(By.xpath("//button[@name=\"submit\"]"));
	  	return(submitButton);
	  	

	}
	
}
;