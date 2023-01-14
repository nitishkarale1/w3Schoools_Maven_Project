package Module1Login;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class w3SchoolsHomePage 
{
	@FindBy(xpath="//a[text()='Profile']") private WebElement Profile;
	@FindBy(xpath="//div[@class='Profile_displayName__CjeEc']") private WebElement UserName;
	@FindBy(xpath="//button[text()='Log out']") private WebElement LogOutBtn;
	
	public w3SchoolsHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickw3SchoolsHomePageProfile()
	{
		Profile.click();
	}
	
	public String getw3SchoolsHomePageUserName()
	{
		String act_UserName = UserName.getText();
		return act_UserName;
	}
	
	
	public void clickw3SchoolsHomePageLogOutBtn()
	{
		LogOutBtn.click();
	}
	
}
