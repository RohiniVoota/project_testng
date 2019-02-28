package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC0034_Checkout_GuestLogin_POM {
	private WebDriver driver; 
	
	public TC0034_Checkout_GuestLogin_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//loacting the elements
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
	
    @FindBy(id="button-account")
    private WebElement RegisterBtn;
    
    @FindBy(id="input-payment-firstname")
    private WebElement firstname;
    
    @FindBy(id="input-payment-lastname")
    private WebElement lastname;
    
    @FindBy(id="input-payment-email")
    private WebElement email;
    
    @FindBy(id="input-payment-telephone")
    private WebElement telephone;
    
    @FindBy(id="input-payment-address-1")
    private WebElement address;
    
    @FindBy(id="input-payment-city")
    private WebElement city;
    
    @FindBy(id="input-payment-postcode")
    private WebElement postcode;
    
    @FindBy(id="input-payment-password")
    private WebElement password;
    
    @FindBy(id="input-payment-confirm")
    private WebElement confirmpswd;
    
    @FindBy(xpath="//*[@id=\"collapse-payment-address\"]/div/div[4]/div/input[1]")
    private WebElement checkbox;
    
    @FindBy(id="button-register")
    private WebElement register;
   
    @FindBy(id="button-shipping-address")
    private WebElement shipping;
    
    @FindBy(xpath="//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea")
    private WebElement comment;
    
    @FindBy(id="button-shipping-method")
    private WebElement shpng;
    
    @FindBy(xpath="//input[@name='agree']")
	private WebElement checkbox1;
    
    @FindBy(id="button-payment-method")
    private WebElement payment;
    
    @FindBy(id="button-confirm")
    private WebElement cnfrmbtn;
    
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
	public void RegisterBtn() {
		this.RegisterBtn.click();
	}

		public void firstname(String firstname) {
			this.firstname.sendKeys(firstname);
		}
		public void lastname(String lastname) {
			this.lastname.sendKeys(lastname);
		}
		public void email(String email) {
			this.email.sendKeys(email);
		}
		public void telephone(String telephone) {
			this.telephone.sendKeys(telephone);
		}
		public void address(String address) {
			this.address.sendKeys(address);
		}
		public void city(String city) {
			this.city.sendKeys(city);
		}
		public void postcode(String postcode) {
			this.postcode.sendKeys(postcode);
		}
		public void password(String password) {
			this.password.sendKeys(password);
		}
		
		public void confirmpswd(String confirmpswd) {
			this.confirmpswd.sendKeys(confirmpswd);
		}
		
		public void checkbox() {
			this.checkbox.click();
		}
		
		public void register() {
			this.register.click();
		}
		public void shippingbtn() {
			this.shipping.click();
		}
		public void comment(String comment) {
			this.comment.sendKeys(comment);
		}
		public void shpng() {
		this.shpng.click();
}
		public void checkbox1() {
			this.checkbox1.click();
	}
		public void payment() {
			this.payment.click();
	}	
		public void cnfrmbtn() {
			this.cnfrmbtn.click();
	}	
		
}


