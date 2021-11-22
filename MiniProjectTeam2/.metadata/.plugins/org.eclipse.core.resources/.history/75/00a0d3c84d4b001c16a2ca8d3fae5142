package com.project.pages;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPage {
	
	public WebDriver driver;
	public String baseUrl = "http://localhost/shopping/login.php";
	WebElement email ;
	WebElement loginPassword ;
	WebElement loginButton;
	WebElement loginIcon;
	public String emailId;
	public String password;

	public void logIn(String emailId,String password) {
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		
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
	
	public void initializeBrowser() {
			
//		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//baseUrl = "http://localhost/shopping/login.php";
		//driver.get(baseUrl);
		 DOMConfigurator.configure("files/log4j.xml");
	}
	public void LoginDataCredentials(String s1) throws DocumentException
	{
		String userId=("//"+s1+"/email");
		String  userPassword=("//"+s1+"/password");
		File inputFile = new File(System.getProperty("user.dir") +"\\files\\properties.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		emailId = document.selectSingleNode(userId).getText().toString();
		password = document.selectSingleNode(userPassword).getText().toString();
//		System.out.println(emailid+ " " +password);
	}
	public void logOut()
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		try
		{
			WebElement Logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[1]/div/div/div[1]/ul/li[5]/a")));
			Logout.click();
		}
		catch(Exception e)
		{
			System.out.println(this.errorMessage());
			// System.out.println("Done");
		}
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public WebElement errorMessage()
	{
		WebElement error= driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/form/span"));
		return error;
	
	}
	public void closeBrowser()
	{
		driver.quit();
	}
}