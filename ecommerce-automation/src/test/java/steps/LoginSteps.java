package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import pages.LoginPage;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I open the login page")
    public void openLoginPage() {
    	WebDriverManager.chromedriver().setup();
    	
    	 // Set Chrome preferences to disable password manager and warnings
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void verifyLoginSuccess() {
        // Ví dụ kiểm tra URL hoặc thông báo thành công
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"));
        driver.quit();
    }
}
