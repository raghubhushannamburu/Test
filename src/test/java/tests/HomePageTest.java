package tests;


import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage{


	@Test(priority=0)
	public void verifyProductLink() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		homePage.clickAcceptAllCookiesandproductbutton();
		homePage.mousehoveronProductlink();
		homePage.assertedtext();
		homePage.clickSolutionsandCheckfinancialAccountingRL();
		homePage.clickRequestDemoandValidateLabels();



	}




}
