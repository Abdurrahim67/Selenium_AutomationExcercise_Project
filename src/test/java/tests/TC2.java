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

    SoftAssert objSoftAssert = new SoftAssert();
    AEPage objAEpage = new AEPage();

    @Test
    public void login() {


        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationexcercise"));
        //3. Verify that home page is visible successfully
        objSoftAssert.assertTrue(objAEpage.homepageLogo.isDisplayed());
        //4. Click on 'Signup / Login' button
        objAEpage.signUpLogin.click();
        //5. Verify 'Login to your account' is visible
        objSoftAssert.assertTrue(objAEpage.loginToAccount.isDisplayed());
        //6. Enter correct email address and password
        objAEpage.email1.sendKeys(ConfigReader.getProperty("email"));
        objAEpage.password.sendKeys(ConfigReader.getProperty("password"));
        //7. Click 'login' button
        objAEpage.loginButton.click();
        //8. Verify that 'Logged in as username' is visible
        objSoftAssert.assertTrue(objAEpage.loggedAsUsername.isDisplayed());
        //9. Click 'Delete Account' button
        objAEpage.deleteAccount.click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        objSoftAssert.assertFalse(objAEpage.accountDeleted.getText().contains("ACCOUNT DELETED!"),"kelime görüntülenmedi");

        objSoftAssert.assertAll();
        Driver.closeDriver();


    }


}
