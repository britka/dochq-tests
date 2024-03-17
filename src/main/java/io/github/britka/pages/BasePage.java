package io.github.britka.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.menu.NavigationMenu;
import io.qameta.allure.Step;

/**
 * Created by Serhii Bryt
 * 15.03.2024 11:04
 **/
public class BasePage {
    protected Page page = DriverHolder.getInstance().getPage();

    public NavigationMenu menu() {
        return new NavigationMenu();
    }

    @Step("Switch to individuals and families")
    public IndividualsBasePage switchToIndividualsAndFamilies() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("INDIVIDUALS & FAMILIES")).click();
        return new IndividualsBasePage();
    }

    @Step("Switch to business")
    public BasePage switchToBusiness() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BUSINESSES")).click();
        return new BasePage();
    }

}
