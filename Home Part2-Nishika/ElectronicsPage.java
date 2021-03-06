package com.project.pages;

import java.util.concurrent.TimeUnit;

import com.project.base.Common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElectronicsPage extends Common{
	
	WebElement electronics;
	WebElement elecMobiles;
	WebElement mobileImage;
	WebElement mobileAdded;
	
	public WebElement elecCatAccess()
	{
//		To check for Electronics Category Accessibility
		electronics = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[3]/a"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", electronics);
		return(electronics);

	}
	
	
	public WebElement elecMobilesAccess()
	{
//		To check for Mobiles Sub-Category Accessibility
		elecMobiles = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a[3]"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elecMobiles);
		return(elecMobiles);

	}
	
	
	public WebElement prodImagePresent()
	{
//		To check for Product image visibility
		js.executeScript("window.scrollBy(0,450)", "");
		mobileImage = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[2]/div/div/div[1]/div/a/img"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", mobileImage);
        return(mobileImage);
		
	}
	
	public WebElement addToWishlist()
	{	
		
//		To add the mobile to the Wishlist
		mobileAdded = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[2]/div/div/div[3]/div/ul/li[2]/a/i"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", mobileAdded);
		return(mobileAdded);

	}
	

}
