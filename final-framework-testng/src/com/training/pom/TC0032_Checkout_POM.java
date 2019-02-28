package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC0032_Checkout_POM {
	private WebDriver driver; 
	
	public TC0032_Checkout_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//locating the elements
	
	@FindBy(xpath="//*[@id=\"banner0\"]/div/a/img")
	private WebElement shop_uniforms; 
	
	@FindBy(xpath="//*[@id=\"featured-carousel\"]/div/div/div[1]/div/div/div[1]/a/img")
	private WebElement T_shirt;
	
	@FindBy(id="button-cart")
	private WebElement cart;
	
	@FindBy(xpath="//*[@id=\"cart\"]/button")
	private WebElement Cart_icon;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
	private WebElement ViewCart;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/a")
	private WebElement checkout;
	
	
	
	public void Shop_Uniforms() {
		this.shop_uniforms.click();
	
	}
	public void T_shirt() {
		this.T_shirt.click();
	
	}
	public void Cart() {
		this.cart.click();
	}
	public void Cart_icon() {
		this.Cart_icon.click();
	}
	public void ViewCart() {
		this.ViewCart.click();
	}
	public void Checkout() {
		this.checkout.click();
	}


}
