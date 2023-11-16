package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellPage extends baseDP {
	
	@FindBy(xpath="//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")
	@CacheLookup
	private WebElement atcbtn;
	
	@FindBy(xpath="//span[@class='cart-label']")
	private WebElement shopcart;
	
	public CellPage () {
		PageFactory.initElements(getDriver(), this);
	}

	
	public ShopCartPage choosecell() throws InterruptedException {
		atcbtn.click();
		Thread.sleep(5000);
		shopcart.click();
		return new ShopCartPage();
	}
}
