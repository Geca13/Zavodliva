package frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frontend.Base;

public class HomePage extends Base {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By header = By.xpath("//section[@class='section-a']//h1");

    public void mainPageIsLoaded(){
        this.isDisplayed(header, 5);
    }

    public void openHomePage() {
        this.visit("https://zavodlivakvecherina.herokuapp.com/");
        this.mainPageIsLoaded();
    }

    public String homePageLinkIsInUrl(){
        return this.returnBrowserUrl();
    }

    public String getHeaderText() {
       return this.getElementText(header);
    }
}
