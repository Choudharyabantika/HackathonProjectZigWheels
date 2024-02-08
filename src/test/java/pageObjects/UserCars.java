package pageObjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtils;

public class UserCars extends BasePage{

	public UserCars(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//li[contains(@id,'mmvLi')]")
	List<WebElement> popularModels;
	@FindBy(xpath="//li[contains(@id,'mmvLi')]//input[@type='checkbox']")
	List<WebElement> checkBoxes;
	
	@FindBy(xpath="//img[@data-track-label='zw-header-logo']")
	WebElement zigwheels;
	String popularModelofCars="";
	String xfile=System.getProperty("user.dir")+"\\TestData\\testData.xlsx";
	
	public void clickAllPopularModels() throws InterruptedException{
		
		scrollBy("500");
		
		for(WebElement checkBox:checkBoxes) {
			
			Thread.sleep(2000);
			clickByJs(checkBox);
			
		}
		
	}
	
	

	public void getPopularModels() throws IOException {
		System.out.println("Popular Car Models");
		
		for(int i=0;i<popularModels.size();i++) {
			explicitWait(popularModels.get(i),5);
			popularModelofCars=(i+1)+") "+popularModels.get(i).getText();
			ExcelUtils.setcelldata(xfile,"PopularCarModels", i+1, 0, popularModelofCars);
			System.out.println(popularModelofCars);
		}
		
		
	}
	public void navigateBack() {
		zigwheels.click();
	}
	
	

}
