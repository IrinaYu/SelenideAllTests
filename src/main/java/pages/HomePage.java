package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

  private Driver driver;

  private SelenideElement userNameDisplay = $(byId("header-details-user-fullname"));
  private SelenideElement createButton = $(byId("create_link"));
  private SelenideElement projectNameField = $(byId("project-field"));


  public HomePage(Driver driver) {
    this.driver = driver;
  }

  public void userNameIsPresent() {
    userNameDisplay.shouldBe(Condition.appear);
  }

  public void clickCreate() {
    createButton.click();
    projectNameField.waitUntil(Condition.visible, 30000);
  }
}