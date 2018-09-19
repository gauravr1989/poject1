package library;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements Constants{
	
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	@Parameters("mBrowser")
	
	
		public void launch(String mBrowser) throws Exception {
			if(mBrowser.equalsIgnoreCase("chrome")){
			 DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "latest");
		       driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		      
		
		}else if(mBrowser.equalsIgnoreCase("firefox")) {
		
			 DesiredCapabilities caps = DesiredCapabilities.firefox();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "latest");
		    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(TEST_URL);

		}


	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
}





