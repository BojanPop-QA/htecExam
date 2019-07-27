package examTestProject.examPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Pages{

    public HomePage (WebDriver driver) {
        super(driver);
    }

    //WebElements
    By loginButton = By.className("btn-secondary");

    //Go to LoginPage
    public LoginPage goToLoginPage (){
        click(loginButton);
        return new LoginPage(driver);
    }
}
