import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class ViewJiraTicket {

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
  public void viewJIRATicket() {
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
    createIssuePage.popUpIssueName();
    //assertTrue(createIssuePage.popUpIssueName());

    //going to just created ticket from pop up
    createIssuePage.clickLinkIssue();

    //assertTrue(ticketPage.commentButtonIsClickable());
    ticketPage.commentFieldIsClickable();

    //making sure the type issue is displayed
    //assertTrue (ticketPage.issueTypeIsDysplayed());
    ticketPage.issueTypeIsDysplayed();

    //making sure the URL contains of ticket ID
    String URL = WebDriverRunner.url(); //driver.getCurrentUrl();

    String IDTicket = ticketPage.getIssueLink();
    //equals()
    Assert.assertEquals(URL, IDTicket);


  }

  @AfterMethod()
  public void closeBrowser() {
    closeWebDriver();
  }

}