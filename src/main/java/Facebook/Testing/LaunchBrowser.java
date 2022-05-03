package Facebook.Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser implements appConst{
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver Browserselection() {
		try {
			prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\MayankWorkspace\\Testing\\Data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("Browser");
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox")){
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("No driver initiated");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(APP_URL);
		
		
	}catch(Exception e) {
		System.out.println("issue with code");
	}
		return driver;
		
	

}
	public void screenShot(String Testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/"+Testcasename+".png"));
		
		
		
	}
	}
