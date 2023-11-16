package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends baseDP {
	
	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']")
	@CacheLookup
	private WebElement firstnamebox;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']")
	@CacheLookup
	private WebElement lastnamebox;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Email']")
	@CacheLookup
	private WebElement emailbox;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	@CacheLookup
	private WebElement countrybox;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_StateProvinceId']")
	@CacheLookup
	private WebElement statebox;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	@CacheLookup
	private WebElement citybox;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	@CacheLookup
	private WebElement addressbox;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	@CacheLookup
	private WebElement zipbox;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	@CacheLookup
	private WebElement phonebox;
	
	@FindBy(xpath="//button[@onclick='Billing.save()']")
	private WebElement continuebtn;
	
	@FindBy(xpath="//button[@class='button-1 shipping-method-next-step-button']")
	@CacheLookup
	private WebElement continuebtn2;
	
	@FindBy(xpath="//button[@class='button-1 payment-method-next-step-button']")
	@CacheLookup
	private WebElement continuebtn3;
	
	@FindBy(xpath="//button[@class='button-1 payment-info-next-step-button']")
	@CacheLookup
	private WebElement continuebtn4;
	
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	@CacheLookup
	private WebElement confirmbtn;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	@CacheLookup
	private WebElement finalcontinue;

	
	public CheckoutPage(){
		PageFactory.initElements(getDriver(), this);
	}

	public CheckoutPage writeinfo(String fname, String lname, String email, String country ,  String city , String state ,String address , String zip , String phone ){
		firstnamebox.sendKeys(fname);
		lastnamebox.sendKeys(lname);
		emailbox.sendKeys(email);
		countrybox.sendKeys(country);
		citybox.sendKeys(city);
		statebox.sendKeys(state);
		addressbox.sendKeys(address);
		zipbox.sendKeys(zip);
		phonebox.sendKeys(phone);
		return this;
		}
	
		
	
	public CheckoutPage continue1() throws InterruptedException {
		Thread.sleep(3000);
		continuebtn.click();
		Thread.sleep(3000);
		continuebtn2.click();
		Thread.sleep(3000);
		continuebtn3.click();
		Thread.sleep(3000);
		continuebtn4.click();
		Thread.sleep(3000);
		confirmbtn.click();
		Thread.sleep(3000);
		return this;
	}
		public MainPage goback() {
		finalcontinue.click();
		return new MainPage(null);
			
		}
		}


	

