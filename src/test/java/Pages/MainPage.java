package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends baseDP {
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
	@CacheLookup
	private WebElement eltab;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")
	@CacheLookup
	private WebElement celltab;
	
	
	public MainPage(WebDriver webDriver){
		PageFactory.initElements(getDriver(), this);
	}

	public CellPage hoverElTab() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(eltab).perform();
        Thread.sleep(3000);
        celltab.click();
        return new CellPage();
    }
	
}
