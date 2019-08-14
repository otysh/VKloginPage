package pageobjects;

import framework.WebDriverCommands;

public class VKHomePage extends WebDriverCommands {

    public VKHomePage(){
    }

    private static VKHomePage vkHomePage = null;

    public static VKHomePage getVKHomePage(){
        if(vkHomePage == null)
            vkHomePage = new VKHomePage();

        return vkHomePage;
    }

}
