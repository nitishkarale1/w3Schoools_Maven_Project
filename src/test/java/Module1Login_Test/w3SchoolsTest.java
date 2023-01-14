package Module1Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.Base_Class;
import LibraryFiles.Utility_Class;
import Module1Login.w3SchoolsHomePage;
import Module1Login.w3SchoolsLoginPage;

public class w3SchoolsTest extends Base_Class
{
	w3SchoolsLoginPage login;
	w3SchoolsHomePage home;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		initializeBrowser();
		
		login=new w3SchoolsLoginPage(driver);
		home=new w3SchoolsHomePage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws IOException
	{
		login.inpW3SchoolsLoginPageEmail(Utility_Class.getPFData("Email"));
		login.inpW3SchoolsLoginPagePassword(Utility_Class.getPFData("PWD"));
		login.clickW3SchoolsLoginPageLoginBtn();
	}
	
	@Test
	public void verifyUserName() throws EncryptedDocumentException, IOException
	{
		TCID=75;
		
		String exp_UserName=Utility_Class.getTD(0, 0);
		
		home.clickw3SchoolsHomePageProfile();
		Assert.assertEquals(home.getw3SchoolsHomePageUserName(), exp_UserName,"Failed: Both User Names are different.");
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult result) throws IOException, InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.captureSSOfFailedTCes(driver, TCID);
		}
		Thread.sleep(2000);
		
		home.clickw3SchoolsHomePageLogOutBtn();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	
}
