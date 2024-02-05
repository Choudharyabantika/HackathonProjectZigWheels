package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;


public class Screenshot extends BasePage{
	
	public Screenshot(WebDriver driver) {
		super(driver);
		
	}
	public String takeFullScreenShot(String name) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String file_path=System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
	File trg=new File(file_path);
	FileUtils.copyFile(src, trg);
	return file_path;
	
}
public String takeSectionScreenshot(String name,WebElement section) throws IOException {
	
	File src=section.getScreenshotAs(OutputType.FILE);
	String file_path=System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
	File trg=new File(file_path);
	FileUtils.copyFile(src, trg);
	return file_path;
}

}
