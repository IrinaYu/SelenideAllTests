import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import static com.codeborne.selenide.Selenide.closeWebDriver;


public class CreateIssue {

  Driver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  CreateIssuePage createIssuePage = null;
  TicketPage ticketPage = null;

  @BeforeMethod
  public void setUp() {
    // Open the browser
    Configuration.browser = "chrome";
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    createIssuePage = new CreateIssuePage(driver);
    ticketPage = new TicketPage(driver);
  }

    @Test
    public void createIssue() {
      loginPage.navigateTo();
      loginPage.enterUserName("IrynaKapustina");
      loginPage.enterPassword("IrynaKapustina");
      loginPage.clickLogin();

      homePage.userNameIsPresent();
      homePage.clickCreate();

      createIssuePage.projectFieldIsClickable();
      createIssuePage.clearProjectField();
      createIssuePage.enterProjectName("Webinar (WEBINAR)");
      createIssuePage.tabProjectName();

      //assertTrue(createIssuePage.issueTypeFieldIsClickable());
      createIssuePage.issueTypeFieldIsClickable();
      createIssuePage.clearIssueTypeField();
      createIssuePage.enterIssueTypeName("Задача");
      createIssuePage.tabIssueType();


      //assertTrue(createIssuePage.summaryFieldIsClickable());
      createIssuePage.summaryFieldIsClickable();
      createIssuePage.enterSummaryName("Some summary");


      //assertTrue(createIssuePage.reporterFieldIsClickable());
      createIssuePage.reporterFieldIsClickable();
      createIssuePage.clearReporterField();
      createIssuePage.enterReporterName("IrynaKapustina");
      createIssuePage.tabReporter();

      createIssuePage.clickSubmit();

      //assertTrue(createIssuePage.popUpIssueName());
      createIssuePage.popUpIssueName();

    }

    @AfterMethod()
    public void closeBrowser() {
      closeWebDriver();
    }

  }