package com.project.pages;

import com.project.base.Common;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FashionPage extends Common
	{
	
	WebElement fashion;
	WebElement fashionFootwear;
	WebElement productRating;
	WebElement productMrp;
	

		public WebElement fashionCatAccess()
		{
//			locating a web element button called fashion
			fashion = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
//			highlighting the button found or to be clicked
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');",fashion);
//			returning the web element found
			return(fashion);

		}
		
		public WebElement fashionFootwearAccess()
		{
//			locating a web element button in subcategory called fashion
			fashionFootwear = driver.findElement(By.cssSelector(".sidebar .side-menu nav .nav >li a"));
//			highlighting the button found or to be clicked
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fashionFootwear);	
//			returning the web element found
			return(fashionFootwear);
		}
		
		public WebElement checkProductRating()
		{
//			locating a web element image named product rating
			productRating = driver.findElement(By.id("rateit-range-2"));
//			scrolling to the element first which needs to be found
			js.executeScript("window.scrollBy(0,450)", "");
//			highlighting the button found or to be clicked
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", productRating);
//			returning the web element found
			return(productRating);
		}
		
		public WebElement checkMrp()
		{
//			locating a web element image named product mrp
			productMrp = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[1]/div/div/div[2]/div[3]/span[2]"));
//			highlighting the button found or to be clicked
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", productMrp);
//			returning the web element found
			return(productMrp);
			
		}


}
