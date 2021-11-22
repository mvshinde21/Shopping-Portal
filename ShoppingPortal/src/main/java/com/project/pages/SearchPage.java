package com.project.pages;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.project.base.Common;

public class SearchPage extends Common {

	public static String expectedProduct = "No Product Found";
	public String validData,invalidData,parData;
	
	public void searchData() throws DocumentException
	{
		File inputFile = new File(System.getProperty("user.dir") + "\\files\\properties.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		validData = document.selectSingleNode("//data/searchdata/validdata").getText().toString();
		invalidData = document.selectSingleNode("//data/searchdata/invaliddata").getText().toString();
		parData = document.selectSingleNode("//data/searchdata/pardata").getText().toString();
	}
	
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
