package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import framework.WebDriverCommands;

import static com.codeborne.selenide.Selenide.$;
import static framework.Constants.CONSTANT_5_SECONDS;
import static framework.Constants.VKUrl;

public class VKLoginPage extends WebDriverCommands {

    private final String EMAIL_INPUT = "index_email"; //id
    private final String PASSWORD_INPUT = "index_pass"; //id
    private final String LOGIN_BUTTON = "index_login_button"; //id

    public VKLoginPage(){
    }

    private static VKLoginPage vkLoginPage = null;

    public static VKLoginPage getVKLoginPage(){
        if(vkLoginPage == null)
            vkLoginPage = new VKLoginPage();

        return vkLoginPage;
    }

    public VKHomePage loginVKPage(String nameValue, String pwdValue) throws Exception{

        goToPage(VKUrl);
        $(Selectors.byId(EMAIL_INPUT)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).setValue(nameValue);
        $(Selectors.byId(PASSWORD_INPUT)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).setValue(pwdValue);
        $(Selectors.byId(LOGIN_BUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();

        return new VKHomePage();
    }

}
