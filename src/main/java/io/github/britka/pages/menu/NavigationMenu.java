package io.github.britka.pages.menu;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.BasePage;

/**
 * Created by Serhii Bryt
 * 15.03.2024 11:20
 **/
public class NavigationMenu {
    Page page = DriverHolder.getInstance().getPage();

    public BasePage navigateTo(String mainMenuItem) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(mainMenuItem.toUpperCase())).click();
        return new BasePage();
    }

    public BasePage navigateTo(String mainMenuItem, String subMenuItem) {
        page.getByRole(AriaRole.PARAGRAPH, new Page.GetByRoleOptions().setName(mainMenuItem.toUpperCase()));
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(subMenuItem)).click();
        return new BasePage();
    }
}
