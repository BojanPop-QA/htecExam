package examTestProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Browser {


    private static WebDriver _webDriver;
    private String _baseUrl = PropertyValues.baseUrl;

    public WebDriver SetBrowser() {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = new File(classLoader.getResource("chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver",path);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("chrome.switches", "--disable-extensions", "test-type", "start-maximized");
        _webDriver = new ChromeDriver(chromeOptions);

        Goto(" ", _baseUrl);
        return _webDriver;
    }

    public static String GetUrl(){
        return _webDriver.getCurrentUrl();
    }

    public static String GetTitle()
    {
        return _webDriver.getTitle();
    }

    public static void Goto(String url, String _baseUrl)
    {
        _webDriver.navigate().to(_baseUrl + url);
    }

    public static void Close(){
        _webDriver.close();
        _webDriver.quit();
    }
}
