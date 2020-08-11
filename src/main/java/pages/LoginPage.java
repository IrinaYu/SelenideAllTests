package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

  private Driver driver;

  private SelenideElement userNameInput = $(byId("login-form-username"));
  private SelenideElement passwordInput = $(byId("login-form-password"));
  private SelenideElement loginButton = $(byId("login"));
  private String message = "Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз.";
  private SelenideElement errorMessage = $(byXpath("//*[text()[contains(.,'" + message + "')]]"));

  public LoginPage(Driver driver) {

    this.driver = driver;
  }

  public void enterUserName(String name) {
    userNameInput.setValue(name);
  }

  public void enterPassword(String password) {
    passwordInput.setValue(password);
  }

  public void clickLogin() {
    loginButton.click();
  }

  public void navigateTo() {
    open("https://jira.hillel.it/secure/Dashboard.jspa");
  }

  public void errorMessageIsPresent(String message) {
    errorMessage.waitUntil(Condition.visible,10000);
  }
}