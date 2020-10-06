import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class LoginToJiraWithDataProvider {
  Driver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;

  @BeforeMethod
  public void setUp() {
    // Open the browser
    WebDriverRunner.driver();
    Configuration.browser = "chrome";
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
  }

  @DataProvider(name = "loginNegative")
  public Object[][] createData1() {
    return new Object[][]{
        {"SomeName", "IrynaKapustina", "Sorry, your username and password are incorrect - please try again."},
        {"SomeName", "SomePassword", "Sorry, your username and password are incorrect - please try again."},
        {"IrynaKapustina", "SomePassword", "Sorry, your username and password are incorrect - please try again."},
    };
  }

  @Test(dataProvider = "loginNegative")
  public void unsuccessfulLoginTest(String name, String password, String expectedResult) throws InterruptedException {
    loginPage.navigateTo();
    loginPage.enterUserName(name);
    loginPage.enterPassword(password);
    loginPage.clickLogin();
    loginPage.errorMessageIsPresent(expectedResult);
  }

  @Test
  public void successfulLoginTest() {
    loginPage.navigateTo();
    loginPage.enterUserName("webinar5");
    loginPage.enterPassword("webinar5");
    loginPage.clickLogin();
    homePage.userNameIsPresent();
  }

  @AfterMethod()
  public void tearDown() {
    closeWebDriver();
  }
}