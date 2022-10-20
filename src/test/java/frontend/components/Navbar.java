package frontend.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frontend.Base;

public class Navbar extends Base {

    public Navbar(WebDriver driver) {
        super(driver);
    }

    By menu = By.id("menu-list");

    By newShowLink = By.xpath("//a[@href='/new']");

    By loginIcon = By.id("login-open-popup");

    public void navbarLinksMenuIsDisplayed(){
        this.isDisplayed(menu, 5);
    }

    public void newShowNavLinkIsDisplayed(){
        this.isDisplayed(newShowLink, 5);
    }

    public void clickLoginIcon() {
        this.click(loginIcon);
    }
}
