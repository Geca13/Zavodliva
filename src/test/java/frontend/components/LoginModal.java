package frontend.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frontend.Base;

public class LoginModal extends Base {

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    By modal = By.className("content");
    By usernameInput = By.name("username");
    By passwordInput = By.name("password");
    By submitBtn = By.xpath("//button[@type='submit']");

    public void loginModalIsOpened(){
        this.isDisplayed(modal, 5);
    }


    public void loginAsAdmin(){
        this.type("email@email.com", usernameInput);
        this.type("Password@123", passwordInput);
        this.click(submitBtn);
    }

    public void failLoginAsAdmin(){
        this.type("email99@email.com", usernameInput);
        this.type("Password@123", passwordInput);
        this.click(submitBtn);
    }
}
