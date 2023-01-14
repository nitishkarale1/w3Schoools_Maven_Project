package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class w3SchoolsLoginPage 
{
	@FindBy(xpath="//input[@class='EmailInput_input_field__6t4Ux undefined']") private WebElement Email;
	@FindBy(xpath="//input[@type='password']") private WebElement PWD;
	@FindBy(xpath="//span[text()='Log in']") private WebElement LoginBtn;
	
	public w3SchoolsLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpW3SchoolsLoginPageEmail(String emailID)
	{
		Email.sendKeys(emailID);
	}
	
	public void inpW3SchoolsLoginPagePassword(String password)
	{
		PWD.sendKeys(password);
	}
	
	public void clickW3SchoolsLoginPageLoginBtn()
	{
		LoginBtn.click();
	}
	
}
