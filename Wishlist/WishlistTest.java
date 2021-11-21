package com.project.test;


import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.WishlistPage;
import org.testng.annotations.BeforeClass;
import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;

public class WishlistTest extends Common {
	WishlistPage myWishlist;

 
  
  @Test(priority=1 ,description="Click on wishlist button. ")
  public void wishlist_button() {
	  myWishlist.wishlist_button();
	  
  }
  @Test(priority=2 ,description="Click on product for more details. ")
  public void clickOnProduct() {
	  
	  myWishlist.clickOnProduct();
	  
  }
  @Test(priority=3 ,description="Remove product from wishlist. ")
  public void removeProduct(){
	  myWishlist.removeProduct();
	  
  }
  @Test(priority=4 ,description="Add product to cart. ")
  public void addToCart(){
	  myWishlist.addToCart();
	  
  }

  @BeforeClass
  public void setUp() throws DocumentException {
	  
	  myWishlist= new WishlistPage();
	  myWishlist.getsite();
	  myWishlist.login();
	  
  }

  @AfterClass
  public void tearDown() {
	  
	  myWishlist.closeBrowser();
  }
  

}
