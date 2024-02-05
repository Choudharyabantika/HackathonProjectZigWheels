package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.GoogleLogin;

public class TC_004_VerifyInvalidUser extends TC_003_UsedCarsLocationSpecificTest{
	
	GoogleLogin gl;
	
	@Test(priority=10,groups={"sanity","Master"})
	public void clickOnLogin() throws IOException{
		logger.info("***** TC_004_VerifyInvalidUser starting *****");
		gl=new GoogleLogin(driver);
		logger.info("Clicking on login button");
		gl.clickOnLoginSignUp();
		logger.info("click on google");
		gl.clickRegisterWithGoogle();
		logger.info("Registring with invalid email id");
		gl.loginWithEmail();
		
	}
	
	@Test(priority=11,groups= {"sanity","Master"})
	public void fetchErrorMessage() throws InterruptedException, IOException {
		gl=new GoogleLogin(driver);
		String error_msg=gl.getErrorMessage();
		logger.info("Printing the error message of invalid google login");
		System.out.println("========================");
		System.out.println("Error====>"+error_msg);
		logger.info("***** TC_004_VerifyInvalidUser finished *****");
		}
}
