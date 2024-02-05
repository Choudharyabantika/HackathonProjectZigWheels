package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.UpcomingBikes;

public class TC_002_UpcomingBikeManufacturers extends TC_001_NewBikes_UpcomingBikes{
	UpcomingBikes upb;
	
	@Test(priority=3,groups= {"regression","Master"})
	public void selectManufacturers() throws IOException, InterruptedException {
		logger.info("***** TC_002_UpcomingBikeManufacturers starting *****");
		upb=new UpcomingBikes(driver);
		logger.info("Selecting Honda in the manufacturer dropdown");
		upb.selectUpcomingBikeFromDropDown();
		
		
	}
	@Test(priority=4,groups={"regression","Master"})
	public void getNewLaunchBikesDetails() throws InterruptedException, IOException{
		logger.info("Fetching newly launched bikes in upcoming bikes Honda section");
		upb.getNewBikes();
	}
	
	@Test(priority=5,groups= {"regression","Master"})
	public void navigateToHomePage() {
		upb.navigateToHomePage();
		logger.info("***** TC_002_UpcomingBikeManufacturers finished *****");
	}

}
