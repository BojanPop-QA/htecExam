package examTestProject.examPages;

import examTestProject.Browser;
import examTestProject.PropertyValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateUseCasePage extends Pages {

    public CreateUseCasePage (WebDriver driver) {
        super(driver);
    }

    //WebElements
    By submitButton = By.cssSelector("button.btn-primary");
    By titleField = By.name("title");
    By descriptionField = By.name("description");
    By expectedResultField = By.name("expected_result");
    By useCaseStep1 = By.name("testStepId-0");
    By addStepButtom = By.className("text-primary");


    public boolean isAt() {
        waitVisibility(submitButton);
        return Browser.GetUrl().equals(PropertyValues.createUseCasesPageUrl);
    }


    public CreateUseCasePage enterTitle(String title)
    {
        writeText(titleField,title);
        return this;
    }

    public CreateUseCasePage enterDescription(String description)
    {
        writeText(descriptionField,description);
        return this;
    }

    public CreateUseCasePage enterExpectedResult(String result)
    {
        writeText(expectedResultField,result);
        return this;
    }

    public CreateUseCasePage enterFirstStep (String step)
    {
        writeText(useCaseStep1,step);
        return this;
    }

    public CreateUseCasePage addStep()
    {
        click(addStepButtom);
        return this;
    }

    public CreateUseCasePage enterSteps()
    {
        int i =1;
        List<WebElement> steps = driver.findElements(By.id("stepId"));
        for (WebElement step : steps)
        {
             step.sendKeys(String.format("Step " + i));
             i++;
        }
        return this;
    }

    public CreateUseCasePage submit ()
    {
        click(submitButton);
        return this;
    }

    public boolean verifyUseCaseSteps(){
        int i =1;
        List allTrue = new ArrayList();
        List<WebElement> steps = driver.findElements(By.id("stepId"));
        for (WebElement step : steps)
        {
            String a = step.getAttribute("value");
            if (step.getAttribute("value").equals(String.format("Step " + i)))
                allTrue.add(true);
            else
                allTrue.add(false);
            i++;
        }

        if (allTrue.contains(false))
                return false;
        else return true;
    }

    public boolean verifyDividerUseCaseSteps(){
        int i = 0;
        String definedSteps = "First Step,Second Step,Third Step";
        String[] eachStep = definedSteps.split(",");
        List allTrue = new ArrayList();
        List<WebElement> steps = driver.findElements(By.id("stepId"));
        for (WebElement step : steps)
        {
            if (step.getAttribute("value").equals(eachStep[i]))
                allTrue.add(true);
            else
                allTrue.add(false);
            i++;
        }

        if (allTrue.contains(false))
            return false;
        else return true;
    }


    public void replaceFields()
    {
        int titleLength = getValue(titleField).length();
        int descriptionLength = getValue(descriptionField).length();
        int expectedResultLength = getValue(expectedResultField).length();

        List<WebElement> steps = driver.findElements(By.id("stepId"));
        for (WebElement step : steps)
        {
           String stepsLength = String.valueOf(step.getAttribute("value").length());
           step.clear();
           step.sendKeys("This field previously had "+ stepsLength +" characters");
        }

        writeText(titleField, String.format("This field previously had %d characters", titleLength));
        writeText(descriptionField, String.format("This field previously had %d characters", descriptionLength));
        writeText(expectedResultField, String.format("This field previously had %d characters", expectedResultLength));

        click(submitButton);
    }




}
