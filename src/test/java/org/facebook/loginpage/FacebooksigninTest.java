package org.facebook.loginpage;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Facebook.Testing.FaceBookPOMpage;
import Facebook.Testing.LaunchBrowser;

public class FacebooksigninTest extends LaunchBrowser {

	public WebDriver driver;
	@BeforeTest
	public void initialFlow() {
	driver = Browserselection();
	
}
	@Test
	public void faceBooklogin() {
		FaceBookPOMpage fb = new FaceBookPOMpage(driver);
		fb.TXT_username.sendKeys("Mayank.coolhot@gmail.com");
		fb.TXT_password.sendKeys("Test@1234");
		fb.BTN_continue.click();
		String title = driver.getTitle();
		Reporter.log("The title of page is " + title,true);
		}
	
	@Test(dataProvider="datakey")
	public void Facebooklogin1(String username, String Password) {
		FaceBookPOMpage fb = new FaceBookPOMpage(driver);
		fb.TXT_username.sendKeys(username);
		fb.TXT_password.sendKeys(Password);
		fb.BTN_continue.click();
		String title = driver.getTitle();
		Reporter.log("The title of page is " + title,true);
			}
	@DataProvider
	public Object[][]datakey(){
		Object data[][]=new Object[2][2];
		data[0][0]="Mayank.start@gmail.com";
		data[0][1]="password1";
		
		data[1][0]="mayank.started@gmail.com";
		data[1][1]="paasword2";
		return data;
		
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	
		
				
		
	}}

