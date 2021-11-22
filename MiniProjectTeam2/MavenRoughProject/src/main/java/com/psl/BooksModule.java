package com.psl;
//import a.module.home.HomeModule;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BooksModule {
	

	public static void main(String[] args) throws IOException, InterruptedException, NoSuchElementException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String baseUrl = "http://127.0.0.1:80/shopping/";
		driver.get(baseUrl);
		
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
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
			
		}
		
		catch (NoSuchElementException e) {
			
			System.out.println(e);
			
		}
	}
}



//--------------------------------------------------------------------------





//---------------------------------


//String expectedTitle;
//
//  @BeforeMethod
//  public void beforeMethod() {
//	  
//		WebDriver driver = new ChromeDriver();
//	    WebDriverManager.chromedriver().setup();
//	  
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		
//		String baseUrl = "http://localhost/shopping/";
//		driver.get(baseUrl);
//		
//		String expectedTitle = "Shopping Portal Home Page";
//  }
//  
//
// @Test
//	  public void HomeTest() throws InterruptedException {
//		
//		String actualTitle = driver.getTitle();
//		assertEquals(actualTitle, expectedTitle);	  
//
//	  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  
//	  driver.quit();
//  }
		
