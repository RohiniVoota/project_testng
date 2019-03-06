package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC064_AddCategoriesPOM {
	private WebDriver driver; 
	
	public TC064_AddCategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"button-menu\"]/i")
	private WebElement menu;
	
	@FindBy(xpath="//*[@id=\"catalog\"]/a")
	private WebElement catalog;

	@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[1]/a")
	private WebElement categories;

	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a[1]/i")
	private WebElement add;
	
	@FindBy(id="input-name1")
	private WebElement category_name;

	@FindBy(xpath="//*[@id=\"language1\"]/div[2]/div/div/div[3]/div[2]")
	private WebElement Description;
	
	@FindBy(id="input-meta-title1")
	private WebElement meta;
	
	@FindBy(id="input-meta-description1")
	private WebElement meta_desc;
	
	@FindBy(xpath="//*[@id=\"form-category\"]/ul/li[2]/a")
	private WebElement Data;
	
	@FindBy(xpath="//*[@id=\"form-category\"]/ul/li[3]/a")
	private WebElement Design;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement save;
	
    public void sendUserName(String userName) {
	this.userName.clear();
    this.userName.sendKeys(userName);
    }

    public void sendPassword(String password) {
	this.password.clear(); 
	this.password.sendKeys(password); 
    }

     public void clickLoginBtn() {
	  this.loginBtn.click(); 
      }
     public void menu() {
	  this.menu.click();
     }
     public void catalog() {
	  this.catalog.click();
      }
     public void categories() {
   	  this.categories.click();
         }
     public void add() {
      	  this.add.click();
            }
     public void Category_name(String name) {
    		this.category_name.clear(); 
    		this.category_name.sendKeys(name); 
    	    }
     public void Description(String description) { 
 		this.Description.sendKeys(description); 
 	    }
     public void meta(String meta) { 
    	this.meta.clear();
  		this.meta.sendKeys(meta); 
  	    }
     public void meta_desc(String meta_desc) { 
     	this.meta_desc.clear();
   		this.meta_desc.sendKeys(meta_desc); 
   	    }
     public void Data() {
     	  this.Data.click();
           }
     public void Design() {
    	  this.Design.click();
          }
     public void Save() {
   	  this.save.click();
         }
    
    }