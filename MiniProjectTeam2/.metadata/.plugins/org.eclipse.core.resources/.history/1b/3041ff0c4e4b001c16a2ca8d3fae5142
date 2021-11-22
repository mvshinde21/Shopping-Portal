package com.project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.base.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WishlistPages extends Common {


WebElement wishlist ;
WebElement remove ;
WebElement AddToCart;
WebElement Product;

Logger log = Logger.getLogger(WishlistPages.class.getName());

public void wishlist_button() {
		
	// Click on Wishlist button
	wishlist = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/ul/li[3]/a"));
	wishlist.click();	
	// Scroll down
	JavascriptExecutor js1 =(JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0, 400)");
	log.info("Click on Wishlist ");
	//Thread.sleep(4000);

}


public void removeProduct() {
	
	// Remove the product from Wishlist
	remove = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/table/tbody/tr/td[4]/a/i"));
	remove.click();
	log.info("Product removed from wishlist");
	
	// Alert handling
	driver.switchTo().alert().accept();

}

public void addToCart()
{
	  AddToCart = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/table/tbody/tr[1]/td[3]/a"));
		AddToCart.click();
		log.info("Product added to cart successfully ");
		
}


public void clickOnProduct()
{
	Product = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/table/tbody/tr[1]/td[2]/div[1]/a"));
	  	Product.click();
		log.info("Product details view ");
		driver.navigate().back(); 
		
}

}
