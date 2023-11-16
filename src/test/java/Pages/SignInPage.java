package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends baseDP {
	
/*	@FindBy(xpath="//h1[normalize-space()='Welcome, Please Sign In!']")
	@CacheLookup
	private WebElement banner;
	
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	private WebElement emailbox;
	
	@FindBy(xpath="//input[@id='Password']")
	@CacheLookup
	private WebElement passwordbox;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	@CacheLookup
	private WebElement libtn; */
	
	@FindBy(xpath="//button[normalize-space()='Checkout as Guest']")
	@CacheLookup
	private WebElement guestco;
	
	public SignInPage(){
		PageFactory.initElements(getDriver(), this);
	}

/*	public boolean bannervalidation() {
		String expectedText = "Welcome, Please Sign In!";
		String actualText = banner.getText().trim();
		return actualText.equals(expectedText);
	}
	*/
	
/*	public SignInPage writetxt(String email , String password) {
		emailbox.sendKeys(email);
		passwordbox.sendKeys(password);
		return this;
		}
	
	public CheckoutPage clickli() throws InterruptedException {
		libtn.click();
		return new CheckoutPage();
	}
	
	*/
	
	public CheckoutPage coguest() throws InterruptedException {
	guestco.click();
	return new CheckoutPage();
	
	}
	
}
