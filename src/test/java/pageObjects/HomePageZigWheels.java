package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.Screenshot;



public class HomePageZigWheels  extends BasePage {

	public HomePageZigWheels(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="New Bikes")
	WebElement newBikesDropDown;
	
	@FindBy(xpath="//span[text()='Upcoming Bikes']")
	WebElement upcomingBikes;
	@FindBy(linkText="Used Cars")
	WebElement usedCars;
	
	@FindBy(xpath="//div[@class='h-dd-r']//li[4]//span")
	WebElement location;
	
	public void navigateToNewBikesToUpcomingBikes() throws InterruptedException, IOException {
		explicitWait(newBikesDropDown,5);
		Actions act=new Actions(driver);
		act.moveToElement(newBikesDropDown).build().perform();
		Thread.sleep(2000);
		Screenshot ss= new Screenshot(driver);
		ss.takeFullScreenShot("UpcomingBikes");
		highlightElement(upcomingBikes);
		upcomingBikes.click();
	}
	
	
	public void hoverFromUsedCarsToLocation() throws InterruptedException, IOException {
		Actions act=new Actions(driver);
		act.moveToElement(usedCars).build().perform();
		Thread.sleep(2000);
		Screenshot ss=new Screenshot(driver);
		ss.takeFullScreenShot("usedCarsHover");
		highlightElement(location);
		location.click();
	}
	
	
	
}
