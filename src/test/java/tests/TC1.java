package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.AEPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC1 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button



    @Test
    public void test01() throws InterruptedException {

        SoftAssert objSoftAssert = new SoftAssert();
        AEPage objAEpage = new AEPage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationexcercise"));
        //3. Verify that home page is visible successfully
        objSoftAssert.assertTrue(objAEpage.homepageLogo.isDisplayed());
        //4. Click on 'Signup / Login' button
        objAEpage.signUpLogin.click();
        //5. Verify 'New User Signup!' is visible
        objSoftAssert.assertTrue(objAEpage.newUserSignUp.isDisplayed());
        //6. Enter name and email address
        objAEpage.name.sendKeys(ConfigReader.getProperty("name"));
        objAEpage.email2.sendKeys(ConfigReader.getProperty("email"));
        //7. Click 'Signup' button
        objAEpage.signUpButton.click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(objAEpage.enterAccount.isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        Actions actions = new Actions(Driver.getDriver());

        objAEpage.gender1.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).perform();

        WebElement ddmDays = objAEpage.selectDays;
        Select select = new Select(ddmDays);
        select.selectByVisibleText("5");

        Thread.sleep(3000);

        WebElement ddmMonths = objAEpage.selectMonths;
        Select select2 = new Select(ddmMonths);
        select2.selectByVisibleText("April");

        Thread.sleep(3000);

        WebElement ddmyears = objAEpage.selectYears;
        Select select3 = new Select(ddmyears);
        select3.selectByVisibleText("1995");

        //10. Select checkbox 'Sign up for our newsletter!'
        objAEpage.signUpNewsletter.click();
        //11. Select checkbox 'Receive special offers from our partners!'
        objAEpage.receiveOurPartners.click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Faker faker = new Faker();
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.company().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.address().lastName())
                .sendKeys(Keys.TAB).sendKeys("Canada")
                .sendKeys(Keys.TAB).sendKeys(faker.address().state())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys("123456").perform();
        //13. Click 'Create Account button'
        objAEpage.creatAccountButton.click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        objSoftAssert.assertTrue(objAEpage.accountCreated.isDisplayed());
        //15. Click 'Continue' button
        objAEpage.continueButton.click();
        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(objAEpage.loggedAsUsername.isDisplayed());
        //17. Click 'Delete Account' button
        objAEpage.deleteAccount.click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        objSoftAssert.assertFalse(objAEpage.accountDeleted.getText().contains("ACCOUNT DELETED!"),"kelime görüntülenmedi");

        objSoftAssert.assertAll();
        Driver.closeDriver();


    }
}