package homepages;
//package com.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilities.Common;

public class SearchPage extends Common {

	public static String expectedProduct = "No Product Found";
	
	public WebElement ProductNotFound()
	{
//		locating a web element when no product matches the search of user 
		WebElement noProduct = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div/h3")); 
//		returning the web element found
		return(noProduct);
	}
	
	public WebElement ProductName()
	{
//		locating a web element when product matches the search of user 
		WebElement product = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div/div/div/div[2]/h3/a"));
//		returning the web element found
		return (product);
	}
	
	
	public WebElement SearchFunctionality()
	{
//		locating the search bar 
		WebElement searchBar = driver.findElement(By.xpath("//*[@class='search-field']"));
//		returning the web element found
		return(searchBar);
	}


}
