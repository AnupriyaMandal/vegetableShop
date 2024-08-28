package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public Properties p;
	
	
	@BeforeTest(groups="Master")
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		/*if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities(); 
			
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome"); break;
			case "edge":cap.setBrowserName("edge"); break;
			case "firefox":cap.setBrowserName("firefox"); break;
			default: System.out.println("Invalid browser name"); return;
			}
			driver=new RemoteWebDriver(new URL("http://192.168.1.3:4444/wd/hub"),cap);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) {
			case "chrome" : driver=new ChromeDriver();
			break;
			case "edge" :driver=new EdgeDriver();
			break;
			case "firefox" :driver=new FirefoxDriver();
			break;
			default : System.out.println("Invalid browser name...");
			return;
		}*/
			
			
			switch(br.toLowerCase()) {
			case "chrome" : driver=new ChromeDriver();
			break;
			case "edge" :driver=new EdgeDriver();
			break;
			case "firefox" :driver=new FirefoxDriver();
			break;
			default : System.out.println("Invalid browser name...");
			return;
	}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get(p.getProperty("Appurl"));  //reading url from properties file
		driver.manage().window().maximize();
		
		 logger.info("Setup complete.");
		}
		
	 
	@AfterTest()
	public void tearDown() {
		if(driver !=null) {
			
		driver.quit();
		logger.info("Teardown complete.");}

	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
