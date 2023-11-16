package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueCellPage extends baseDP {
	
	@FindBy(xpath="//input[@id='product_attribute_12']")
	@CacheLookup
	private WebElement textbox;
	
	@FindBy(xpath="//button[@id='add-to-cart-button-19']")
	@CacheLookup
	private WebElement atcbtn; 
	
	@FindBy(xpath="//span[@class='cart-label']")
	@CacheLookup
	private WebElement shcartbtn;
	
	public BlueCellPage (){
		PageFactory.initElements(getDriver(), this);
	}
	
/*	public BlueCellPage writetxt(String TStext) {
		textbox.sendKeys(TStext);
		return this;
		}
	*/
	
	public ShopCartPage clickSC() throws InterruptedException {
		atcbtn.click();
		Thread.sleep(5000);
		shcartbtn.click();
		return new ShopCartPage();
	}

}
