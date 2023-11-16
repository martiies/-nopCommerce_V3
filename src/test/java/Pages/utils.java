package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class utils extends baseDP{
		
	public void takeScreenShot() throws IOException  {
		// Take Screenshot for Evidence
		File srce = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String datetime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File targetfile = new File(System.getProperty("user.dir")+"/test/"+"ErrorStatus_"+datetime+".png");
		
		System.out.println(targetfile);
		// Save the screenshot in the given path by the name FbStatus.png
		FileUtils.copyFile(srce, targetfile);
		
	}
	
	
}
