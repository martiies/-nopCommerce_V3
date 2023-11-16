package TestPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.MainPage;
import Pages.baseDP;
import Utilities.excelDataReadBACKUP;

public class dataProviderExcelTest extends baseDP{
	private WebDriver driver;
	private MainPage mp;
	
/*	@BeforeClass
	public void setUpTest() throws InterruptedException {
		baseSetup("firefox");
		driver = getDriver();
		getDriver().get("https://demo.nopcommerce.com/");
		mp = new MainPage(getDriver());
	} */
	
	@DataProvider
	public Object[][] readExcelData() throws InvalidFormatException {
		Object[][] inputdata = null;
		try {
			inputdata = excelDataReadBACKUP.getTestData("Sheet1");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(inputdata[0][0]);
		return inputdata;
	}
	
	@Test(dataProvider = "readExcelData")
	public void loginTest(String browser, String url, String unknown) throws InterruptedException {
	baseSetup(browser);
	// driver = getDriver();
	//getDriver().get(url);
	Thread.sleep(3000);
	//mp = new MainPage(driver);
	//Assert.assertNotNull(mp, "Error!");
	getDriver().quit();
	}
	


}
