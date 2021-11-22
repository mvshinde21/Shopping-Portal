package com.project.pages;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
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
		WebElement furniture = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[4]/a"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", furniture);
		return(furniture);
	}
	
	public WebElement furnitureBedAccess()
	{
		WebElement furnitureBed = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", furnitureBed);
		return(furnitureBed);
	}
	
	public WebElement checkProductRating()
	{
		WebElement productRating = driver.findElement(By.xpath("//*[@id=\"rateit-range-2\"]"));
		js.executeScript("window.scrollBy(0,200)", "");
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", productRating);
		return(productRating);
	}
	
	public String bedsCatMouseHover()
	{
		WebElement furniture = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[4]/a"));
		furniture.click();
		WebElement furnitureBed = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a"));
		Actions action = new Actions(driver);
		action.moveToElement(furnitureBed).perform();
		String s = furnitureBed.getCssValue("color");
		return(s);
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
