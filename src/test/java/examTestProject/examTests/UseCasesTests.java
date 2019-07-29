package examTestProject.examTests;

import examTestProject.examPages.CreateUseCasePage;
import examTestProject.examPages.DashboardPage;
import examTestProject.examPages.LoginPage;
import examTestProject.examPages.UseCasesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UseCasesTests extends  BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UseCasesPage useCasesPage;
    CreateUseCasePage createUseCasePage;


    @BeforeMethod
    public void setup()
    {
        loginPage= homePage.goToLoginPage();
        dashboardPage = loginPage.goToDashBoardPage();
    }

    @Test(priority=0)
    public void goToUseCasePageTest () {
        useCasesPage = dashboardPage.goToUseCasesPage();
        assertTrue(useCasesPage.isAt());
    }

    @Test(priority=1)
    public void createUseCaseWithMinimumAmountOfCharacters () {
        useCasesPage = dashboardPage.goToUseCasesPage();
        createUseCasePage = useCasesPage.createUseCase()
                .enterTitle("Fives")
                .enterDescription("Use case with minimum length characters")
                .enterExpectedResult("12345")
                .enterFirstStep("Step")
                .submit();
        assertTrue(useCasesPage.isThereUseCaseInTheList("Fives"));
    }

    @Test(priority=2)
    public void createUseCaseWithMaximumAmountOfCharacters () {
        String text_255char= "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,";

        useCasesPage = dashboardPage.goToUseCasesPage();
        createUseCasePage = useCasesPage.createUseCase()
                .enterTitle(text_255char)
                .enterDescription("Use case with maximum length characters")
                .enterExpectedResult(text_255char)
                .enterFirstStep("Step")
                .submit();
        assertTrue(useCasesPage.isThereUseCaseInTheList(text_255char));
    }


    @Test(priority=3)
    public void createUseCaseWithMoreStepsWithAddStepButton () {
        useCasesPage = dashboardPage.goToUseCasesPage();
        createUseCasePage = useCasesPage.createUseCase()
                .enterTitle("Multiple Steps - Add Step")
                .enterDescription("Use case with multiple steps using Add Step Button")
                .enterExpectedResult("Use Case have multiple steps using ADD STEP")
                .addStep()
                .addStep()
                .addStep()
                .enterSteps()
                .submit();
        createUseCasePage = useCasesPage.openFirstUseCase();
        assertTrue(createUseCasePage.verifyUseCaseSteps());
    }

    @Test(priority=4)
    public void createUseCaseWithMoreStepsWithDivider()
    {
        String definedSteps = "First Step,Second Step,Third Step";
        useCasesPage = dashboardPage.goToUseCasesPage();
        createUseCasePage = useCasesPage.createUseCase()
                .enterTitle("Multiple Steps - Divider")
                .enterDescription("Use case with multiple steps using divider on one field")
                .enterExpectedResult("Use Case have multiple steps using divider")
                .enterFirstStep(definedSteps)
                .submit();
        createUseCasePage = useCasesPage.openFirstUseCase();
        assertTrue(createUseCasePage.verifyDividerUseCaseSteps());
    }

    @Test(priority=5)
    public void replaceTextWithNumberOfCharacters()
    {
        useCasesPage = dashboardPage.goToUseCasesPage();
        useCasesPage.replaceLastFourCreatedTests();
        assertTrue(useCasesPage.areLastFourCreatedTestReplaced());

    }



}
