package examTestProject.examTests;

import examTestProject.PropertyValues;
import examTestProject.examPages.DashboardPage;
import examTestProject.examPages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends  BaseTest{

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void goToLoginPageTest () {
        //*************PAGE METHODS********************
        loginPage = homePage.goToLoginPage();
        assertTrue(loginPage.isAt());
    }

    @Test
    public void emailFieldIsRequiredTest()
    {
        loginPage = homePage.goToLoginPage()
                    .enterEmail("")
                    .enterPassword("password")
                    .submit();
        assertEquals(loginPage.getEmailErrorText(),"Email field is required");
    }

    @Test
    public void passwordFieldIsRequiredTest()
    {
        loginPage = homePage.goToLoginPage()
                    .enterEmail("email@mai.com")
                    .enterPassword("")
                    .submit();
        assertEquals(loginPage.getPasswordErrorText(),"Password is required");
    }

    //TestData ?
    @Test
    public void passwordMustBeAtLeast6CharactersLongTest()
    {
        loginPage = homePage.goToLoginPage()
                .enterEmail("email@mai.com")
                .enterPassword("a")
                .submit();
        assertEquals(loginPage.getPasswordErrorText(),"Password must be at least 6 characters long");
    }

    @Test
    public void passwordMustBeValid()
    {
        loginPage = homePage.goToLoginPage()
                .enterEmail(PropertyValues.validEmail)
                .enterPassword("InvalidPassword")
                .submit();
        assertEquals(loginPage.getPasswordErrorText(),"Password incorrect");
    }


    @Test
    public void userMustBeRegistered()
    {
        loginPage = homePage.goToLoginPage()
                .enterEmail("invalidUser@email.com")
                .enterPassword("InvalidPassword")
                .submit();
        assertEquals(loginPage.getEmailErrorText(),"User not found");
    }

    @Test
    public void loginWithValidUsernameAndPasswordTest()
    {
        loginPage= homePage.goToLoginPage();
        dashboardPage = loginPage.goToDashBoardPage();
        assertTrue(dashboardPage.isAt());
    }

}
