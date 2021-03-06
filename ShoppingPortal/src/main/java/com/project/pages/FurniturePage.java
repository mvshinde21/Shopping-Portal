package com.project.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.project.base.Common;

public class FurniturePage extends Common
{
	public WebElement furnitureCatAccess()
	{
//		locating a web element button called furniture 
		WebElement furniture = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[4]/a"));
//		highlighting the button found or to be clicked
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", furniture);
		
//		returning the web element found
		return(furniture);
	}
	
	public WebElement furnitureBedAccess()
	{
//		locating a web element button in subcategory called furniture 
		WebElement furnitureBed = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a"));
//		highlighting the button found or to be clicked
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", furnitureBed);
		
//		returning the web element found
		return(furnitureBed);
	}
	
	public WebElement checkProductRating()
	{
//		locating a web element image named product rating
		WebElement productRating = driver.findElement(By.xpath("//*[@id=\"rateit-range-2\"]"));
//		scrolling to the element first which needs to be found
		js.executeScript("window.scrollBy(0,400)", "");
		
//		highlighting the button found or to be clicked
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", productRating);
		
//		returning the web element found
		return(productRating);
	}
	
	public String bedsCatMouseHover()
	{
//		locating a web element button called furniture
		WebElement furniture = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[4]/a"));
		furniture.click();
		
//		locating a web element button in subcategory called furniture 
		WebElement furnitureBed = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a"));
		Actions action = new Actions(driver);
//		mouse hover to the element found for color change
		action.moveToElement(furnitureBed).perform();
		
//		saving the color cocde recieved from the element
		String s = furnitureBed.getCssValue("color");
//		returning the color code
		return(s);
	}

}
