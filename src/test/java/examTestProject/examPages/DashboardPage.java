package examTestProject.examPages;

import examTestProject.Browser;
import examTestProject.PropertyValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends Pages {

    public DashboardPage (WebDriver driver) {
        super(driver);
    }


    //WebELements
    By usesCasesCard = By.cssSelector("a[href='/use-cases'");

    public boolean isAt() {
        waitVisibility(usesCasesCard);
        return Browser.GetUrl().equals(PropertyValues.dashboardPageUrl);
    }

    public UseCasesPage goToUseCasesPage()
    {
        click(usesCasesCard);
        return new UseCasesPage(driver);
    }
}
