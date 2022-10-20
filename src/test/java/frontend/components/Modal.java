package frontend.components;

import frontend.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Modal extends Base {
    public Modal(WebDriver driver) {
        super(driver);
    }

    By usernameInput = By.name("username");
    By passwordInput = By.name("password");
    By submitBtn = By.xpath("//button[@type='submit']");

    @Given("Login modal is displayed")
    public By loginModalIsDisplayed() {
        return By.className("content");
    }

    @And("Login with valid credentials")
    public void loginWithValidCredentials() {
        this.type("email@email.com", usernameInput);
        this.type("Password@123", passwordInput);
        this.click(submitBtn);
    }
}
