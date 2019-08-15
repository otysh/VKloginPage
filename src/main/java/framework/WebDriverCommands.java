package framework;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

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

    public static void goToPageWithClearCache(String url)
    {
        try
        {
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
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

    public void waitTime(int secsToWait) {

        try {
            for (int second = 0; ; second++) {
                if ((second > secsToWait)) {
                    break;
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }

    }

    public void switchToNewTab(int tabNumber){ //tab number starts from 0

        ArrayList<String> newTab = new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles());
//        newTab.remove(oldTab);
        // change focus to new tab
        WebDriverRunner.getWebDriver().switchTo().window(newTab.get(tabNumber));
    }

    public void closeOldTab()
    {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(0));
        driver.close();
        tab.remove(tab.size());
    }

    public boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e)
        {
            return false;
        }
    }

    public void clear(By by){
        if (isElementPresent(by)){
            driver.findElement(by).clear();
        }
    }

    /**
     * Method send keys to element
     * @param by    By Element
     * @param value String value
     */
    public void sendKeys(By by, String value){
        if (isElementPresent(by)){
            driver.findElement(by).sendKeys(value);
        }
    }

    public boolean isElementDisplayed(By by)
    {
        return driver.findElement(by).isDisplayed();
    }

    /**
     * Wait for element not to be visible
     * @param by        By  Needed element to be waited for
     * @param timeOut   Integer Time limit for element not to be visible
     */
    public void waitForElementNotVisible(final By by, int timeOut)
    {
        (new WebDriverWait(driver, timeOut))
                .until(ExpectedConditions
                        .invisibilityOfElementLocated(by));
    }
    
}
