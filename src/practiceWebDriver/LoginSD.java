package practiceWebDriver;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import database.DbConnect;
 
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.vault.login.LoginO;
import pageobject.vault.vault.VaultLandingO;
 
public class LoginSD {
 
    public WebDriver driver;
    LoginO loginObj;
    VaultLandingO vaultLandingO;
    DbConnect dbConnect = new DbConnect();
 
    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
 
    @Given("^I navigate to login page$")
    public void I_navigate_to_login_page() throws Throwable {
        driver.get("http://staging01-bifrost01.actiocms.com/login.cfm");
 
    }
 
    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void I_enter_and(String usernameArg, String passwordArg) throws Throwable {
        loginObj = new LoginO(driver);
        loginObj.fill_login_credentials(usernameArg, passwordArg);
 
    }
 
    @When("^I click the login button with valid credentials$")
    public void I_click_the_login_button_with_valid_credentials() throws Throwable {
        vaultLandingO = loginObj.signinValidCredentials();
    }
 
    @Then("^I am in landing page$")
    public void I_am_in_landing_page() throws Throwable {
        Assert.assertEquals(vaultLandingO.vaultLandingUrl(), "http://staging01-bifrost01.actiocms.com/search.cfm");
    }
 
    @Then("^I see correct firstname and lastname for the \"([^\"]*)\"$")
    public void I_see_correct_firstname_and_lastname_for_the(String usernameArg) throws Throwable {
        Assert.assertEquals(vaultLandingO.loggedInUsername(), dbConnect.getValueFromColumn("FirstName", usernameArg)
                + " " + dbConnect.getValueFromColumn("LastName", usernameArg));
    }
 
    @When("^I click the login button with invalid credentials$")
    public void I_click_the_login_button_with_invalid_credentials() throws Throwable {
        loginObj.signinInvalidCredentials();
    }
 
    @Then("^I should get error message for invalid credentials$")
    public void I_should_get_error_message_for_invalid_credentials() throws Throwable {
        //Assert.assertEquals(loginObj.loginErrorMsg(), "Invalid username/password combination.");
        Assert.assertEquals(loginObj.loginErrorMsg(), "bla bla bla");
    }
 
    @Then("^I am in login page$")
    public void I_am_in_login_page() throws Throwable {
        Assert.assertEquals(loginObj.loginPageUrl(), "http://staging01-bifrost01.actiocms.com/login.cfm");
    }
 
    @Then("^I should get error message for blank credentials$")
    public void I_should_get_error_message_for_blank_credentials() throws Throwable {
        Assert.assertEquals(loginObj.errorMsgForBlank(), "* Required");
    }
 
    @After
    public void closeBrowser() {
        driver.quit();
    }
 
}