package io.github.britka.pages.registration;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.signin.SignInPage;

/**
 * Created by Serhii Bryt
 * 15.03.2024 16:16
 **/
public class AfterActivationPage {
    Page page = DriverHolder.getInstance().getPage();

    public SignInPage pressLogin(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
        return new SignInPage();
    }
}
