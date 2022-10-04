package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.AEPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC3 {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'Login to your account' is visible
//6. Enter incorrect email address and password
//7. Click 'login' button
//8. Verify error 'Your email or password is incorrect!' is visible


    @Test
    public void test01() {
        AEPage objAEPage=new AEPage();
        SoftAssert objSoftAssert=new SoftAssert();

        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationexcercise"));
        //3. Verify that home page is visible successfully
        objSoftAssert.assertTrue(objAEPage.homepageLogo.isDisplayed());
        //4. Click on 'Signup / Login' button
        objAEPage.signUpLogin.click();
        //5. Verify 'Login to your account' is visible
        objSoftAssert.assertTrue(objAEPage.loginToAccount.isDisplayed());
        //6. Enter incorrect email address and password
        objAEPage.email1.sendKeys(ConfigReader.getProperty("incorrectEmail"));
        objAEPage.password.sendKeys(ConfigReader.getProperty("incorrectPassword"));
        //7. Click 'login' button
        objAEPage.loginButton.click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        objSoftAssert.assertTrue(objAEPage.yourEmailIncorrect.isDisplayed());

        objSoftAssert.assertAll();

        Driver.closeDriver();




    }
}
