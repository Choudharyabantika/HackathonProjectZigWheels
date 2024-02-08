package pageObjects;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtils;
import utilities.Screenshot;

public class GoogleLogin extends BasePage{
	
	
	public GoogleLogin(WebDriver driver) {
		super(driver);
		
	}
	//Elements
	@FindBy(xpath="//div[@class='h-sid h-sid-s fnt-14']")
	WebElement btnLoginSignUp;
	@FindBy(xpath="//div[@class='d-tblc rel']//div[@data-track-label='Popup_Login/Register_with_Google']")
	WebElement btnRegWithGoogle;
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement txtEmail;
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement clickNextButton;
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement errorMesg;
	String xfile=System.getProperty("user.dir")+"\\TestData\\testData.xlsx";
	Screenshot ss;
	
	//Actions
	public void clickOnLoginSignUp() {
		btnLoginSignUp.click();
	}
	public void clickRegisterWithGoogle() {
		highlightElement(btnRegWithGoogle);
		btnRegWithGoogle.click();
		Set<String> winHandleBefore = driver.getWindowHandles();  // Handle browser window switch driver to OneCognizant Page
 
		for(String winHandle : winHandleBefore){
			String title = driver.switchTo().window(winHandle).getTitle();
			if(title.equals("Sign in - Google Accounts")) {
				driver.switchTo().window(winHandle);
			}
		}
	}
	public void loginWithEmail() throws IOException {
		String email=ExcelUtils.getcelldata(xfile,"Validation", 1, 0);
		txtEmail.sendKeys(email);
		clickNextButton.click();
	}
	public String getErrorMessage() {
		try{
			Thread.sleep(2000);
			ss=new Screenshot(driver);
			ss.takeFullScreenShot("Error Message");
			String er = errorMesg.getText();
			ExcelUtils.setcelldata(xfile, "Validation", 1, 1, er);
			return er;
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
}
