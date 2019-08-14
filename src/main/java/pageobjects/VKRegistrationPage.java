package pageobjects;

import framework.SeleniumTestCase;
import framework.WebDriverCommands;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import static com.codeborne.selenide.Selenide.$;
import static framework.Constants.*;

public class VKRegistrationPage extends WebDriverCommands {

    private final String NAME_INPUT = "ij_first_name";
    private final String SURNAME_INPUT = "ij_last_name";
    private final String BIRTH_DAY_DROPDOWN = "//div[@class = 'ij_bday']";
    private final String BIRTH_DAY_DROPDOWN_VALUE = "//div[@class = 'ij_bday']/.//ul/li[@title = '%s']";
    private final String BIRTH_MONTH_DROPDOWN = "//div[@class = 'ij_bmonth']";
    private final String BIRTH_MONTH_DROPDOWN_VALUE = "//div[@class = 'ij_bmonth']/.//ul/li[@title = '%s']";
    private final String BIRTH_YEAR_DROPDOWN = "//div[@class = 'ij_byear']";
    private final String BIRTH_YEAR_DROPDOWN_VALUE = "//div[@class = 'ij_byear']/.//ul/li[@title = '%s']";
    private final String GENDER_FEMALE_RADIOBUTTON = "//div[contains(text(), 'Женский')]";
    private final String GENDER_MALE_RADIOBUTTON = "//div[contains(text(), 'Мужской')]";
    private final String CONTINUE_REGISTRATION_BUTTON = "ij_submit";

    public VKRegistrationPage(){
    }

    private static VKRegistrationPage vkRegistrationPage = null;

    public static VKRegistrationPage getVKRegistrationPage(){
        if(vkRegistrationPage == null)
            vkRegistrationPage = new VKRegistrationPage();

        return vkRegistrationPage;
    }

    public VKVerificationPage registerVK (String firstNameValue, String lastNameValue, String birthDayValue, String birthMonthValue, String birthYearValue, String genderValue) throws Exception{

        goToPage(VKUrl);
        $(Selectors.byId(NAME_INPUT)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).setValue(firstNameValue);
        $(Selectors.byId(SURNAME_INPUT)).waitUntil(Condition.visible, CONSTANT_10_SECONDS).setValue(lastNameValue);
        $(Selectors.byXpath(BIRTH_DAY_DROPDOWN)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        $(Selectors.byXpath(String.format(BIRTH_DAY_DROPDOWN_VALUE, birthDayValue))).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        $(Selectors.byXpath(BIRTH_MONTH_DROPDOWN)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        $(Selectors.byXpath(String.format(BIRTH_MONTH_DROPDOWN_VALUE, birthMonthValue))).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        $(Selectors.byXpath(BIRTH_YEAR_DROPDOWN)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        $(Selectors.byXpath(String.format(BIRTH_YEAR_DROPDOWN_VALUE, birthYearValue))).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        $(Selectors.byId(CONTINUE_REGISTRATION_BUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        if (genderValue.equals(femaleGender))
            $(Selectors.byXpath(GENDER_FEMALE_RADIOBUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        else if(genderValue.equals(maleGender))
            $(Selectors.byXpath(GENDER_MALE_RADIOBUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        $(Selectors.byId(CONTINUE_REGISTRATION_BUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();

        return new VKVerificationPage();

    }

}
