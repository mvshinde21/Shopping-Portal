package com.project.testcases;


import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.WishlistPages;

import org.testng.annotations.BeforeClass;
import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;

public class WishlistTest extends Common {
	WishlistPages myWishlist;

	
  @Test(priority=1)
  public void wishlist_button() {
	  myWishlist.wishlist_button();
	  
  }
  @Test(priority=2)
  public void clickOnProduct() {
	  
	  myWishlist.clickOnProduct();
	  
  }
  @Test(priority=3)
  public void removeProduct(){
	  myWishlist.removeProduct();
	  
  }
  @Test(priority=4)
  public void addToCart(){
	  myWishlist.addToCart();
	  
  }

  @BeforeClass
  public void beforeClass() throws DocumentException {
	  
	  myWishlist= new WishlistPages();
	  myWishlist.getsite();
	  myWishlist.login();
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  myWishlist.closeBrowser();
  }
  

}
