package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.AEPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC2 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Delete Account' button
    //10. Verify that 'ACCOUNT DELETED!' is visible


    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcercise"));

        AEPage aePage = new AEPage();
        SoftAssert softAssert = new SoftAssert();
        //3. Verify that home page is visible successfully
        softAssert.assertTrue(aePage.homepageLogo.isDisplayed());
        //4. Click on 'Signup / Login' button
        aePage.signUpLogin.click();
        //5. Verify 'Login to your account' is visible
        softAssert.assertTrue(aePage.loginToAccount.isDisplayed());
        //6. Enter correct email address and password
        aePage.email.sendKeys(ConfigReader.getProperty("email"));
        aePage.password.sendKeys(ConfigReader.getProperty("password"));
        //7. Click 'login' button
        aePage.loginButton.click();
        //8. Verify that 'Logged in as username' is visible
        softAssert.assertTrue(aePage.loggedAsUsername.isDisplayed());
        //9. Click 'Delete Account' button
        aePage.deleteAccount.click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        softAssert.assertFalse(aePage.accountDeleted.getText().contains("ACCOUNT DELETED!"), "ACCOUNT DELETED ->goruntulenmedi");

        softAssert.assertAll();


    }
}
