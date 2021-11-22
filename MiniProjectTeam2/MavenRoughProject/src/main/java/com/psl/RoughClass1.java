
package com.psl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughClass1{

	public static void main(String[] args) throws IOException, InterruptedException, NoSuchElementException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String baseUrl = "http://127.0.0.1:80/shopping/";
		driver.get(baseUrl);
		
//		String expectedTitle = "Shopping Portal Home Page";
		  
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			WebElement electronics = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[3]/a"));
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", electronics);
			Thread.sleep(1000);
			electronics.click();			
			Thread.sleep(2000);		
			
			WebElement elecMobiles = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a[3]"));
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elecMobiles);
			Thread.sleep(1000);
			elecMobiles.click();
			Thread.sleep(2000);	
			
			js.executeScript("window.scrollBy(0,450)", "");
			Thread.sleep(2000);
			
			WebElement mobileImage = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[2]/div/div/div[1]/div/a/img"));
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", mobileImage);
			Thread.sleep(1000);
			if (mobileImage.isDisplayed())
	        {
	             System.out.println("Pass : Redmi Note 4 mobile image displayed.");
	        }
	        else
	            System.out.println("Fail : Redmi note 4 image not displayed.");
			
			WebElement addWishlist = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[2]/div/div/div[3]/div/ul/li[2]/a/i"));
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", addWishlist);
			Thread.sleep(1000);
			addWishlist.click();
			System.out.println("Product added to wishlist.");
			Thread.sleep(3000);
			
			driver.navigate().back();
			Thread.sleep(1000);
			driver.navigate().refresh(); 
				
			
		}
			catch (Exception e) {
				
				System.out.println(e);
				
			}

			
		}
}


