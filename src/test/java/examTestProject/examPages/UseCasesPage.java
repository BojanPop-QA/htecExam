package examTestProject.examPages;

import examTestProject.Browser;
import examTestProject.PropertyValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UseCasesPage extends Pages {

    public UseCasesPage (WebDriver driver) {
        super(driver);
    }

    //WebELements
    By createUseCaseButton = By.cssSelector("a[href='/create-usecase']");
    By firstUseCase = By.cssSelector("div.mt-5>a:first-of-type");

    public boolean isAt() {
        waitVisibility(createUseCaseButton);
        return Browser.GetUrl().equals(PropertyValues.useCasesPageUrl);
    }

    public boolean isThereUseCaseInTheList(String title)
    {
        if (readText(firstUseCase).equals(title))
            return true;
        else return false;
    }

    public CreateUseCasePage createUseCase()
    {
        click(createUseCaseButton);
        return new CreateUseCasePage(driver);
    }

    public  CreateUseCasePage openFirstUseCase()
    {
        click(firstUseCase);
        return new CreateUseCasePage(driver);
    }

   public void replaceLastFourCreatedTests()
   {
       WebElement usecase ;
       CreateUseCasePage useCasePage= new CreateUseCasePage(driver);
       for(int i =0; i<4 ;i++)
       {
           waitVisibility(createUseCaseButton);
           List<WebElement> allUseCases = driver.findElements(By.cssSelector("a[href*='/use-cases']"));
          usecase = allUseCases.get(i);
          usecase.click();
          useCasePage.replaceFields();
       }
   }

   public boolean areLastFourCreatedTestReplaced()
   {
       WebElement usecase ;
       List allTrue = new ArrayList();
       for(int i =0; i<4 ;i++)
       {
           waitVisibility(createUseCaseButton);
           List<WebElement> allUseCases = driver.findElements(By.cssSelector("a[href*='/use-cases']"));
           usecase = allUseCases.get(i);
           if(usecase.getText().contains("This field previously had"))
               allTrue.add(true);
           else allTrue.add(false);
       }

       if (allTrue.contains(false))
           return false;
       else return true;


   }



}
