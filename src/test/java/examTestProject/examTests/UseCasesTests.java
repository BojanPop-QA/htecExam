package examTestProject.examTests;

import examTestProject.examPages.DashboardPage;
import examTestProject.examPages.LoginPage;
import examTestProject.examPages.UseCasesPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UseCasesTests extends  BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UseCasesPage useCasesPage;

    @BeforeTest
    public void setup()
    {
        loginPage= homePage.goToLoginPage();
        dashboardPage = loginPage.goToDashBoardPage();
    }

    @Test
    public void goToUseCasePageTest () {
        //*************PAGE METHODS********************
        useCasesPage = dashboardPage.goToUseCasesPage();
        assertTrue(useCasesPage.isAt());
    }


}
