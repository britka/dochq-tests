package io.github.britka.pages.registration;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.driver.DriverHolder;

/**
 * Created by Serhii Bryt
 * 15.03.2024 14:43
 **/
public class ActivateRequestPage {
    Page page = DriverHolder.getInstance().getPage();

    public void requestEmail(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("REQUEST EMAIL")).click();

    }

    public void changeAccount(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CHANGE ACCOUNT")).click();
    }
}
