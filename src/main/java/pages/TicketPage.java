package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;


public class TicketPage {


  private Driver driver;

  private SelenideElement createCommentButton = $(byCssSelector("#footer-comment-button"));
  private SelenideElement commentField = $(byId("comment-wiki-edit"));
  private SelenideElement textTab = $(byXpath("//*[@id=\"comment-wiki-edit\"]/nav/div/div/ul/li[2]/a"));
  private SelenideElement textInput = $(byId("comment"));
  private SelenideElement typeIssue = $(byXpath("//*[@id='issuedetails']//child::*[@id='type-val']"));
  private SelenideElement issueLink = $(byCssSelector("a#key-val.issue-link"));


  public TicketPage(Driver driver) {
    this.driver = driver;
  }

  //waiting until elements are clickable or displayed
  public void commentButtonIsClickable() {
    createCommentButton.shouldBe(Condition.enabled);
  }

  public void commentFieldIsClickable() {
    commentField.shouldBe(Condition.enabled);
  }

  public void textInputFieldIsPresent() {
    textInput.shouldBe(Condition.appear);
  }

  public String getTextInputValue() {
    return (textInput.shouldBe(Condition.appear).getAttribute("value"));
  }

  public void issueTypeIsDysplayed() {
    typeIssue.shouldBe(Condition.appear);
  }

  //clearing fields
  public void clearTextField() {
    textInput.clear();
  }

  //sending string keys
  public void enterComment(String comment) {
    textInput.setValue(comment);
  }

  //clicking
  public void clickCommentButton() {
    createCommentButton.click();
  }

  public void clickTextTab() {
    textTab.click();
  }

  //getting attribute
  public String getIssueLink() {
    return (issueLink.getAttribute("href"));
  }
}