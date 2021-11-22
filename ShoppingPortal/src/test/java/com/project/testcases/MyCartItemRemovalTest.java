package com.project.testcases;
import org.testng.annotations.Test;
import com.project.base.Common;
import com.project.pages.MyCartItemRemovalPage;
import org.testng.annotations.BeforeClass;
import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;

public class MyCartItemRemovalTest extends Common {
	
	MyCartItemRemovalPage myCartObj;
	
//For removing an item from the cart
	
  @Test(description="For item removal from cart.")
  public void removingItem()
  {
	    
	    myCartObj.addToCart();   // adds an item to cart.  	    
		myCartObj.findSelectButton().click();	
		myCartObj.findUpdateButton().click(); 
		
		
		//switching on the alert and accepting it.
		myCartObj.findalert();
		myCartObj.findalert();
		MyCartItemRemovalPage.log.info("Item removed from cart");
  }
  
//instantiate the browser and login  
  
  @BeforeClass
  public void setUp() throws DocumentException, InterruptedException
  {
	  myCartObj = new MyCartItemRemovalPage();
	  myCartObj.getsite();
	  myCartObj.login();
	 
	  
  }
  
//close the browser
  
  @AfterClass
  public void tearDown() 
  {
	  myCartObj.closeBrowser();
	 
  }

}
