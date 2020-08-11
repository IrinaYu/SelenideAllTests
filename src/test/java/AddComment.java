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


public class AddComment {

  Driver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  CreateIssuePage createIssuePage = null;
  TicketPage ticketPage = null;

  @BeforeMethod
  public void setUp() {
    // Open the browser
    WebDriverRunner.driver();
    Configuration.browser = "chrome";
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    createIssuePage = new CreateIssuePage(driver);
    ticketPage = new TicketPage(driver);
  }

  @Test
  public void addComment() {
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
    createIssuePage.issueTypeFieldIsClickable();
    createIssuePage.clearIssueTypeField();
    createIssuePage.enterIssueTypeName("Задача");
    createIssuePage.tabIssueType();
    createIssuePage.summaryFieldIsClickable();
    createIssuePage.enterSummaryName("Some summary");
    createIssuePage.reporterFieldIsClickable();
    createIssuePage.clearReporterField();
    createIssuePage.enterReporterName("IrynaKapustina");
    createIssuePage.tabReporter();
    createIssuePage.clickSubmit();
    createIssuePage.popUpIssueName();
    //going to just created ticket from pop up
    createIssuePage.clickLinkIssue();
    ticketPage.commentButtonIsClickable();
    //clicking on the button "comment" and  finding comment input
    ticketPage.clickCommentButton();
    ticketPage.commentFieldIsClickable();
    ticketPage.clickTextTab();
    ticketPage.textInputFieldIsPresent();
    //inputting of comment and checking for text "Some comment"
    ticketPage.clearTextField();
    ticketPage.enterComment("Some comment");
    String myComment = ("Some comment");
    String typedComment = ticketPage.getTextInputValue();
    Assert.assertEquals(myComment, typedComment);
    //clearing the comment and checking if the input field is clear
    ticketPage.clearTextField();
    String clearedInputField = ticketPage.getTextInputValue();
    Assert.assertNotEquals(clearedInputField, myComment);
  }

  @AfterMethod()
  public void closeBrowser() {
    closeWebDriver();
  }
}