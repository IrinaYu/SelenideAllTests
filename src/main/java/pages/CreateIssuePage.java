package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateIssuePage {

  private Driver driver;

  private SelenideElement projectNameField = $(byId("project-field"));
  private SelenideElement issueTypeField = $(byId("issuetype-field"));
  private SelenideElement summaryField = $(byId("summary"));
  private SelenideElement reporterField = $(byId("reporter-field"));
  private SelenideElement submitButton = $(byId("create-issue-submit"));
  private SelenideElement popUpSuccessfulCreate = $(byXpath("//*[@id='aui-flag-container']/div"));
  private SelenideElement issueLink = $(byCssSelector("#aui-flag-container>div>div>a"));


  public CreateIssuePage(Driver driver) {
    this.driver = driver;
  }

  //waiting until elements are clickable or displayed
  public void projectFieldIsClickable() {
    projectNameField.shouldBe(Condition.enabled);
  }

  public void issueTypeFieldIsClickable() {
    issueTypeField.shouldBe(Condition.enabled);
  }

  public void summaryFieldIsClickable() {
    reporterField.shouldBe(Condition.enabled);
  }

  public void reporterFieldIsClickable() {
    reporterField.shouldBe(Condition.enabled);
  }

  public void popUpIssueName() {
    popUpSuccessfulCreate.waitUntil(Condition.visible,30000);
  }

  //clearing fields
  public void clearProjectField() {
    projectNameField.clear();
  }

  public void clearIssueTypeField() {
    issueTypeField.clear();
  }

  public void clearReporterField() {
    reporterField.clear();
  }

  //sending string keys
  public void enterProjectName(String projectName) {
    projectNameField.setValue(projectName);
  }

  public void enterIssueTypeName(String issueTypeName) {
    issueTypeField.setValue(issueTypeName);
  }

  public void enterSummaryName(String summaryName) {
    summaryField.setValue(summaryName);
  }

  public void enterReporterName(String reporterName) {
    reporterField.setValue(reporterName);
  }

  //sending TAB to fields
  public void tabProjectName() {
    projectNameField.pressTab();
  }

  public void tabIssueType() {
    issueTypeField.pressTab();
  }

  public void tabReporter() {
    reporterField.pressTab();
  }

  //clicking
  public void clickSubmit() {
    submitButton.click();
  }

  public void clickLinkIssue() {
    issueLink.click();
  }

}