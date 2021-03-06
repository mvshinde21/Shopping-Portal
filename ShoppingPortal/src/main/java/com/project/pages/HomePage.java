package com.project.pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.project.base.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends Common
{
	
	WebElement homeButton;
	WebElement smartphoneLeft;
	WebElement brandEle;
	WebElement laptopRightBtn;
	WebElement brandFacebook;
	WebElement brandLinkedin;


	public String getPageTitle()
	{
		homeButton = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[1]/a"));
		homeButton.click();
		String actualTitle = driver.getTitle();
		return (actualTitle);
		
	}
	public String getPgTitle()
	{
		String actualTitle = driver.getTitle();
		return(actualTitle);
	       
		
	}

	
	public String brandTitleCheck()
	{
		
		js.executeScript("window.scrollBy(0,-600)", "");
		brandEle = driver.findElement(By.id("brands-carousel"));
		String brandTitle = brandEle.getText();
		return(brandTitle);
	}
	
	public WebElement smartPhoneScroll()
	{
		homeButton = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[1]/a"));
		homeButton.click();
		js.executeScript("window.scrollBy(0,700)", "");
		
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/h3")));
		

		smartphoneLeft = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/div/div[1]/div/div[7]/div/div/div/div[2]/h3/a"));
        return(smartphoneLeft);

	}
	
	public WebElement laptopScroll() {
		
		laptopRightBtn = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div/div[2]"));
		laptopRightBtn.click();
		
		
		laptopRightBtn = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[1]/div/div[1]/div/div/div/div[2]/h3/a"));
        return(laptopRightBtn);
		
	}
	
	public WebElement facebookDirect(String expectedColor)
	{
		driver.navigate().back();
		driver.navigate().refresh();
		
//		To Locate Facebook Icon on Home Page
		WebElement brandFacebook = driver.findElement(By.xpath("//*[@class='icon fa fa-facebook']"));
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		
		
		String btnColor = driver.findElement(By.cssSelector(".footer .links-social .social-icons a.active")).getCssValue("background-color");
		String actualColor = Color.fromString(btnColor).asHex();
		Assert.assertTrue(expectedColor.equals(actualColor));
		
		return(brandFacebook);

	}
	
	public WebElement linkedinDirect(String expectedColor)
	{
		
//		To navigate back from Facebook to Home Page
		driver.navigate().back();
		driver.navigate().refresh();
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		
		WebElement brandLinkedin = driver.findElement(By.xpath("//*[@class='icon fa fa-linkedin']"));

		String btnColor = driver.findElement(By.cssSelector(".footer .links-social .social-icons a.active")).getCssValue("background-color");
		String actualColor = Color.fromString(btnColor).asHex();
		Assert.assertTrue(expectedColor.equals(actualColor));
		
		return(brandLinkedin);

	}
	
	public void takeScreenshot() throws IOException
	{
		//Screenshot of Social media Directed Page
		
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("files/facebookpage.png"));
	}
	

	
}
