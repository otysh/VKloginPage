package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import framework.WebDriverCommands;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static framework.Constants.CONSTANT_5_SECONDS;

public class VKVerificationPage extends WebDriverCommands {

    public VKVerificationPage(){
    }

    private static VKVerificationPage vkVerificationPage = null;

    public static VKVerificationPage getVKVerificationPage(){
        if(vkVerificationPage == null)
            vkVerificationPage = new VKVerificationPage();

        return vkVerificationPage;
    }

    private final String VERIFICATION_HEADER = "//h2[contains(text(), 'Подтверждение регистрации')]";

    public VKVerificationPage checkHeader() throws Exception{
        Assert.assertTrue($(Selectors.byXpath(VERIFICATION_HEADER)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).isDisplayed(), "Verification page is not shown!");

        return this;
    }

}
