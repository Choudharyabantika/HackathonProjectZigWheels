package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePageZigWheels;
import pageObjects.UserCars;

public class TC_003_UsedCarsLocationSpecificTest extends TC_002_UpcomingBikeManufacturers{
	
	HomePageZigWheels hp;
	UserCars usc;
	@Test(priority=6,groups={"sanity","regression","Master"})
	public void navFromUsedCarsToLocation() throws InterruptedException, IOException {
		logger.info("***** TC_003_UsedCarsLocationSpecificTest starting *****");
		hp=new HomePageZigWheels(driver);
		hp.hoverFromUsedCarsToLocation();
		
	}
	@Test(priority=7,groups= {"regression","Master"})
	public void clickAllPopularCarModels() throws InterruptedException {
		usc=new UserCars(driver);
		usc.clickAllPopularModels();
		
		
	}
	
	@Test(priority=8,groups= {"regression","Master"})
	public void fetchAllPopularModels() throws IOException {
		usc=new UserCars(driver);
		usc.getPopularModels();
	}
	@Test(priority=9,groups= {"sanity","regression","Master"})
	public void navigateBackToHome() {
		usc=new UserCars(driver);
		usc.navigateBack();
		logger.info("***** TC_003_UsedCarsLocationSpecificTest finished *****");
	}
	
	

}
