package com.project.pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.base.Common;

public class TrackOrderPage extends Common
{
	public String baseurl = "http://localhost/shopping";
	public WebElement trackorder;
	public WebElement orderid_text_area;
	public WebElement emailid_text_area;
	public WebElement Track2;
	public WebElement Track3;
	public String parent_window;
	public String child_window;
	public Set<String>s;
	public String actualTitle ;
	public String expectedTitle = "Order Tracking Details";
	public WebElement errorMessage ;
	public Boolean actualResult;
	public Boolean expectedResult;
	public WebElement logOutButton;
	public String expectedUrl;
	public String actualUrl;
	public static Logger log = Logger.getLogger(TrackOrderPage.class.getName());
	public String invalidEmail;
	public String invalidOrderId;
	
	
	
	//For finding track order button on the top right corner of the home page and returning it.
	public WebElement findtrackOrder()
	{
		
		
		trackorder = driver.findElement(By.xpath("//span[text() = 'Track Order']"));
		return (trackorder);  //click
		
	}
	
	//For finding the text area to enter order id.
	public WebElement findorderid()
	{
		
		 orderid_text_area= driver.findElement(By.name("orderid"));
		 return (orderid_text_area);  //sendkeys
		
	}
	
	//For finding the text area to enter email id.

	public WebElement findEmail()
	{
		
		emailid_text_area= driver.findElement(By.name("email"));  //sendkeys
		return (emailid_text_area);
		
	}
	
    // For finding track button which has to be clicked after entering order id and email id of the user.
	public WebElement findTrackButton2()
	{
		
		Track2 = driver.findElement(By.xpath("//button[text() = 'Track']"));
		return (Track2);  //click
		
	}
	
	//For finding track button to open a new window which displays all the tracking details.
	public WebElement findTrackButton3()
	{
		
		Track3 = driver.findElement(By.xpath("//a[@title='Track order']"));
		return (Track3);  //click
		
	}	
	
	//For locating the error message which is displayed after entering wrong email id or order id.
	public WebElement finderrorMsg()
	{
		errorMessage = driver.findElement(By.xpath("//tr/td[@colspan = '8']"));
		return (errorMessage);
		 //isdisplayed
		
	}

	//For locating log out button to log out from the site. 
	//This will be used to check that whether a logged out user is redirected to login page 
	//or not if the user tries to track an order.
	public WebElement findlogOutButton()
	{
		logOutButton = driver.findElement(By.xpath("//a[text() = 'Logout']"));
				return (logOutButton);
		 //click
		
	}
	
	//To get the URL after a logged user has clicked on track order button.
	//Expected is the login page. But track order page opens in this case.
	 public  void getUrl()
		{
			
			expectedUrl = "http://localhost/shopping/login.php";
			actualUrl = driver.getCurrentUrl();
			
		}
	 
	// For asserting that whether a new window has opened or not after clicking on the track button and
	 //filling in the details.
	public void tracking()
	{
		 parent_window=driver.getWindowHandle(); // get the window handle of parent window or track orders page.
		      
		// get the window handle of track orders page and also of the new window displaying tracking details

		s=driver.getWindowHandles(); 
		// Now iterate using Iterator
		Iterator<String> I1=    s.iterator();
		expectedTitle = "Order Tracking Details";
		while(I1.hasNext())
			{
		           child_window=I1.next(); // storing the window handle of new window.
		           if(!parent_window.equals(child_window))//if they do not match, switch to the new window and get title.
				{
				   actualTitle = driver.switchTo().window(child_window).getTitle();				   
				   assertEquals(expectedTitle,actualTitle); //assert the title
				   driver.close(); //This will only close the new window.
				   	   
				}
			
			}
		driver.switchTo().window(parent_window);
			
			 
	}
public void invalidEmailOrderidRead() throws DocumentException
	{
	    	File inputFile = new File(System.getProperty("user.dir") +"\\files\\properties.xml");
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(inputFile);
			invalidEmail= document.selectSingleNode("//trackOrder/invalidemail").getText().toString();
			invalidOrderId= document.selectSingleNode("//trackOrder/invalidId").getText().toString();
	}
}
