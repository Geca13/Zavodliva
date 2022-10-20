package frontend.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import frontend.components.LoginModal;
import frontend.components.Navbar;
import frontend.pages.HomePage;
import frontend.pages.RegisterNewAdminPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class FrontEndTests {

    private HomePage home;
    private WebDriver driver;

    private Navbar navbar;

    private RegisterNewAdminPage newAdminPage;

    private LoginModal modal;

    private ExtentReports extent;

    private ExtentSparkReporter spark;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
        navbar = new Navbar(driver);
        newAdminPage = new RegisterNewAdminPage(driver);
        modal = new LoginModal(driver);
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

    }

    @org.testng.annotations.Test
    public void openHomePage(){
        ExtentTest test = extent.createTest("openHomePage", "Open zavodliva home page");
        home.openHomePage();
        test.pass("pass");
        extent.flush();
    }

    @org.testng.annotations.Test
    public void assertHomePageHeaderTitle(){
        home.openHomePage();
        Assert.assertEquals(home.getHeaderText(), "Заводлива Квечерина");
    }

    @org.testng.annotations.Test
    public void registerNewAdmin() throws InterruptedException {
        ExtentTest test1 = extent.createTest("registerNewAdmin", "Open zavodliva register page");
        newAdminPage.loadNewAdminPage();
        test1.log(Status.INFO, "register page loaded");
        newAdminPage.registerNewAdmin(test1);
        Thread.sleep(2000);
        Assert.assertEquals(home.homePageLinkIsInUrl(), "https://zavodlivakvecherina.herokuapp.com/");
        test1.log(Status.PASS, "USER REGISTRATED");
        extent.flush();
    }

    @org.testng.annotations.Test(priority = 1)
    public void loginWithNewUser(){
        home.openHomePage();
        navbar.clickLoginIcon();
        modal.loginModalIsOpened();
        modal.loginAsAdmin();
        navbar.newShowNavLinkIsDisplayed();

    }

    @org.testng.annotations.Test
    public void failLoginWithNewUser() throws InterruptedException {
        home.openHomePage();
        navbar.clickLoginIcon();
        modal.loginModalIsOpened();
        modal.failLoginAsAdmin();
        Thread.sleep(2000);
        Assert.assertEquals(home.homePageLinkIsInUrl(), "https://zavodlivakvecherina.herokuapp.com/?error");

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();;
    }
}
