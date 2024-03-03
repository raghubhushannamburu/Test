package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import util.PathHelper;

public class BasePage {

	public static WebDriver driver;
	String url = "https://www.automationanywhere.com/";
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeClass(alwaysRun=true)
	public void setup(ITestContext context) {
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", PathHelper.getBasePath() + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}


	public static Actions getActionClassReference() {
		Actions action = new Actions(driver);
		return action;
	}

	public static JavascriptExecutor getJavaScriptExecutor() {
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		return obj;
	}

}
