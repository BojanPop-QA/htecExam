package examTestProject.examPages;

import examTestProject.Browser;
import examTestProject.PropertyValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Pages {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    //WebElements
    By emailField = By.name("email");
    By passwordField = By.name("password");
    By submitButton = By.className("btn-primary");
    By invalidEmail = By.cssSelector("form .form-group:nth-of-type(1) .invalid-feedback");
    By invalidPassword = By.cssSelector("form .form-group:nth-of-type(2) .invalid-feedback");

    public boolean isAt()
    {
        return Browser.GetUrl().equals(PropertyValues.loginPageUrl);
    }

    public LoginPage enterEmail(String email)
    {
        writeText(emailField, email);
        return this;
    }

    public LoginPage enterPassword(String password)
    {
        writeText(passwordField, password);
        return this;
    }

    public String getEmailErrorText()
    {
        return readText(invalidEmail);
    }

    public String getPasswordErrorText()
    {
        return readText(invalidPassword);
    }

    public LoginPage submit()
    {
        click(submitButton);
        return this;
    }

    public DashboardPage goToDashBoardPage()
    {
        enterEmail(PropertyValues.validEmail);
        enterPassword(PropertyValues.validPassword);
        submit();
        return new DashboardPage(driver);
    }
}
