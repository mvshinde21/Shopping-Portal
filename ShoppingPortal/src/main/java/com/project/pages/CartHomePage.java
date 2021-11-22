package com.project.pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.project.base.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartHomePage extends Common {

	
	WebElement books;
	WebElement cartValue;
	WebElement dropDown;
	WebElement cartColor;

	public String addToCart()
	{		
//		To add books in the cart 
		
		books = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", books);
		
		books.click();
		
		books= driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", books);
		
		books.click();
	
		books = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[1]/div/div/div[3]/div/ul/li[1]/a/button"));
		js.executeScript("window.scrollBy(0,450)", "");
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", books);
		
		books.click();

        Alert alert = driver.switchTo().alert();		    
        String alertMessage= driver.switchTo().alert().getText();
        alert.accept();
        return(alertMessage);

	}


	public WebElement myCartValue()
	{
//		To verify cart value visibility
		cartValue = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/a/div/div[1]/span[2]/span[2]"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", cartValue);
		
		return(cartValue);
		
	}
	
	public WebElement dropDownDisplayed()
	{
//		To verify drop down list of My Cart
		dropDown = driver.findElement(By. xpath("/html/body/header/div[2]/div/div/div[3]/div/ul"));
		
		return(dropDown);			
	}
	
	public String myCartOldColour() throws IOException, InterruptedException
	{	
//		To fetch old colour of My Cart button
		cartColor = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li/div[3]/a"));
		
		//Screenshot of Cart before colour change
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("files/oldcolourcart.png"));
		String s = cartColor.getCssValue("background-color");
		return (s);
	}
	
	public String myCartNewColour() throws IOException, InterruptedException 
	{
//		To fetch new colour of My Cart button on mouse hovering
		cartColor = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li/div[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(cartColor).perform();	
		
		
		//Screenshot of Cart after colour change
        File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile1, new File("files/newcolourcart.png"));
		String s = cartColor.getCssValue("background-color");
		return (s);
		
	}
		
}
