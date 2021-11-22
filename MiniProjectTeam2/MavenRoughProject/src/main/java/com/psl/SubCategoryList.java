package com.psl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubCategoryList{

	public static void main(String[] args) throws IOException, InterruptedException, NoSuchElementException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String baseUrl = "http://127.0.0.1:80/shopping/";
			driver.get(baseUrl);
			
//			String expectedTitle = "Shopping Portal Home Page";
		  
		try {
						
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
//			WebElement searchBar = driver.findElement(By.xpath("//*[@class='search-field']"));
			WebElement searchBar = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[2]/div/form/div/input"));
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", searchBar);
			Thread.sleep(2000);
			searchBar.click();
			searchBar.sendKeys("iphone");
			Thread.sleep(2000);
			searchBar.sendKeys(Keys.ENTER);			

			
			WebElement subCat = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/div"));	
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", subCat);
			Thread.sleep(2000);
			if(subCat.getText().equals("SUB CATEGORIES"))
			System.out.println("Pass");
			else
			System.out.println("Fail");
			assertEquals(subCat.getText(), "SUB CATEGORIES");	
			
			js.executeScript("window.scrollBy(0,100)", "");
			Thread.sleep(1500);
			WebElement subCatList = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li"));	
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", subCatList);
			Thread.sleep(2000);
			if(subCatList.isDisplayed())
				System.out.println("List of sub categories is displayed.");
			
		}
			catch (Exception e) {
				
				System.out.println(e);
				
			}

			
		}
}

