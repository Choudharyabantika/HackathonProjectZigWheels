package pageObjects;


import java.io.IOException;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtils;
import utilities.Screenshot;

public class UpcomingBikes extends BasePage{

	public UpcomingBikes(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//ol[@class='breadcrumb']//span[text()='Upcoming Bikes']")
	public WebElement upcomingBikes;
	
	@FindBy(xpath="//select[@id='makeId']")
	WebElement manufacturer;
	
	@FindBy(xpath="//img[@data-track-label='zw-header-logo']")
	WebElement zigwheels;
	
	@FindBy(xpath="//span[@data-track-label='view-more-models-button']")
	WebElement seeMore;
	
	@FindBy(xpath="//a[@data-track-label='model-name']")	
	List<WebElement> modelName;
	@FindBy(xpath="//a[@data-track-label='model-name']//following-sibling::div[1]")
	List<WebElement> price;
	@FindBy(xpath="//a[@data-track-label='model-name']//following-sibling::div[2]")
	List<WebElement> date;
	
	@FindBy(xpath="//ul[@class='mk-row srp_main_div clr']//li[contains(@class,'col-lg-4 txt-c rel modelItem')]")
	List<WebElement> bikeAvailable;
	String xfile=System.getProperty("user.dir")+"\\TestData\\testData.xlsx";
	Screenshot ss;
	
	public void selectUpcomingBikeFromDropDown() throws IOException, InterruptedException {
		manufacturer.click();
		ss=new Screenshot(driver);
		Select select=new Select(manufacturer);
		Thread.sleep(2000);
		ss.takeFullScreenShot("Manufacturers");
		select.selectByVisibleText("Honda");
		
		
	}
	
	
	public void getNewBikes() throws InterruptedException, IOException{
		scrollBy("1300");
		clickByJs(seeMore);
		ss=new Screenshot(driver);
		ss.takeFullScreenShot("Upcoming Honda Bikes");
		Thread.sleep(2000);
		int j=1;
		for(int i=0;i<modelName.size();i++) 
			{
					if(Integer.parseInt(bikeAvailable.get(i).getAttribute("data-price"))<400000 )
								{	
									ExcelUtils.setcelldata(xfile, "NewBikes", j, 0, modelName.get(i).getText());
									System.out.println(modelName.get(i).getText());
									ExcelUtils.setcelldata(xfile, "NewBikes", j, 1, price.get(i).getText());
									System.out.println(price.get(i).getText());
									ExcelUtils.setcelldata(xfile, "NewBikes", j, 2, date.get(i).getText());
									System.out.println(date.get(i).getText());
									System.out.println("=================================");
									j++;
									
									
								}
					else {
							continue;
						 }
					
			}
					
	}
	
	public void navigateToHomePage() {
		zigwheels.click();
		
		}
	
	}
	


