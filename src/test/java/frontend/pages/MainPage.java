package frontend.pages;

import frontend.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Given("Main page url")
    public void mainPageUrl() {
        this.visit("https://zavodlivakvecherina.herokuapp.com/");
    }

    @Then("Main page header is displayed")
    public void mainPageHeaderIsDisplayed() {
       this.isDisplayed(mainPageHeader(), 5);
    }

    @And("Main page header")
    public By mainPageHeader() {
        return By.xpath("//section[@class='section-a']//h1");
    }
}
