package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
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


        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(Driver.getDriver().findElement(By.cssSelector("[class='logo pull-left']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        Driver.getDriver().findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
        //6. Enter name and email address
        Driver.getDriver().findElement(By.xpath("//*[@name='name']")).sendKeys("Alp");
        Driver.getDriver().findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("alp112345789@gmail.com");
        //7. Click 'Signup' button
        Driver.getDriver().findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().findElement(By.xpath("//input[@id='id_gender1']")).click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("123abc.1").perform();

        WebElement ddmDays = Driver.getDriver().findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(ddmDays);
        select.selectByVisibleText("5");

        Thread.sleep(3000);
        WebElement ddmMonths = Driver.getDriver().findElement(By.xpath("//select[@id='months']"));
        Select select2 = new Select(ddmMonths);
        select2.selectByVisibleText("April");
        Thread.sleep(3000);

        WebElement ddmyears = Driver.getDriver().findElement(By.xpath("//select[@id='years']"));
        Select select3 = new Select(ddmyears);
        select3.selectByVisibleText("1995");


        //10. Select checkbox 'Sign up for our newsletter!'
        Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        Driver.getDriver().findElement(By.xpath("//*[@id='optin']")).click();

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
        Driver.getDriver().findElement(By.xpath("//*[text()='Create Account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        //1.yol
        // Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        //2.yol
        WebElement accountCreatedisDisplayed = Driver.getDriver().findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreatedisDisplayed.isDisplayed());

        //15. Click 'Continue' button
        Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()=' Logged in as '] ")).isDisplayed());
        //17. Click 'Delete Account' button
        Driver.getDriver().findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String container = Driver.getDriver().findElement(By.xpath("(//*[@class='container'])[2]")).getText();
        Assert.assertFalse(container.contains("ACCOUNT DELETED!"));

    }
}