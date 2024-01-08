package tests;


import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage{


	@Test(priority=0)
	public void verifyProductLink() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		//Assert.assertEquals(homePage.getTitle(), "Meta Quest VR Headsets, Accessories & Equipment | Meta Quest | Meta Store", "Title does not match");
		homePage.clickAcceptAllCookiesandproductbutton();
		homePage.mousehoveronProductlink();
		homePage.assertedtext();
		homePage.clickRequestDemoandValidateLabels();

	}




}
