package frontend.components;

import frontend.BaseZavodliva;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends BaseZavodliva {
    public Navigation(WebDriver driver) {
        super(driver);
    }

    @Then("New show link is displayed")
    public By newShowLinkIsDisplayed() {
      return By.xpath("//a[@href='/new']");
    }

    @Given("Login icon")
    public By loginIcon() {
       return By.id("login-open-popup");
    }

    @And("Login icon is displayed")
    public void loginIconIsDisplayed() {
        this.isDisplayed(loginIcon(), 5);
    }

    @Then("Click login icon")
    public void clickLoginIcon() {
        this.click(loginIcon());
    }
}
