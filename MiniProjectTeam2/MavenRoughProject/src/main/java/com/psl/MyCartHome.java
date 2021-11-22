package com.psl;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyCartHome{

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
			
			WebElement cartValue = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/a/div/div[1]/span[2]/span[2]"));
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", cartValue);
			Thread.sleep(1000);
			System.out.println("The cart value is displayed : "+ cartValue.isDisplayed());			
			cartValue.click();
			
			WebElement dropDown = driver.findElement(By. xpath("/html/body/header/div[2]/div/div/div[3]/div/ul"));
			System.out.println("The Cart Drop Down List is displayed : "+ dropDown.isDisplayed());			
			Thread.sleep(3000);			
			
			WebElement cartColor = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li/div[3]/a"));
			Actions action = new Actions(driver);
			System.out.println("The colour before mouse hovering is : " + cartColor.getCssValue("background-color"));
			assertEquals(cartColor.getCssValue("background-color"), "rgba(168, 168, 168, 1)");
			Thread.sleep(3000);
			action.moveToElement(cartColor).perform();
			WebElement newCartcolor = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li/div[3]/a"));
			System.out.println("The colour after mouse hovering is : " + newCartcolor.getCssValue("background-color"));
			assertEquals(newCartcolor.getCssValue("background-color"), "rgba(170, 194, 140, 1)");
				
			
		}
			catch (Exception e) {
				
				System.out.println(e);
				
			}

			
		}
}


