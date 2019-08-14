package framework;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebDriverCommands {

    public static String errorMessage = "";
    public static WebDriver driver;

    public static void shutDown(Throwable t)
    {

        errorMessage = errorMessage + "\n" + t.getMessage();
        System.out.println(errorMessage);


        getWebDriver().manage().deleteAllCookies();
        getWebDriver().quit();
        System.exit(1);
    }

    public static void editErrorMessage(String message)
    {
        errorMessage = errorMessage + "\n" + message;
    }

    public static void goToPage(String url)
    {
        try
        {
            driver.navigate().to(url);
        }
        catch (TimeoutException te)
        {
            $(byXpath("//body")).pressEscape();
        }
        catch (Throwable t)
        {
            shutDown(t);
        }

        editErrorMessage("go to page:" + url);

    }

}
