package io.github.britka.application;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.AppConfig;
import io.github.britka.application.navigation.AppNavigation;
import io.github.britka.driver.DriverHolder;
import io.qameta.allure.Step;

/**
 * Created by Serhii Bryt
 * 16.03.2024 20:04
 **/
public class Application {
    @Step
    public Application openApplication(){
        Page page = DriverHolder.getInstance().getPage();
        page.navigate(AppConfig.getProperty("BASE_URL"));
        page.getByRole(AriaRole.ALERTDIALOG)
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Accept and proceed"))
                .click();
        return this;
    }

    public Registration registration(){
        return new Registration();
    }

    public UserDashBoard dashBoard(){
        return new UserDashBoard();
    }

    public AppNavigation navigation(){
        return new AppNavigation();
    }

}
