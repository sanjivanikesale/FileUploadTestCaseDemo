package webAutomation.FileUpload.base;
import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest 
{
	protected WebDriver driver;
	protected Logger log;	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	WebElement fileUploadLink;

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, ITestContext context) 
	{
			String testname = context.getCurrentXmlTest().getName();
			String log4jConfPath ="src/main/resources/log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			log = LogManager.getLogger(testname);
		   
			// Create driver
		    log.info("Creating driver");		
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    
		    this.testSuiteName = context.getSuite().getName();
			this.testName = testname;
			this.testMethodName = method.getName();
		    
		    log.info("Launching website");
			
			// Open URL
			String url = "http://the-internet.herokuapp.com/";
			driver.get(url);
			log.info("Main page is opened.");
			
			fileUploadLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[18]/a"));
			fileUploadLink.click();
	}
		
	@AfterMethod(alwaysRun = true)
	public void tearDown() 
	{
		log.info("Close driver");
		// Close browser
		driver.quit();
	}
}