import framework.SeleniumTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.VKRegistrationPage;

public class VKLoginTest extends SeleniumTestCase {

    @Test(dataProvider = "registerPositiveData", enabled = true) //registerNegativeData
    public void CheckRegisterPositiveTest(String firstNameValue, String lastNameValue, String birthDayValue, String birthMonthValue, String birthYearValue, String genderValue) throws Exception {

        VKRegistrationPage
                .getVKRegistrationPage()
                .registerVK(firstNameValue, lastNameValue, birthDayValue, birthMonthValue, birthYearValue, genderValue)
                .checkHeader()
        ;
    }

    @DataProvider
    public Object[][] registerPositiveData() {
        return new Object[][]{
                {
                        "testName",
                        "testSurname",
                        "7",
                        "Января",
                        "2000",
                        "Женский",
                }
        };
    }

    @DataProvider
    public Object[][] registerNegativeData() {
        return new Object[][]{
                {
                        "testName",
                        "testSurname",
                        "7",
                        "Января",
                        "2000",
                        "Не определился",
                }
        };
    }

}
