package testCase;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageZigWheels;
import pageObjects.UpcomingBikes;
import testBase.BaseClass;


public class TC_001_NewBikes_UpcomingBikes extends BaseClass{
	
	@Test(priority=1,groups={"sanity","Regression","Master"})
	public void navigateNewBikes() throws IOException, InterruptedException {
		logger.info("***** TC_001_NewBikes_UpcomingBikes starting *****");
		HomePageZigWheels hpz= new HomePageZigWheels(driver);
	
		try {
			
			hpz.navigateToNewBikesToUpcomingBikes();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=2,groups= {"Regression","Master"})
	public void verify_UpcomingBikes_section() {
		try {
			UpcomingBikes ub=new UpcomingBikes(driver);
			String upcomingBikes=ub.upcomingBikes.getText();
			logger.info("Checking whether upcoming Bikes page is navigated or not");
			Assert.assertEquals(upcomingBikes,"Upcoming Bikes");
		}catch(Exception e) {
			Assert.fail();
			logger.info("Test case 001 failed");
		}
		
		logger.info("***** TC_001_NewBikes_UpcomingBikes finished *****");
		
	}

	

}
