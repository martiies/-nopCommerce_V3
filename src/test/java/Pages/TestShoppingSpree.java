package Pages;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import org.apache.log4j.PropertyConfigurator;

public class TestShoppingSpree extends baseDP {
	private static final Logger logger = Logger.getLogger(TestShoppingSpree.class);
	private String url = "https://demo.nopcommerce.com/";
	private MainPage mp;
	private CellPage cp;
	private BlueCellPage bcp;
	private ShopCartPage scp;
	private SignInPage sip;
	private CheckoutPage cop;
	private static Logger log;
	private Properties prop;
	private WebDriver driver;
	
	
	@BeforeTest
	public void setUpTest() throws InterruptedException {
		baseSetup("firefox");
        log = Logger.getLogger(MainPage.class.getName());
	    log.info("setting up the browser for the test");

	    try {
	        prop = propFileReader();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    driver = getDriver();
         mp = new MainPage (driver);
         Assert.assertNotNull(mp, "Error - Main Page not displayed");
	/*    baseSetup(prop.getProperty("browser"));

	    if (getDriver() != null) {
	        getDriver().get(prop.getProperty("base_url"));
	        mp = new MainPage(getDriver());
	        Assert.assertNotNull(mp, "Error");
	        log.info("launched successfully");
	    } else {
	        log.error("unable to do it");
	    } */
	}

/*	public static void main(String[] args) {
        String filePath = "path_to_your_excel_file.xlsx";
        String sheetName = "Sheet1";

        Object[][] data = excelDataReader.readExcelData(filePath, sheetName);

        // Now you can use the 'data' array in your test
        for (Object[] row : data) {
            for (Object cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    } */

	
	@Test(priority=0)
	public void hover() throws InterruptedException {
	  
	   cp = mp.hoverElTab();
	   Assert.assertNotNull(cp, "Error");
	    }
	
	
	@Test(priority = 1)
	public void choosecell() throws InterruptedException {
	    try {
	        scp = cp.choosecell();
	        Assert.assertNotNull(scp, "Error");
	        logger.info("Choose cell test successful");
	    } catch (Exception e) {
	        logger.error("Choose cell test failed: " + e.getMessage());
	    }
	}
	
	@Test(priority = 2)
	
	public void gotocheckout() throws InterruptedException {
	    try {
	        sip = scp.checkout();
	        Assert.assertNotNull(sip, "Error");
	        logger.info("Go to checkout test successful");
	    } catch (Exception e) {
	        logger.error("Go to checkout test failed: " + e.getMessage());
	    }
	}
	
	@Test(priority = 3)

	
	public void coguest() throws InterruptedException {
	    try {
	        cop = sip.coguest();
	        Assert.assertNotNull(cop, "Error");
	        logger.info("Checkout as guest test successful");
	    } catch (Exception e) {
	        logger.error("Checkout as guest test failed: " + e.getMessage());
	    }
	}
	
	@Test(priority = 4)
	public void writeinfo() {
	    try {
	        cop.writeinfo("Alice", "Beaumont", "ab@gmail.com", "f", "wonderland", "u", "123 upside", "90210", "831-210-1988");
	        Assert.assertNotNull(cop, "Error");
	        logger.info("Write customer info test successful");
	    } catch (Exception e) {
	        logger.error("Write customer info test failed: " + e.getMessage());
	    }
	}
	
	
	@Test(priority = 5)
	
	public void continue1() throws InterruptedException {
	    try {
	        cop.continue1();
	        Assert.assertNotNull(cop, "Error");
	        logger.info("Continue test successful");
	    } catch (Exception e) {
	        logger.error("Continue test failed: " + e.getMessage());
	    }
	}
	
	@Test(priority = 6)
	public void goback() {
	    try {
	        mp = cop.goback();
	        Assert.assertNotNull(mp, "Error");
	        logger.info("Go back test successful");
	    } catch (Exception e) {
	        logger.error("Go back test failed: " + e.getMessage());
	    }
	}
	
	
	@AfterClass
	public void tearDown() throws  InterruptedException{
		Thread.sleep(5000);
		getDriver().quit();
	}
}
