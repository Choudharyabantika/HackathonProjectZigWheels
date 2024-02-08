package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	 protected WebDriver driver;
	
	//constructor of the HomePage class
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void explicitWait(WebElement element,int time) {
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(time));
		mywait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void scrollBy(String pixels) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,"+pixels+")");
		
	}
	
	
	
	public void clickByJs(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	
	public void highlightElement(WebElement element) {
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid black;');", element);
		}catch(Exception e) {}
	}
}
