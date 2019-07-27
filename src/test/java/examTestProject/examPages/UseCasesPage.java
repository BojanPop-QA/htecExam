package examTestProject.examPages;

import examTestProject.Browser;
import examTestProject.PropertyValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UseCasesPage extends Pages {

    public UseCasesPage (WebDriver driver) {
        super(driver);
    }

    //WebELements
    By createUseCaseButton = By.cssSelector("a[href='/create-usecase'");

    public boolean isAt() {
        waitVisibility(createUseCaseButton);
        return Browser.GetUrl().equals(PropertyValues.useCasesPageUrl);
    }
}
