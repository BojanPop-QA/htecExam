package examTestProject.examTests;

import examTestProject.Browser;
import examTestProject.examPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    private WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void initialize() {

        driver = new Browser().SetBrowser();
        homePage= new HomePage(getDriver());
    }

    @AfterMethod
    public void close()
    {
        Browser.Close();
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
