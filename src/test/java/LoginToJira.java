import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.*;

public class LoginToJira {
  Driver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;

  @BeforeMethod
  public void setUp() {
    Configuration.browser = "chrome";
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
  }


  @Test
  public void loginTest() {
    loginPage.navigateTo();
    loginPage.enterUserName("IrynaKapustina");
    loginPage.enterPassword("IrynaKapustina");
    loginPage.clickLogin();
    homePage.userNameIsPresent();
  }


  @AfterMethod()
  public void closeBrowser() {
    closeWebDriver();
  }
}