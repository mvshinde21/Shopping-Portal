package com.project.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.project.base.Common;

public class BooksPage extends Common{
	
	WebElement books;	
	WebElement booksComic;
	WebElement bookCart;


	public WebElement booksCatAccess()
	{
		books = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
		// For highlighting the Web Element Books
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", books);
		
		return(books);
	}
	
	
	public WebElement booksComicsAccess()
	{
		booksComic = driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a"));
		// For highlighting the Web Element Comics
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", booksComic);
		
		return(booksComic);

	}
	
	
	public WebElement addBookToCart()
	{
		
		bookCart = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[1]/div/div/div[3]/div/ul/li[1]/a/button"));
		// To scroll to a particular Web Element i.e Add to cart button
		js.executeScript("window.scrollBy(0,450)", "");	
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", bookCart);
		
		return(bookCart);
		
	}
	
	public String simpleAlert()
	{		
		// To switch to the alert, fetch the alert message and accept
        Alert alert = driver.switchTo().alert();	
        String alertMessage= driver.switchTo().alert().getText();       
        alert.accept();
        
        return(alertMessage);

	}
	

}
