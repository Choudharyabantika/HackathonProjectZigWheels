package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	@BeforeTest(groups={"sanity","regression","Master"})
	@Parameters({"os","browser"})

	public void setup(String os,String br) throws IOException {
		//load properties file
		
		FileReader file =new FileReader(".//src/test/resources/config.properties");
		prop=new Properties();
		prop.load(file);
		
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		chromeOptions.addArguments("--disable-notifications");
		
		EdgeOptions edgeOptions=new EdgeOptions();
		edgeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		edgeOptions.addArguments("--disable-notifications");
		
		//loading log4j2 file
		logger=LogManager.getLogger(this.getClass());
		
		
		  if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		 	{	
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		    }
		 //If execution_env is local then run in local system
		else if(prop.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(chromeOptions); break;
			case "edge": driver=new EdgeDriver(edgeOptions); break;
			default: System.out.println("No matching browser..");
						return;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();
		
	}
	
	@AfterTest(groups={"sanity","regression","Master"})
	public void tearDown() {
		driver.quit();
	}

}
