package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.time.Duration;

public class baseDP {
    private static WebDriver driver;
    private static long implicitWait = 30;
    private static Properties props= new Properties();
    
    public static WebDriver getDriver() {
		return driver;
 
    }

	private String screenshotFolderPath;

    public void baseSetup(String browser) throws InterruptedException {
        
        
        switch (browser) {
        
        
        case "chrome":
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            driver = new ChromeDriver(ops);
            break;
            
            
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

     //   getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://demo.nopcommerce.com/";
        driver.get(url);
	//	getDriver().get(url);
     //   getDriver().manage().window().maximize();
    }

    public String takeScreenShot(String methodName) throws IOException {
        // Use this.screenshotFolderPath to get the folder path.
        String screenshotFolderPath = this.screenshotFolderPath;
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotName = methodName + "_" + timestamp + ".png";
        File targetFile = new File(screenshotFolderPath, screenshotName);
        FileUtils.copyFile(src, targetFile);
        return targetFile.getAbsolutePath();
} 
  
    public static Properties propFileReader() throws IOException {
    	Properties props = new Properties();
        String propfile = "./src/test/resources/config.properties";
        FileReader reader = new FileReader(propfile);
        props.load(reader);
        return props;
    }
    public void tearDown() throws  InterruptedException{
	//	Thread.sleep(5000);
		getDriver().quit();
    
}
}
