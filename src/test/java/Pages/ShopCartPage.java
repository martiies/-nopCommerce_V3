package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopCartPage extends baseDP {
	
	@FindBy(xpath="//span[@class='product-subtotal']")
	@CacheLookup
	private WebElement totbox; 
	
	@FindBy(xpath="//input[@id='termsofservice']")
	@CacheLookup
	private WebElement toscb;
	
	@FindBy(xpath="//button[@id='checkout']")
	@CacheLookup
	private WebElement cobtn;
	
	public ShopCartPage(){
		PageFactory.initElements(getDriver(), this);
	}

	
	
/*	public String getTotboxText() {
        return totbox.getText().trim();
    } */
	
	public SignInPage checkout() throws InterruptedException {
		toscb.click();
		Thread.sleep(3000);
		cobtn.click();
		return new SignInPage();
	}
}
