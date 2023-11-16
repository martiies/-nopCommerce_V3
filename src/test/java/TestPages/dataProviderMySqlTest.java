package TestPages;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.MainPage;
import Pages.baseDP;
import Utilities.mySqlConnect;

public class dataProviderMySqlTest extends baseDP{
	
	private WebDriver driver;
	private MainPage mp;
		
	@DataProvider
	public Object[][] mySqlReadData() throws ClassNotFoundException, SQLException {
		
		Object[][] data = mySqlConnect.getMySqlData();
		return data;
	}
	
	@Test(dataProvider = "mySqlReadData")
	public void setUpTest (long id, String url, String browser) throws InterruptedException {
		baseSetup(browser);
		driver = getDriver();
		getDriver().get(url);
		mp = new MainPage(getDriver());
		Assert.assertNotNull(mp,"ERROR: nopCommerce homepage is not launched!");
		tearDown();
	}

}