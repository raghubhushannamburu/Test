package pages;

import java.util.ArrayList;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;
import static pages.BasePage.getActionClassReference;
import static pages.BasePage.getJavaScriptExecutor;

public class HomePage {
	
	By oculusLogo = By.cssSelector("._2v0_");
	By signinLink = By.xpath("//a[contains(text(), 'Log In or Sign Up')]");
	By signinButton = By.xpath("//a[@id='u_0_1v'][contains(text(), 'Sign in')]");
	By headsetsTab = By.id("u_0_x");
	By appsGamesTab = By.id("u_0_y");
	By communityTab = By.id("u_0_15");
	By supportTab = By.id("u_0_17");
	By oculusQuest = By.cssSelector("#u_0_10");
	By buyNowButton = By.xpath("//button[@class='_8166 _4pg_ _3hmq _4phk _4ph1']//span[contains(text(), 'Buy Now')]");
	By oneTwentyEightGB = By.cssSelector("div>.modal__button-wrapper-128");
	By checkoutButton = By.cssSelector("._4ju3._4pg_._3hmq._4phk");
	By navigationLinks = By.cssSelector("._2xvt._wjv._2xvr");
	By containers = By.xpath("//div[@class='_2xvt _wjv _2xvr']/span/a[contains(@data-testid, 'navlink-')]");
	By headsetsDropdown = By.xpath("//div[@class='_2xvy _8yxy _2xvr _7ujs _8yxz']");
	By headsetsDropdownResults = By.xpath("//div[@class='_2xvy _8yxy _2xvr _7ujs _8yxz']/span/a[contains(@data-testid, 'navlink-')]");
	By forumsTab = By.cssSelector("#u_0_17");
	
	WebDriver driver;
	WebDriverWait wait;



	By button1=By.xpath("//button[text()='Accept All Cookies']");
	By productLink=By.xpath("//a[@href='/products']");

	By text=By.xpath("//a[@title='Request a Demo']");


	By demolink=By.xpath("//a[text()='Request Demo']");


	By lastnameLabel=By.xpath("//label[@for='LastName']");
	By FirstnameLabel=By.xpath("//label[@for='FirstName']");

	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean getLogo() {
		 return driver.findElement(oculusLogo).isDisplayed();
	}
	
	public void clickLogInLink() {
		 driver.findElement(signinLink).click();
	}
	
	public void clickSigninLink() {
		 wait.until(ExpectedConditions.elementToBeClickable(signinButton));
		 driver.findElement(signinButton).click();
	}
	
	public void hoverOverCommunityTab() {
		new Actions(driver).moveToElement(driver.findElement(communityTab)).perform();
	}
	
	public void clickOnForumsTab() {
		driver.findElement(forumsTab).click();
	}
	
	public void switchTabs() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
	public void hoverOverHeadsetsTab() {
		new Actions(driver).moveToElement(driver.findElement(headsetsTab)).perform();
		
	}
	
	public List<WebElement> headsetsDropdownResults(){
		return driver.findElement(headsetsDropdown).findElements(headsetsDropdownResults);
	}

	public void clickOculusQuest() {
		driver.findElement(oculusQuest).click();
	}
	
	public void addToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(buyNowButton));
		driver.findElement(buyNowButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(oneTwentyEightGB));
		driver.findElement(oneTwentyEightGB).click();
	}
	
	public boolean isCartPageLoaded() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).isDisplayed();
	}

	public void clickAcceptAllCookiesandproductbutton() {

		try {
			Thread.sleep(3000);
			driver.findElement(button1).click();
		} catch (InterruptedException e) {

		}
	}

	public void  mousehoveronProductlink()	{
		try {
			Actions actions=getActionClassReference();
			Thread.sleep(3000);
			actions.moveToElement(driver.findElement(productLink)).click().perform();
		} catch (InterruptedException e) {

		}

	}
	public void assertedtext() throws InterruptedException {
		Thread.sleep(3000);
		assertEquals(driver.findElement(text).getText(),"Register for Demo");

	}

	public void clickRequestDemoandValidateLabels(){
		try {
			Thread.sleep(1000);

			JavascriptExecutor js=getJavaScriptExecutor();
			js.executeScript("arguments[0].click()", driver.findElement(demolink));
			boolean firstname=driver.findElement(FirstnameLabel).isDisplayed();
			boolean lastname=driver.findElement(lastnameLabel).isDisplayed();
			if(firstname &&lastname){
			  System.out.print("labels matched");
			}
		} catch (InterruptedException e) {

		}
	}
}
