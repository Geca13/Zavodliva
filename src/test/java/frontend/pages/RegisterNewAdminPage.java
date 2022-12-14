package frontend.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import frontend.BaseZavodliva;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterNewAdminPage extends BaseZavodliva {
    public RegisterNewAdminPage(WebDriver driver) {
        super(driver);
    }

    By email = By.id("email");
    By password = By.id("password");
    By submitBtn = By.xpath("(//button[@class='button'])[2]");

    public void loadNewAdminPage(){
        this.visit("https://zavodlivakvecherina.herokuapp.com/registerNewAdminForKvecherina");

    }

    public void registerNewAdmin(ExtentTest test){
        this.type("email15@email.com", email);
        this.type("Password@123", password);
        this.click(submitBtn);
        test.log(Status.INFO,"submit btn clicked");
    }

}
