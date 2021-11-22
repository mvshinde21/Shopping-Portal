package com.project.base;

import java.io.File;

import org.apache.log4j.xml.DOMConfigurator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Common {
	
	public WebDriver driver;
	private String baseurl = "http://localhost/shopping";
	public JavascriptExecutor js;	  

	private WebElement email, loginPassword, loginButton, loginIcon;
	private String emailId;
	private String password;
	

	public void getsite() 
	{
//		 WebDriverManager.chromedriver().setup();
		
//		1. Chrome Browser
		 System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		 driver = new ChromeDriver();
		 
//		2. Edge Browser
//		 System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
//		 driver = new EdgeDriver();
		 
		 driver.get(baseurl);
		 driver.manage().window().maximize();
		 js = (JavascriptExecutor) driver;	
		 DOMConfigurator.configure("files/log4j.xml");
		 
	}
	
//		Log In Functionality common for all.
		public void login() throws DocumentException {
			
			File inputFile = new File(System.getProperty("user.dir") +"\\files\\properties.xml");
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(inputFile);
			emailId = document.selectSingleNode("//valid/email").getText().toString();
			password = document.selectSingleNode("//valid/password").getText().toString();

			loginIcon = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/ul/li[4]/a/i"));
			loginIcon.click();
			js.executeScript("window.scrollBy(0, 400)");

			email = driver.findElement(By.id("exampleInputEmail1"));
			email.sendKeys(emailId);

			loginPassword = driver.findElement(By.id("exampleInputPassword1"));
			loginPassword.sendKeys(password);

			loginButton = driver.findElement(By.name("login"));
			loginButton.click();		

	}
		
		public void login1() throws DocumentException {
			
			File inputFile = new File(System.getProperty("user.dir") +"\\files\\properties.xml");
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(inputFile);
			emailId = document.selectSingleNode("//emptydeetsShipBill/email").getText().toString();
			password = document.selectSingleNode("//emptydeetsShipBill/password").getText().toString();

			loginIcon = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/ul/li[4]/a/i"));
			loginIcon.click();
			js.executeScript("window.scrollBy(0, 400)");

			email = driver.findElement(By.id("exampleInputEmail1"));
			email.sendKeys(emailId);

			loginPassword = driver.findElement(By.id("exampleInputPassword1"));
			loginPassword.sendKeys(password);

			loginButton = driver.findElement(By.name("login"));
			loginButton.click();	
			
		}
		
		public void closeBrowser()
			{
				driver.quit();
			}
			
}
