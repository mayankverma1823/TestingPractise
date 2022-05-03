package Facebook.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPOMpage {
	@FindBy(id="email")
	public WebElement TXT_username;
	@FindBy(id="pass")
	public WebElement TXT_password;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement BTN_continue;
public WebDriver driver;
	
	public FaceBookPOMpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement userName() {
		return TXT_username;
	}
	public WebElement password()
	{
		return TXT_password;
		}
	public WebElement continueButton() {
		return BTN_continue;
	}
		
}
