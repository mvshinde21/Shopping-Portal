//  Working code for Login, Books module (Add to cart), My cart functionality testing.


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

public class RoughClass{

	public static void main(String[] args) throws IOException, InterruptedException, NoSuchElementException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String baseUrl = "http://127.0.0.1:80/shopping/";
		driver.get(baseUrl);
		
//		String expectedTitle = "Shopping Portal Home Page";
		  
		try {
			
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 400)");

			//Thread.sleep(2000);
			WebElement login = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/ul/li[4]/a/i"));
			//WebElement logout =driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/ul/li[5]/a"));
			login.click();

			Actions action =new Actions(driver);
//			 action.moveToElement(mousehover).click().perform();
			// action.moveToElement(rowselector).click().perform();
			WebElement email = driver.findElement(By.id("exampleInputEmail1"));
			WebElement password = driver.findElement(By.id("exampleInputPassword1"));
			WebElement loginButton = driver.findElement(By.name("login"));

			email.sendKeys("ankushtharwani11@gmail.com");
			password.sendKeys("Test@123");
			loginButton.click();
			
			//------------------------------------------------
			
			WebElement books = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", books);
			Thread.sleep(1000);
			books.click();
			Thread.sleep(2000);
			
			WebElement booksComic = driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a"));
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", booksComic);
			Thread.sleep(1000);
			booksComic.click();
			Thread.sleep(3000);
			
			WebElement bookCart = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[1]/div/div/div[3]/div/ul/li[1]/a/button"));
			js.executeScript("window.scrollBy(0,450)", "");
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", bookCart);
			Thread.sleep(1000);
			bookCart.click();
			Thread.sleep(2000);
			
	        Alert alert = driver.switchTo().alert();		    
	        String alertMessage= driver.switchTo().alert().getText();		
	        System.out.println(alertMessage);	
	        Thread.sleep(3000);
	        alert.accept();
			
			
			
			//------------------------------------------------
					
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			WebElement cartValue = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/a/div/div[1]/span[2]/span[2]"));
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", cartValue);
			Thread.sleep(1000);
			System.out.println("The cart value is displayed : "+ cartValue.isDisplayed());			
			cartValue.click();
			
			WebElement dropDown = driver.findElement(By. xpath("/html/body/header/div[2]/div/div/div[3]/div/ul"));
			System.out.println("The Cart Drop Down List is displayed : "+ dropDown.isDisplayed());			
			Thread.sleep(3000);			
			
			WebElement cartColor = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li/div[3]/a"));
//			Actions action = new Actions(driver);
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


