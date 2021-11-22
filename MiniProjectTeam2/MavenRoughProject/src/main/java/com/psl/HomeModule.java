package com.psl;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.annotations.*;
//import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import static org.testng.Assert.assertEquals;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeModule {
	
	public static void main(String[] args) throws IOException, InterruptedException, NullPointerException {
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String baseUrl = "http://127.0.0.1:80/shopping/";
		driver.get(baseUrl);
		
		String expWebTitle = "Shopping Portal Home Page";
		  
		try {
			
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expWebTitle);	

			if(driver.getTitle().equals(expWebTitle))
			System.out.println("Title matched");
			else
			System.out.println("Title did not match");			
			Thread.sleep(3000);
			
			String expectedTitle = "FEATURED PRODUCTS";

			System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
			Actions action = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			driver.get("http://localhost/shopping");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/ul/li[4]/a")).click();
			WebElement login= driver.findElement(By.name("login"));
			js.executeScript("arguments[0].scrollIntoView();",login);

			driver.findElement(By.id("exampleInputEmail1")).sendKeys("nishika.manira9@gmail.com");
			driver.findElement(By.id("exampleInputPassword1")).sendKeys("miniproject123");
			login.click();

			WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[1]/a"));
			homeButton.click();
			Thread.sleep(2000);

			js.executeScript("window.scrollBy(0,700)", "");

			Thread.sleep(1000);

			WebElement btnForward = driver.findElement(By.xpath("//*[@id=\"all\"]/div/div/div[2]/div/div[2]"));
			WebElement btnBackward = driver.findElement(By.xpath("//*[@id=\"all\"]/div/div/div[2]/div/div[1]"));

			Thread.sleep(1000);

			WebElement featuredProducts = driver.findElement(By.xpath("//*[@class='new-product-title pull-left']"));
			String featuredTitle = featuredProducts.getText();

			Thread.sleep(1000);

			if(featuredTitle.equals(expectedTitle))
			System.out.println("Title Matched");
			else
			System.out.println("Title not Matched");

			Thread.sleep(1000);

			action.moveToElement(btnBackward);
			btnBackward.click();
			Thread.sleep(1000);

			WebElement lastProduct = driver.findElement(By.xpath("//*[@id=\"all\"]/div/div/div[1]/div/div[19]/div/div/div/div[2]/h3/a"));
			Thread.sleep(1000);

			if(lastProduct.isDisplayed())
			System.out.println("Left Scroll : Pass");
			else
			System.out.println("Fail");

			Thread.sleep(1000);

			btnForward.click();
			WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"all\"]/div/div/div[1]/div/div[1]/div/div/div/div[2]/h3/a"));

			Thread.sleep(1000);

			if(firstProduct.isDisplayed())
			System.out.println("Right Scroll : Pass");
			else
			System.out.println("Fail");

			Thread.sleep(1000);

			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/h3")));
			Thread.sleep(1000);

			WebElement smartphoneLeftBtn = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/div/div[2]/div/div[1]"));
			Thread.sleep(1000);

			smartphoneLeftBtn.click();
			Thread.sleep(2000);

			WebElement smartphoneLeft = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/div/div[1]/div/div[7]/div/div/div/div[2]/h3/a"));
			if(smartphoneLeft.isDisplayed())
			System.out.println("Smartphone Left Scroll : Pass");
			else
			System.out.println("Fail");

			Thread.sleep(1000);

			WebElement smartphoneRightBtn = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/div/div[2]/div/div[2]"));
			Thread.sleep(1000);
			smartphoneRightBtn.click();
			Thread.sleep(2000);

			WebElement smartphoneRight = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/div/div[1]/div/div[1]/div/div/div/div[2]/h3/a"));
			if(smartphoneRight.isDisplayed())
			System.out.println("Smartphone Right Scroll : Pass");
			else
			System.out.println("Fail");
			Thread.sleep(1000);

			WebElement laptopLeftBtn = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div/div[1]"));

			laptopLeftBtn.click();
			Thread.sleep(2000);

			WebElement laptopLeft = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[1]/div/div[4]/div/div/div/div[2]/h3/a"));
			if(laptopLeft.isDisplayed())
			System.out.println("Laptop Left Scroll : Pass");
			else
			System.out.println("Fail");

			Thread.sleep(1000);

			WebElement laptopRightBtn = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div/div[2]"));
			laptopRightBtn.click();
			Thread.sleep(2000);

			WebElement laptopRight = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[1]/div/div[1]/div/div/div/div[2]/h3/a"));
			if(laptopRight.isDisplayed())
			System.out.println("Laptop Right Scroll : Pass");
			else
			System.out.println("Fail");
			
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(1000);
			WebElement brandRight = driver.findElement(By.xpath("//*[@id=\"brand-slider\"]/div[2]/div/div[2]"));
			brandRight.click();
			Thread.sleep(2000);

//			--------------------
			String expSocialTitle = "Facebook";
			String expectedColor = "#abd07e";

			// WebElement brandFacebook = driver.findElement(By.cssSelector(".footer .links-social .social-icons a.active"));

			WebElement brandFacebook = driver.findElement(By.xpath("//*[@class='icon fa fa-facebook']"));

			Thread.sleep(2000);
			String btnColor = driver.findElement(By.cssSelector(".footer .links-social .social-icons a.active")).getCssValue("background-color");
			String actualColor = Color.fromString(btnColor).asHex();
			// System.out.println("Color is "+btnColor);
			// System.out.println("Color hex code "+actualColor);

			Assert.assertTrue(expectedColor.equals(actualColor));
			Thread.sleep(2000);

			brandFacebook.isDisplayed();
			brandFacebook.click();
			Thread.sleep(3000);

			if(driver.getTitle().equals(expSocialTitle))
			System.out.println("Pass");
			else
			System.out.println("Fail");

			driver.navigate().back();
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.quit();
			
						
		}
		
		catch (Exception e) {
			
			System.out.println(e);
			
		}
	}
}


//--------------------------------------------------
//String actualTitle = driver.getTitle();
//assertEquals(actualTitle, expectedTitle);	
//
//if(driver.getTitle().equals(expectedTitle))
//System.out.println("Title matched");
//else
//System.out.println("Title did not match");			
//Thread.sleep(3000);
//		
//JavascriptExecutor js = (JavascriptExecutor) driver;
//				
//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/h3")));
//Thread.sleep(2000);
//
//WebElement smartphoneLeft =  driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/div/div[2]/div/div[1]"));
//WebElement laptopRight =  driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div/div[2]"));
//smartphoneLeft.click();
//Thread.sleep(3000);
//laptopRight.click();
//Thread.sleep(3000);
//				
//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//Thread.sleep(2000);
//
//WebElement brandRight =  driver.findElement(By.xpath("//*[@id=\"brand-slider\"]/div[2]/div/div[2]"));
//brandRight.click();
//Thread.sleep(2000);