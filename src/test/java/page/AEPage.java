package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AEPage {

    public AEPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(css = "[class='logo pull-left']")
    public WebElement homepageLogo;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLogin;

    @FindBy(xpath = "//*[text()='New User Signup!']")
    public WebElement newUserSignUp;

    @FindBy(xpath = "//*[@name='name']")
    public WebElement name;

    @FindBy(css= "[data-qa='signup-email']")
    public WebElement email2;

    @FindBy(xpath = "//*[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "//*[text()='Enter Account Information']")
    public WebElement enterAccount;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement gender1;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement selectDays;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement selectMonths;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement selectYears;

    @FindBy(css = "input[id='newsletter']")
    public WebElement signUpNewsletter;

    @FindBy(xpath = "//*[@id='optin']")
    public WebElement receiveOurPartners;

    @FindBy(css = "[data-qa='create-account']")
    public WebElement creatAccountButton;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreated;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[text()=' Logged in as '] ")
    public WebElement loggedAsUsername;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccount;

    @FindBy(xpath = "(//*[@class='container'])[2] ")
    public WebElement accountDeleted;

    @FindBy(xpath = "//*[text()='Login to your account']")
    public WebElement loginToAccount;

    @FindBy(xpath = "(//*[@name='email'])[1]")
    public WebElement email1;

    @FindBy(css="input[name='password']")
    public WebElement password;

    @FindBy(css="button[data-qa='login-button']")
    public WebElement loginButton;







}
